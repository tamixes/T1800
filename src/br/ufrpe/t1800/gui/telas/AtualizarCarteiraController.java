package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.dao.RepositorioCarteira;
import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ErroAoRemoverException;
import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.Carteira;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AtualizarCarteiraController implements Initializable{

	@FXML
	private JFXButton btn_atualizar, btn_remover, btn_voltar;
	@FXML
	private JFXTextField tit_cart, valor_cart, desc_carteira;
	@FXML
	private Label aviso;
	@FXML
	private TableView<Carteira> tabela_carteira;
	@FXML
	private TableColumn<Carteira, String> titulo;
	@FXML
	private TableColumn<Carteira, String> descricao;
	@FXML
	private TableColumn<Carteira, Double> valor;
	
	
	private ObservableList<Carteira> carteiras;
	private Carteira c;
	private Fachada controller;
	
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		controller = Fachada.getInstance();
		tabela_carteira.setEditable(false);
		carteiras = FXCollections.observableArrayList(controller.listarCarteira());
		
		titulo = new TableColumn<>("Titulo");
		titulo.setResizable(true);
		
		descricao = new TableColumn<>("Descrição");
		descricao.setResizable(true);
		
		valor = new TableColumn<>("Valor");
		valor.setResizable(true);
		
		tabela_carteira.getColumns().addAll(titulo, descricao, valor);
		
		titulo.setCellValueFactory(new PropertyValueFactory<Carteira, String>("Titulo"));
		descricao.setCellValueFactory(new PropertyValueFactory<Carteira, String>("Descrição"));
		valor.setCellValueFactory(new PropertyValueFactory<Carteira, Double>("Valor"));
		
		
		tabela_carteira.setItems(carteiras);
		
		tabela_carteira.setOnMouseClicked(e ->{
			
		c = tabela_carteira.getSelectionModel().getSelectedItem();
		
		tit_cart.setText(c.getTitulo());
		tit_cart.setEditable(true);
		
		desc_carteira.setText(c.getDescricao());
		desc_carteira.setEditable(true);
		
		valor_cart.setText(c.getDescricao());
		valor_cart.setEditable(true);
		
		
		});
			}
	
	@FXML
	public void btnAtualizar(ActionEvent event) {
		String valor, titulo, descricao;
		
		titulo = tit_cart.getText();
		valor = valor_cart.getText();
		descricao = desc_carteira.getText();
		
		
		try {
			double v = Double.parseDouble(valor);
			Carteira carteira = new Carteira(titulo, descricao, v);
			try {
				Fachada.getInstance().atualizarCarteira(carteira);
				RepositorioCarteira.getInstance().salvarArquivo();
				
				try {
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText("Carteira atualizada com sucesso");
					alert.setTitle("Carteira atualizada");
					alert.showAndWait();
					
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.getStackTrace();
				}
			} catch (ErroAoAtualizarException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erro ao atualizar!");
				alert.setContentText("Não foi possível atualizar!");
				alert.showAndWait();
			}
			} catch (Exception e) {
			// TODO: handle exception
		}
		
	
	}
	
	@FXML
	public void btnRemover(ActionEvent event) {
		String valor, titulo, descricao;
		
		titulo = tit_cart.getText();
		valor = valor_cart.getText();
		descricao = desc_carteira.getText();
		
		
		try {
			double v = Double.parseDouble(valor);
			Carteira carteira = new Carteira(titulo, descricao, v);
			try {
				Fachada.getInstance().removerCarteira(carteira);
				RepositorioCarteira.getInstance().salvarArquivo();
				
				try {
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText("Carteira removida com sucesso");
					alert.setTitle("Carteira removida");
					alert.showAndWait();
					
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.getStackTrace();
				}
			} catch (ErroAoRemoverException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erro ao remover!");
				alert.setContentText("Não foi possível remover!");
				alert.showAndWait();
			}
			} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@FXML
	public void btnVoltar(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
		Parent p = null;
		
		try {
			p = FXMLLoader.load(MenuCarteira.class.getResource("MenuCarteira.fxml"));
			Scene scene = new Scene(p);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("T1800 Finanças Pessoais");
			stage.show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

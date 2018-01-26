package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.dao.RepositorioCarteira;
import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ErroAoRemoverException;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.Carteira;
import br.ufrpe.t1800.negocio.beans.Pessoa;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AtualizarCarteiraController implements Initializable{

	@FXML
	private JFXButton btn_atualizar, btn_voltar, btn_buscar;
	@FXML
	private JFXTextField tit_cart, desc_carteira, valor_carteira, id_carteira;
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
	@FXML
	private TableColumn<Carteira, String> id;
	@FXML
	private JFXComboBox<Pessoa> lista_pessoas;
	
	public static String codigo;
	
	public static String getCogigo(){
		return codigo;
	}
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
		
		descricao = new TableColumn<>("Descricao");
		descricao.setResizable(true);
		
		valor = new TableColumn<>("Valor");
		valor.setResizable(true);
		
		id = new TableColumn<>("ID");
		id.setResizable(true);
		
		tabela_carteira.getColumns().addAll(titulo, descricao, valor, id);
		
		titulo.setCellValueFactory(new PropertyValueFactory<Carteira, String>("Titulo"));
		descricao.setCellValueFactory(new PropertyValueFactory<Carteira, String>("Descricao"));
		valor.setCellValueFactory(new PropertyValueFactory<Carteira, Double>("Valor"));
		id.setCellValueFactory(new PropertyValueFactory<Carteira, String>("ID"));
		
		tabela_carteira.setItems(carteiras);
		
		
		
		tabela_carteira.setOnMouseClicked(e ->{
			
		c = tabela_carteira.getSelectionModel().getSelectedItem();
		
		tit_cart.setText(c.getTitulo());	
		desc_carteira.setText(c.getDescricao());
		valor_carteira.setText(Double.toString(c.getValor()));
		lista_pessoas.setValue(c.getPessoa());		
		
		});
		
		btn_buscar.setOnAction( e ->{
			tit_cart.setText(this.buscarCarteira().getTitulo());
			valor_carteira.setText(Double.toString(this.buscarCarteira().getValor()));
			descricao.setText(this.buscarCarteira().getDescricao());
		});
		
		

		Callback<ListView<Pessoa>, ListCell<Pessoa>> f = new Callback<ListView<Pessoa>, ListCell<Pessoa>>(){

			
			public ListCell<Pessoa> call(ListView<Pessoa> param) {
				
				return new ListCell<Pessoa>() {
					protected void updateItem(Pessoa item, boolean empty) {
						super.updateItem(item, empty);
						setText(empty ? "" : item.getNome());
					}
				};
			}
			
		};
	
	
		
		lista_pessoas.setCellFactory(f);
		lista_pessoas.setButtonCell(f.call(null));
		}
	
	@FXML
	public void btnAtualizar(ActionEvent event) {
	
		String titulo = tit_cart.getText();
		String v = valor_carteira.getText();
		String descricao = desc_carteira.getText();
		
		if(!this.tit_cart.getText().isEmpty() || !this.desc_carteira.getText().isEmpty() 
				|| !this.valor_carteira.getText().isEmpty() && lista_pessoas != null) {
			try {
				double valor = Double.parseDouble(v);
			
				Carteira carteira = new Carteira(lista_pessoas.getValue(), valor, titulo, descricao);
				
				try {
					
					Fachada.getInstance().atualizarCarteira(carteira);
					RepositorioCarteira.getInstance().salvarArquivo();
					atualiza();
					
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
				System.out.println(e.getMessage());
			}
		}else {
		
		}
	
	}
	
		
	@FXML
	public void btnBuscar(ActionEvent event) {
		
	}
	
	@FXML
	public Carteira buscarCarteira () {
		Carteira c = null; 
		
			try {
			Fachada.getInstance().buscarCarteira(id_carteira.getText());
			
		} catch (ObjetoNaoExisteException e) {
			System.out.println(e.getMessage());
			this.aviso.setText("Não encontrado!");		}
		
		
		return c;
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
	
	@FXML
	public void atualiza() {
		tabela_carteira.getItems().clear();
		tabela_carteira.getItems().addAll(Fachada.getInstance().listarCarteira());
	}
}

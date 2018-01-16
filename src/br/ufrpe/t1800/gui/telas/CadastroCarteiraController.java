package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.dao.RepositorioCarteira;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.Carteira;
import br.ufrpe.t1800.negocio.beans.Pessoa;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;

public class CadastroCarteiraController implements Initializable {

	@FXML
	private JFXButton btn_salvar, btn_voltar;
	@FXML
	private JFXComboBox<Pessoa> pessoas_cart;
	@FXML
	private JFXTextField titulo_cart, valor_cart, descricao_cart;
	
	
	@FXML
	public void btnSalvar(ActionEvent event) {
		String titulo = titulo_cart.getText();
		String v = valor_cart.getText();
		String descricao = descricao_cart.getText();
		
		if(!this.titulo_cart.getText().isEmpty() || !this.descricao_cart.getText().isEmpty() 
				|| !this.valor_cart.getText().isEmpty() && pessoas_cart != null) {
			try {
				double valor = Double.parseDouble(v);
			
				Carteira carteira = new Carteira(pessoas_cart.getValue(), valor, titulo, descricao);
				
				try {
					
					Fachada.getInstance().cadastrarCarteira(carteira);
					RepositorioCarteira.getInstance().salvarArquivo();
					
					try {
						
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setHeaderText("Carteira cadastrada com sucesso\nCodigo: " + carteira.getIdCarteira());
						alert.setTitle("Carteira cadastrada");
						alert.showAndWait();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.getStackTrace();
					}
				} catch (ObjetoJaExisteException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Erro ao cadastrar!");
					alert.setContentText("Carteira já existe!");
					alert.showAndWait();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}else {
		
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
	
	
	
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
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
	
	
		pessoas_cart.setItems(FXCollections.observableArrayList(Fachada.getInstance().listarPessoa()));
		pessoas_cart.setCellFactory(f);
		pessoas_cart.setButtonCell(f.call(null));
	
	}
	
		
			
		
	}
	


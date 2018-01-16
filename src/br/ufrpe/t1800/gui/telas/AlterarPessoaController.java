package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.negocio.Fachada;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AlterarPessoaController implements Initializable{

	
	@FXML
	private JFXTextField nome_pessoa, telefone_pessoa, email_pessoa, login_pessoa;
	@FXML
	private JFXPasswordField senha_pessoa;
	@FXML
	private JFXButton salvar_pessoa, btn_voltar;
	@FXML
	private Label aviso;
	@FXML
	private TableView<Pessoa> lista_pessoa;
	@FXML
	private TableColumn<Pessoa, String> nome;
	@FXML
	private TableColumn<Pessoa, String> telefone;
	@FXML
	private TableColumn<Pessoa, String> email;
	@FXML
	private TableColumn<Pessoa, String> login;
	@FXML
	private TableColumn<Pessoa, String> senha;
	
	private ObservableList<Pessoa> pessoas;
	private Pessoa p;
	private Fachada controller;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		controller = Fachada.getInstance();
		lista_pessoa.setEditable(false);
		pessoas = FXCollections.observableArrayList(controller.listarPessoa());
		
		nome = new TableColumn<>("Nome");
		nome.setResizable(true);
		
		telefone = new TableColumn<>("Telefone");
		telefone.setResizable(true);
		
		email = new TableColumn<>("Email");
		email.setResizable(true);
		
		login = new TableColumn<>("Login");
		login.setResizable(true);
		
		
		
		lista_pessoa.getColumns().addAll(nome, telefone, email, login);
		
		nome.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("Nome"));
		telefone.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("Telefone"));
		email.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("Email"));
		login.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("Login"));
		
		
		lista_pessoa.setItems(pessoas);
		
		/*lista_pessoa.setOnMouseClicked(e -> {
			
			
			p = lista_pessoa.getSelectionModel().getSelectedItem();
			
			nome_pessoa.setText(p.getNome());
			nome_pessoa.setEditable(true);
			
			telefone_pessoa.setText(p.getTelefone());
			telefone_pessoa.setEditable(true);
			
			email_pessoa.setText(p.getTelefone());
			email_pessoa.setEditable(true);
			
			login_pessoa.setText(p.getUsuario().getLogin());
			login_pessoa.setEditable(true);
			
			senha_pessoa.setText(p.getUsuario().getSenha());
			login_pessoa.setEditable(true);
			
			
		});*/
		
		
	
		
		
	}	
	
	@FXML
	public void salvarPessoa(ActionEvent event) {
		
	}
	
	@FXML
	public void btnVoltar(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
		Parent p = null;
		
		try {
			p = FXMLLoader.load(MenuEscolhas.class.getResource("MenuEscolhas.fxml"));
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

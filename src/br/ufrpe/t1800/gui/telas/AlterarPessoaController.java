package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.dao.RepositorioPessoa;
import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.Pessoa;
import br.ufrpe.t1800.negocio.beans.Usuario;
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
	private TableView<Pessoa> lista_pessoas;
	@FXML
	private TableColumn<Pessoa, String> nome;
	@FXML
	private TableColumn<Pessoa, String> telefone;
	@FXML
	private TableColumn<Pessoa, String> email;
	@FXML
	private TableColumn<Pessoa, String> login;
	
	
	private ObservableList<Pessoa> pessoas;
	private Pessoa p;
	private Fachada controller;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		controller = Fachada.getInstance();
		lista_pessoas.setEditable(false);
		pessoas = FXCollections.observableArrayList(controller.listarPessoa());
		
		
		nome = new TableColumn<>("Nome");
		nome.setResizable(true);
		
		telefone = new TableColumn<>("Telefone");
		telefone.setResizable(true);
		
		email = new TableColumn<>("Email");
		email.setResizable(true);
		
		login = new TableColumn<>("Login");
		login.setResizable(true);
		
		lista_pessoas.getColumns().addAll(nome, telefone, email, login);
		
		nome.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("Nome"));
		email.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("Email"));
		telefone.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("Telefone"));
		login.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("Login"));
		
		lista_pessoas.setItems(pessoas);
	}	
	
	@FXML
	public void salvarPessoa(ActionEvent event) {
		String nome, telefone, email, login, senha;
		
		nome = nome_pessoa.getText();
		telefone = telefone_pessoa.getText();
		email = email_pessoa.getText();
		login = login_pessoa.getText();
		senha = senha_pessoa.getText();
		
		if(!nome.equals("") && !telefone.equals("") && !email.equals("") && !login.equals("") && !senha.equals("")) {
			try {
				Usuario usuario = new Usuario(login, senha);
				Pessoa pessoa = new Pessoa(nome, email, telefone, usuario);
				
				try {
					Fachada.getInstance().atualizarPessoa(pessoa);
					RepositorioPessoa.getInstance().salvarArquivo();
					System.out.println("Salvo!");
					
				} catch (ErroAoAtualizarException e) {
					
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Erro ao atualizar!");
					alert.setContentText("Não foi possivel atualizar!");
					alert.showAndWait();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}else {
			aviso.setText("Preencha todos os campos!");
		}
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

package br.ufrpe.t1800.gui.login;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.dao.RepositorioPessoa;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.Pessoa;
import br.ufrpe.t1800.negocio.beans.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CadastroPessoaController implements Initializable{

	
	@FXML
	private JFXTextField nome_pessoa, telefone_pessoa, email_pessoa, login_pessoa;
	@FXML
	private JFXPasswordField senha_pessoa;
	@FXML
	private JFXButton salvar_pessoa, btn_voltar;
	@FXML
	private Label aviso;
	
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
					Fachada.getInstance().cadastrarPessoa(pessoa);
					RepositorioPessoa.getInstance().salvarArquivo();
					System.out.println("Salvo!");
					((Node) (event.getSource())).getScene().getWindow().hide();
				} catch (ObjetoJaExisteException e) {
					
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Erro ao cadastrar!");
					alert.setContentText("Pessoa já existe!");
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
			p = FXMLLoader.load(TelaPrincipal.class.getResource("TelaPrincipal.fxml"));
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
		// TODO Auto-generated method stub
		
	}

}

package br.ufrpe.t1800.gui.login;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.gui.telas.MenuEscolhas;
import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoginPessoaController implements Initializable{

	@FXML
	private JFXButton btn_logar, btn_voltar;
	@FXML
	private JFXPasswordField senha_login;
	@FXML
	private JFXTextField login_pessoa;
	@FXML
	private Label aviso;
	
	
	
	

	@FXML
	public void btnLogar(ActionEvent event) {
	String login, senha; 
		
		
		login = login_pessoa.getText();
		senha = senha_login.getText();
		
		if(login.equals("") || senha.equals("")) {	
			aviso.setText("Preencha todos os campos!");
		}else if(Fachada.getInstance().verificaLogin(new Usuario(login, senha))) {
			aviso.setText("");
			((Node) (event.getSource())).getScene().getWindow().hide();
			Parent p = null;
			try {
				p = FXMLLoader.load(MenuEscolhas.class.getResource("MenuEscolhas.fxml"));
				Scene scene = new Scene(p);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.setTitle("T1800 Finanças Pessoais");
				stage.setResizable(false);
				stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			aviso.setText("Invalido\nTente novamente!");
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

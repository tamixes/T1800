package br.ufrpe.t1800.gui.login;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class TelaPrincipalController implements Initializable{


	@FXML
	private JFXButton btn_login;
	@FXML
	private JFXButton btn_register;
	@FXML
	private Label erro;
	
	
	
	
	@FXML
	public void btnRegister(ActionEvent event) {
		Parent p1 = null;
		try {
			p1 = FXMLLoader.load(getClass().getResource("CadastroPessoa.fxml"));
			Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow(); 
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("T1800 Finanças Pessoais");
			
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	
	
	@FXML
	public void btnLogar(ActionEvent event) {
		Parent p1 = null;
		try {
			p1 = FXMLLoader.load(getClass().getResource("LoginPessoa.fxml"));
			Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow(); 
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("T1800 Finanças Pessoais");
			
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
	}
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

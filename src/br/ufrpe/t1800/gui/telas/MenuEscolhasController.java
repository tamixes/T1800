package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.ufrpe.t1800.gui.login.TelaPrincipal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuEscolhasController implements Initializable{

	
	@FXML
	private JFXButton btn_carteira, btn_receita, btn_cartao, btn_despesa, btn_dados, btn_voltar;
	
	
	@FXML
	public void btnCarteira(ActionEvent event) {
		
	}
	
	@FXML
	public void btnReceita(ActionEvent event) {
		
	}
	
	@FXML
	public void btnCartao(ActionEvent event) {
		
	}
	
	@FXML
	public void btnDespesa(ActionEvent event) {
		
	}
	@FXML
	public void btnDados(ActionEvent event) {
		
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

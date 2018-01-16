package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.Carteira;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BuscarCarteiraController implements Initializable{

	
	@FXML
	private JFXTextField cod_cart;
	@FXML
	private JFXButton btn_pesquisa, btn_voltar;
	@FXML
	private Label printa, aviso;
	
	public static String codigo;
	
	public static String getCogigo(){
		return codigo;
	}
	
	@FXML
	public void btnPesquisa(ActionEvent event) {
		if(this.cod_cart.getText().isEmpty()) {
			this.aviso.setText("Informe o código da carteira!");
		}else {
			try {
				Carteira c = Fachada.getInstance().buscarCarteira(this.cod_cart.getText());
				codigo = cod_cart.getText();
				this.aviso.setText("");
				this.printa.setText(c.toString());
				
			} catch (ObjetoNaoExisteException e) {
				System.out.println(e.getMessage());
				this.aviso.setText("Não encontrado!");
			}
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
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

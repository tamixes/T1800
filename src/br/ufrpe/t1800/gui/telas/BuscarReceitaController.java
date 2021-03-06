package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.Carteira;
import br.ufrpe.t1800.negocio.beans.Pdf;
import br.ufrpe.t1800.negocio.beans.Receita;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BuscarReceitaController implements Initializable {

	
	
	
	@FXML
	private JFXTextField nome_receita;
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
		if(this.nome_receita.getText().isEmpty()) {
			this.aviso.setText("Informe o nome da receita!");
		}else {
			try {
				Receita r = Fachada.getInstance().buscarReceita(this.nome_receita.getText());
				
				this.aviso.setText("");
			
				this.printa.setText(r.toString());
				
				
			} catch (ObjetoNaoExisteException e) {
				System.out.println(e.getMessage());
				this.aviso.setText("N�o encontrado!");
			}
		}
	}
	
	
	@FXML
	public void btnVoltar(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
		Parent p = null;
		
		try {
			p = FXMLLoader.load(MenuReceita.class.getResource("MenuReceita.fxml"));
			Scene scene = new Scene(p);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("T1800 Finan�as Pessoais");
			stage.show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			
	}

}

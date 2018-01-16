package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.DespesaCartao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BuscarDespesaCartaoController implements Initializable{

	@FXML
	private JFXButton btn_pesquisa, btn_voltar;
	@FXML
	private Label printa, aviso;
	@FXML
	private JFXTextField nome_busca;
	
	
	@FXML
	public void btnPesquisa(ActionEvent event) {
		if(this.nome_busca.getText().isEmpty()) {
			this.aviso.setText("Informe o nome da despesa no cartão!");
		}else {
			try {
				
				DespesaCartao d = Fachada.getInstance().buscarDespesaCartao(this.nome_busca.getText());
			
				
				this.aviso.setText("");
				this.printa.setText(d.toString());
				
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
			p = FXMLLoader.load(MenuDespesaCartao.class.getResource("MenuDespesaCartao.fxml"));
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

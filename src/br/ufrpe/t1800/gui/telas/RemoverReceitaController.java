package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.dao.RepositorioCarteira;
import br.ufrpe.t1800.dao.RepositorioReceita;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.Receita;
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

public class RemoverReceitaController implements Initializable{

	@FXML
	private JFXTextField nome_receita;
	@FXML
	private JFXButton btn_pesquisa, btn_voltar, btn_remover;
	@FXML
	private Label printa, aviso;
	
	
	@FXML
	public void btnPesquisa(ActionEvent event) {
		if(this.nome_receita.getText().isEmpty()) {
			this.aviso.setText("Informe o nome da receita!");
		}else {
			try {
				Receita r = Fachada.getInstance().buscarReceita(this.nome_receita.getText());
				
				this.aviso.setText("");
				this.printa.setText(r.toString());
				this.btn_remover.setVisible(true);
				
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
			p = FXMLLoader.load(MenuReceita.class.getResource("MenuReceita.fxml"));
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
	
	@FXML
	public void btnRemover(ActionEvent event) {
		try {
			Fachada.getInstance().removeReceita(nome_receita.getText());
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Receita Removida com sucesso!");
			alert.setTitle("Carteira Removida");
			alert.showAndWait();
			RepositorioReceita.getInstance().salvarArquivo();
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: " + e.getMessage());
		}
		
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btn_remover.setVisible(false);
		
	}

}

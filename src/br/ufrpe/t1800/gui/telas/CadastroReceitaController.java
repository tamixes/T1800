package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.dao.RepositorioReceita;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.Carteira;
import br.ufrpe.t1800.negocio.beans.Pdf;
import br.ufrpe.t1800.negocio.beans.Receita;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Callback;

public class CadastroReceitaController implements Initializable{

	
	@FXML
	private JFXButton btn_salvar, btn_voltar;
	@FXML
	private JFXTextField v_rece, desc_rec, cate_rec;
	@FXML
	private JFXCheckBox is_pago;
	@FXML
	private JFXDatePicker data_rece;
	@FXML
	private JFXComboBox<Carteira> lista_carteira;
	@FXML
	private Label aviso;
	
	@FXML
	public void btnSalvar(ActionEvent event) {
		String valor, descricao, categoria;
		LocalDate data;
		valor = v_rece.getText();
		descricao = desc_rec.getText();
		categoria = cate_rec.getText();
		data = data_rece.getValue();
		boolean pago = false;
		
		if(!this.cate_rec.getText().isEmpty() || !this.data_rece.getPromptText().isEmpty() || !this.v_rece.getText().isEmpty() 
				&& lista_carteira != null ){
			try {
				if(is_pago.isSelected()) {
					pago = true;
				}
				double v = Double.parseDouble(valor);
				Receita receita = new Receita(lista_carteira.getValue(), v, data, descricao, categoria, pago);
				
				try {
					Fachada.getInstance().cadastrarReceita(receita);
					RepositorioReceita.getInstance().salvarArquivo();
					try {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setHeaderText("Receita cadastrada com sucesso");
						alert.setTitle("Receita cadastrada");
						alert.showAndWait();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.getStackTrace();
					}
					
					try {
						Pdf.Gerador(receita);
					} catch (Exception e) {
						System.out.println("Erro ao salvar PDF: " + e.getMessage());
					}
				} catch (ObjetoJaExisteException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Erro ao cadastrar!");
					alert.setContentText("Receita já existe!");
					alert.showAndWait();
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}else {
			aviso.setText("Preencha todos os Campos!");
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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	Callback<ListView<Carteira>, ListCell<Carteira>> f = new Callback<ListView<Carteira>, ListCell<Carteira>>(){

			
			public ListCell<Carteira> call(ListView<Carteira> param) {
				
				return new ListCell<Carteira>() {
					protected void updateItem(Carteira item, boolean empty) {
						super.updateItem(item, empty);
						setText(empty ? "" : item.getIdCarteira());
					}
				};
			}
			
		};
	
	
		lista_carteira.setItems(FXCollections.observableArrayList(Fachada.getInstance().listarCarteira()));
		lista_carteira.setCellFactory(f);
		lista_carteira.setButtonCell(f.call(null));
		
	}

}

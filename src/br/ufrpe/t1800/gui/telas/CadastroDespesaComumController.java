package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.dao.RepositorioDespesaComum;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.Carteira;
import br.ufrpe.t1800.negocio.beans.DespesaComum;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.util.Callback;

public class CadastroDespesaComumController implements Initializable{

	@FXML
	private JFXButton btn_salvar, btn_voltar;
	@FXML
	private JFXTextField v_desp, desc_desp, tipo_desp;
	@FXML
	private JFXCheckBox is_pago;
	@FXML
	private JFXDatePicker data_desp;
	@FXML
	private JFXComboBox<Carteira> lista_carteira;
	@FXML
	private Label aviso;
	
	
	
	@FXML
	public void btnSalvar(ActionEvent event) {
		String valor, descricao, tipo;
		LocalDate data;
		valor = v_desp.getText();
		descricao = desc_desp.getText();
		tipo = tipo_desp.getText();
		data = data_desp.getValue();
		boolean pago = false;
		
		if(!this.desc_desp.getText().isEmpty() || !this.data_desp.getPromptText().isEmpty() || !this.v_desp.getText().isEmpty() 
				|| !this.tipo_desp.getText().isEmpty() && lista_carteira != null ){
			try {
				if(is_pago.isSelected()) {
					pago = true;
				}
				double v = Double.parseDouble(valor);
				DespesaComum despesa = new DespesaComum(lista_carteira.getValue(), v, data, descricao, tipo, pago);
				
				try {
					Fachada.getInstance().cadastrarDespesaComum(despesa);
					RepositorioDespesaComum.getInstance().salvarArquivo();
					try {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setHeaderText("Despesa cadastrada com sucesso");
						alert.setTitle("Despesa cadastrada");
						alert.showAndWait();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.getStackTrace();
					}
				} catch (ObjetoJaExisteException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Erro ao cadastrar!");
					alert.setContentText("Despesa já existe!");
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
			p = FXMLLoader.load(MenuDespesaComum.class.getResource("MenuDespesaComum.fxml"));
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



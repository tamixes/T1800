package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.Receita;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AlterarReceitaController implements Initializable{


	@FXML
	private JFXButton btn_atualizar, btn_voltar;
	@FXML
	private JFXTextField v_rece, desc_rec, cate_rec;
	@FXML
	private JFXCheckBox is_pago;
	@FXML
	private JFXDatePicker data_rece;
	@FXML
	private TableView<Receita> lista_receitas;
	@FXML
	private TableColumn<Receita, String> descricao;
	@FXML
	private TableColumn<Receita, String> categoria;
	@FXML
	private TableColumn<Receita, Double> valor;
	@FXML
	private TableColumn<Receita, LocalDate> data;
	@FXML
	private TableColumn<Receita, Boolean> pago;
	
	private ObservableList<Receita> receitas;
	private Fachada controller;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
	}
	
	
	
	@FXML
	public void btnAtualizar(ActionEvent event) {
		
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
		
	}
	
	

}

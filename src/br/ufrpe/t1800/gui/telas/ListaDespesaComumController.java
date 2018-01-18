package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.DespesaComum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaDespesaComumController implements Initializable {

	@FXML
	private TableView<DespesaComum> tabela_despesa;
	@FXML
	private TableColumn<DespesaComum, Double> valor;
	@FXML
	private TableColumn<DespesaComum, String> tipo;
	@FXML
	private TableColumn<DespesaComum, LocalDate> data;
	@FXML
	private TableColumn<DespesaComum, Boolean> pago;
	@FXML
	private TableColumn<DespesaComum, String> descricao;
	
	private ObservableList<DespesaComum> despesas; 
	private Fachada controller;
	
	
 	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		controller = Fachada.getInstance();
		tabela_despesa.setEditable(false);
		despesas = FXCollections.observableArrayList(controller.listarDespesaComum());
		
		valor = new TableColumn<>("Valor");
		valor.setResizable(true);
		
		tipo = new TableColumn<>("Tipo");
		tipo.setResizable(true);
		
		data = new TableColumn<>("Data");
		data.setResizable(true);
		
		pago = new TableColumn<>("Pago");
		pago.setResizable(true);
		
		descricao = new TableColumn<>("Descricao");
		descricao.setResizable(true);
		
		tabela_despesa.getColumns().addAll(valor);
		
		
		valor.setCellValueFactory(new PropertyValueFactory<DespesaComum, Double>("Valor"));
		
		
		tipo.setCellValueFactory(new PropertyValueFactory<DespesaComum, String>("Tipo"));
		descricao.setCellValueFactory(new PropertyValueFactory<DespesaComum, String>("Descricao"));
		data.setCellValueFactory(new PropertyValueFactory<DespesaComum, LocalDate>("Data"));
		pago.setCellValueFactory(new PropertyValueFactory<DespesaComum, Boolean>("Pago"));
		
		tabela_despesa.setItems(despesas);
		
	}

}

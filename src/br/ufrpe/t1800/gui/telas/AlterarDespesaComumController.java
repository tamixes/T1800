package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.Carteira;
import br.ufrpe.t1800.negocio.beans.DespesaComum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AlterarDespesaComumController implements Initializable{
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
	private TableView<DespesaComum> lista_despesas;
	@FXML
	private TableColumn<DespesaComum, String> descricao;
	@FXML
	private TableColumn<DespesaComum, String> tipo;
	@FXML
	private TableColumn<DespesaComum, Boolean> pago;
	@FXML
	private TableColumn<DespesaComum, Double> valor;
 	@FXML
 	private TableColumn<DespesaComum, LocalDate> data;
	
 	
 	private ObservableList<DespesaComum> despesas;
 	private Fachada controller;
 	private DespesaComum d;
 	
 	 	
 	
 	
 	@Override
	public void initialize(URL location, ResourceBundle resources) {
		controller = Fachada.getInstance();
		lista_despesas.setEditable(false);
		despesas = FXCollections.observableArrayList(controller.listarDespesaComum());
		
		descricao = new TableColumn<>("Descricao");
		descricao.setResizable(true);
		
		tipo = new TableColumn<>("Tipo");
		tipo.setResizable(true);
		
		pago = new TableColumn<>("Pago");
		pago.setResizable(true);
		
		valor = new TableColumn<>("Valor");
		valor.setResizable(true);
		
		data = new TableColumn<>("Data");
		data.setResizable(true);
		
		lista_despesas.getColumns().addAll(descricao, tipo, pago, valor, data);
		
		descricao.setCellValueFactory(new PropertyValueFactory<DespesaComum, String>("Descricao"));
		tipo.setCellValueFactory(new PropertyValueFactory<DespesaComum, String>("Tipo"));
		pago.setCellValueFactory(new PropertyValueFactory<DespesaComum, Boolean>("Pago"));
		valor.setCellValueFactory(new PropertyValueFactory<DespesaComum, Double>("Valor"));
		data.setCellValueFactory(new PropertyValueFactory<DespesaComum, LocalDate>("Data"));
		
		lista_despesas.setItems(despesas);
		
		
		lista_despesas.setOnMouseClicked(e ->{
			d = lista_despesas.getSelectionModel().getSelectedItem();
			
			desc_desp.setText(d.getDescricao());
			v_desp.setText(Double.toString(d.getValor()));
			tipo_desp.setText(d.getTipo());
			is_pago.setSelected(d.isPago());
			data_desp.setValue(d.getData());
			lista_carteira.setValue(d.getId());
			
			
		});

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
		
		lista_carteira.setCellFactory(f);
		lista_carteira.setButtonCell(f.call(null));
		
	}
	
	
	
	@FXML
	public void btnSalvar(ActionEvent event) {
		
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
	
	
}

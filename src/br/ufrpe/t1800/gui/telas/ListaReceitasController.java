package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

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

public class ListaReceitasController implements Initializable{

	@FXML
	private TableView<Receita> lista_receitas;
	//@FXML
	//private TableColumn<Receita, String> descricao;
	@FXML
	private TableColumn<Receita, String> categoria;
	@FXML
	private TableColumn<Receita, Double> valor;
	@FXML
	private TableColumn<Receita, LocalDate> data;
	@FXML
	private TableColumn<Receita, Boolean> pago;
	@FXML
	private JFXButton btn_voltar;
	
	private ObservableList<Receita> receitas;
	private Fachada controller;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		controller = Fachada.getInstance();
		lista_receitas.setEditable(false);
		receitas = FXCollections.observableArrayList(controller.listarReceita());
		
		//descricao = new TableColumn<>("Descrição");
		//descricao.setResizable(true);
		
		categoria = new TableColumn<>("Categoria");
		categoria.setResizable(true);
		
		valor = new TableColumn<>("Valor");
		valor.setResizable(true);
		
		data = new TableColumn<>("Data");
		data.setResizable(true);
		
		pago = new TableColumn<>("Pago");
		pago.setResizable(true);
		
		lista_receitas.getColumns().addAll( categoria, valor, data, pago);
		
		pago.setCellValueFactory(new PropertyValueFactory<Receita, Boolean>("Pago"));
		categoria.setCellValueFactory(new PropertyValueFactory<Receita, String>("categoria"));
		//descricao.setCellValueFactory(new PropertyValueFactory<Receita, String>("Descrição"));
		valor.setCellValueFactory(new PropertyValueFactory<Receita, Double>("Valor"));
		data.setCellValueFactory(new PropertyValueFactory<Receita, LocalDate>("Data"));
		
		lista_receitas.setItems(receitas);
		
		
		
		
		
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
}

package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.CartaoCredito;
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

public class ListaCartoesController implements Initializable{

	
	@FXML
	private TableView<CartaoCredito> lista_cartoes;
	@FXML
	private TableColumn<CartaoCredito, String> descricao;
	@FXML
	private TableColumn<CartaoCredito, String> bandeira;
	@FXML
	private TableColumn<CartaoCredito, Double> valor;
	@FXML
	private TableColumn<CartaoCredito, Integer> fechamento;
	@FXML
	private TableColumn<CartaoCredito, Integer> pagamento;
	@FXML
	private JFXButton btn_voltar;
	
	private ObservableList<CartaoCredito> cartoes;
	private Fachada controller;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		controller = Fachada.getInstance();
		lista_cartoes.setEditable(false);
		cartoes = FXCollections.observableArrayList(controller.listarCartao());
		
		descricao = new TableColumn<>("Descricao");
		descricao.setResizable(true);
		
		bandeira = new TableColumn<>("Bandeira");
		bandeira.setResizable(true);
		
		fechamento = new TableColumn<>("Fechamento");
		fechamento.setResizable(true);
		
		pagamento = new TableColumn<>("Pagamento");
		pagamento.setResizable(true);
		
		valor = new TableColumn<>("Valor");
		valor.setResizable(true);
		
		lista_cartoes.getColumns().addAll(descricao, bandeira, fechamento, pagamento, valor);
		
		descricao.setCellValueFactory(new PropertyValueFactory<CartaoCredito, String>("Descricao"));
		bandeira.setCellValueFactory(new PropertyValueFactory<CartaoCredito, String>("Bandeira"));
		fechamento.setCellValueFactory(new PropertyValueFactory<CartaoCredito, Integer>("Fechamento"));
		pagamento.setCellValueFactory(new PropertyValueFactory<CartaoCredito, Integer>("Pagamento"));
		valor.setCellValueFactory(new PropertyValueFactory<CartaoCredito, Double>("Valor"));
		
		lista_cartoes.setItems(cartoes);
		
	
		
	}
	
	
	@FXML
	public void btnVoltar(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
		Parent p = null;
		
		try {
			p = FXMLLoader.load(MenuCartao.class.getResource("MenuCartao.fxml"));
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

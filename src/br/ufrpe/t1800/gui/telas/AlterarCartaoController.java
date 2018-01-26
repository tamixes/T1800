package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.dao.RepositorioCartao;
import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.CartaoCredito;
import br.ufrpe.t1800.negocio.beans.Carteira;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AlterarCartaoController implements Initializable{
	
	@FXML
	private JFXComboBox<Carteira> lista_carteira;
	@FXML
	private JFXButton btn_voltar, btn_salvar;
	@FXML
	private JFXTextField dia_paga, desc_cart, dia_fecha, valor_cart, bandeira_cart;
	@FXML
	private Label aviso;
	@FXML
	private TableView<CartaoCredito> lista_cartoes;
	@FXML
	private TableColumn<CartaoCredito, String> descricao;
	@FXML
	private TableColumn<CartaoCredito, String> bandeira;
	@FXML
	private TableColumn<CartaoCredito, Integer> fechamento;
	@FXML
	private TableColumn<CartaoCredito, Integer> pagamento;
	@FXML
	private TableColumn<CartaoCredito, Double> valor;
	
	private ObservableList<CartaoCredito> cartoes;
	private Fachada controller;
	private CartaoCredito c;
	
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
		
		
		lista_cartoes.setOnMouseClicked(e -> {
			c = lista_cartoes.getSelectionModel().getSelectedItem();
			
			desc_cart.setText(c.getDescricao());
			bandeira_cart.setText(c.getBandeira());
			valor_cart.setText(Double.toString(c.getValor()));
			fechamento.setText(Integer.toString(c.getDiaF()));
			pagamento.setText(Integer.toString(c.getDiaP()));
			lista_carteira.setValue(c.getId());
			
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
	String bandeira, descricao, fechamento, pagamento, valor;
		
		bandeira = bandeira_cart.getText();
		descricao = desc_cart.getText();
		fechamento = dia_fecha.getText();
		pagamento = dia_paga.getText();
		valor = valor_cart.getText();
		
		if(!this.dia_fecha.getText().isEmpty() || !this.dia_paga.getText().isEmpty() || !this.desc_cart.getText().isEmpty() ||
				!this.valor_cart.getText().isEmpty() || !this.bandeira_cart.getText().isEmpty() && lista_carteira != null) {
			try {
				int f = Integer.parseInt(fechamento);
				int p = Integer.parseInt(pagamento);
				double v = Double.parseDouble(valor);
				
				CartaoCredito cartao = new CartaoCredito(lista_carteira.getValue(), descricao, v, bandeira, f, p);
				
				try {
					Fachada.getInstance().atualizarCartao(cartao);
					RepositorioCartao.getInstance().salvarArquivo();
					atualiza();
					try {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setHeaderText("Cartão atualizado com sucesso");
						alert.setTitle("Cartão cadastrado");
						alert.showAndWait();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.getStackTrace();
					}
				} catch (ErroAoAtualizarException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Erro ao atualizar!");
					alert.setContentText("Nao foi possivel atualizar!");
					alert.showAndWait();				
					}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}else {
			aviso.setText("Preencha todos os campos!");
		}
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
	
	@FXML
	public void atualiza() {
		lista_cartoes.getItems().clear();
		lista_cartoes.getItems().addAll(Fachada.getInstance().listarCartao());
	}

}

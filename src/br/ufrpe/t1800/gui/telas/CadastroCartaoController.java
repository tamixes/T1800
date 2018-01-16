package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.dao.RepositorioCartao;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.CartaoCredito;
import br.ufrpe.t1800.negocio.beans.Carteira;
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

public class CadastroCartaoController implements Initializable{

	@FXML
	private JFXComboBox<Carteira> lista_carteira;
	@FXML
	private JFXButton btn_voltar, btn_salvar;
	@FXML
	private JFXTextField dia_paga, desc_cart, dia_fecha, valor_cart, bandeira_cart;
	@FXML
	private Label aviso;
	
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
					Fachada.getInstance().cadastrarCartao(cartao);
					RepositorioCartao.getInstance().salvarArquivo();
					try {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setHeaderText("Cartão cadastrado com sucesso");
						alert.setTitle("Cartão cadastrado");
						alert.showAndWait();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.getStackTrace();
					}
				} catch (ObjetoJaExisteException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Erro ao cadastrar!");
					alert.setContentText("Cartão já existe!");
					alert.showAndWait();				}
				
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



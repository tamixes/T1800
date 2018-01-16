package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.dao.RepositorioDespesaCartao;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.CartaoCredito;
import br.ufrpe.t1800.negocio.beans.DespesaCartao;
import br.ufrpe.t1800.negocio.beans.Pessoa;
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

public class CadastroDespesaCartaoController implements Initializable{
	@FXML
	private JFXButton btn_voltar, btn_salvar;
	@FXML
	private JFXComboBox<CartaoCredito> lista_cartao;
	@FXML
	private JFXTextField valor_despesa, desc_despesa,tipo_despesa, num_parcelas;
	@FXML
	private JFXDatePicker  data_despesa;
	@FXML
	private Label aviso;
	
	@FXML
	public void btnSalvar(ActionEvent event) {
		LocalDate data = data_despesa.getValue();
		String valor, descricao, tipo, nParc;
		
		valor = valor_despesa.getText();
		descricao = desc_despesa.getText();
		tipo = tipo_despesa.getText();
		nParc = num_parcelas.getText();
		
		if(!valor.equals("") && !descricao.equals("") && !tipo.equals("") && !nParc.equals("") && lista_cartao != null) {
			try {
				int parc = Integer.parseInt(nParc);
				double dbValor = Double.parseDouble(valor);
				
				DespesaCartao despesa = new DespesaCartao(lista_cartao.getValue(), dbValor, data, descricao, tipo, parc);
				
				try {
					Fachada.getInstance().cadastrarDespesaCartao(despesa);
					RepositorioDespesaCartao.getInstance().salvarArquivo();
					
						try {
						
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setHeaderText("Despesa cadastrada com sucesso ");
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
			p = FXMLLoader.load(MenuDespesaCartao.class.getResource("MenuDespesaCartao.fxml"));
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
	Callback<ListView<CartaoCredito>, ListCell<CartaoCredito>> f = new Callback<ListView<CartaoCredito>, ListCell<CartaoCredito>>(){

			
			public ListCell<CartaoCredito> call(ListView<CartaoCredito> param) {
				
				return new ListCell<CartaoCredito>() {
					protected void updateItem(CartaoCredito item, boolean empty) {
						super.updateItem(item, empty);
						setText(empty ? "" : item.getDescricao());
					}
				};
			}
			
		};
	
	
		lista_cartao.setItems(FXCollections.observableArrayList(Fachada.getInstance().listarCartao()));
		lista_cartao.setCellFactory(f);
		lista_cartao.setButtonCell(f.call(null));
	
	}
	
		
	}


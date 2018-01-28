package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.dao.RepositorioDespesaCartao;
import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.CartaoCredito;
import br.ufrpe.t1800.negocio.beans.DespesaCartao;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AlterarDespesaCartaoController implements Initializable{

	@FXML
	private JFXButton btn_voltar, btn_salvar;
	@FXML
	private JFXComboBox<CartaoCredito> lista_cartao;
	@FXML
	private JFXTextField v_despesa, descricao_despesa,t_despesa, numero_parcelas;
	@FXML
	private JFXDatePicker  data_despesa;
	@FXML
	private Label aviso;
	
	@FXML
	private TableView<DespesaCartao> lista_despesa;
	@FXML
	private TableColumn<DespesaCartao, String> descricao;
	@FXML
	private TableColumn<DespesaCartao, String> tipo;
	@FXML
	private TableColumn<DespesaCartao, Double> valor;
	@FXML
	private TableColumn<DespesaCartao, LocalDate> data;
	@FXML
	private TableColumn<DespesaCartao, Integer> parcelas;
	
	private ObservableList<DespesaCartao> despesas;
	private Fachada controller;
	private DespesaCartao d;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		controller = Fachada.getInstance();
		lista_despesa.setEditable(false);
		despesas = FXCollections.observableArrayList(controller.listarDespesaCartao());
		
		descricao = new TableColumn<>("Descricao");
		descricao.setResizable(true);
		
		tipo = new TableColumn<>("Tipo");
		tipo.setResizable(true);
		
		valor = new TableColumn<>("Valor");
		valor.setResizable(true);
		
		data = new TableColumn<>("Data");
		data.setResizable(true);
		
		parcelas = new TableColumn<>("Parcelas");
		parcelas.setResizable(true);
		
		lista_despesa.getColumns().addAll(descricao, tipo, valor, data, parcelas);
		
		descricao.setCellValueFactory(new PropertyValueFactory<DespesaCartao, String>("Descricao"));
		tipo.setCellValueFactory(new PropertyValueFactory<DespesaCartao, String>("Tipo"));
		data.setCellValueFactory(new PropertyValueFactory<DespesaCartao, LocalDate>("Data"));
		parcelas.setCellValueFactory(new PropertyValueFactory<DespesaCartao, Integer>("Parcelas"));
		valor.setCellValueFactory(new PropertyValueFactory<DespesaCartao, Double>("Valor"));
		
		lista_despesa.setItems(despesas);
		
		lista_despesa.setOnMouseClicked(e -> {
			
			v_despesa.setText(Double.toString(d.getValor()));
			data_despesa.setValue(d.getDataCompra());
			t_despesa.setText(d.getTipo());
			numero_parcelas.setText(Integer.toString(d.getParcela()));
			lista_cartao.setValue(d.getCartao());
			descricao_despesa.setText(d.getDescricao());
		});
		
		
	}
	
	@FXML
	public void btnSalvar(ActionEvent event) {
		LocalDate data = data_despesa.getValue();
		String valor, descricao, tipo, nParc;
		
		valor = v_despesa.getText();
		descricao = descricao_despesa.getText();
		tipo = t_despesa.getText();
		nParc = numero_parcelas.getText();
		
		if(!valor.equals("") && !descricao.equals("") && !tipo.equals("") && !nParc.equals("") && lista_cartao != null && data_despesa != null) {
			try {
				int parc = Integer.parseInt(nParc);
				double dbValor = Double.parseDouble(valor);
				
				DespesaCartao despesa = new DespesaCartao(lista_cartao.getValue(), dbValor, data, descricao, tipo, parc);
				
				try {
					Fachada.getInstance().atualizarDespesaCartao(despesa);
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
				} catch (ErroAoAtualizarException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Erro ao atualizar!");
					alert.setContentText("Não foi possível atualizar!");
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
	

}

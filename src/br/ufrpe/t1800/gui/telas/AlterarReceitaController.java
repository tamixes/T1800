package br.ufrpe.t1800.gui.telas;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.t1800.dao.RepositorioReceita;
import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.beans.Carteira;
import br.ufrpe.t1800.negocio.beans.Pdf;
import br.ufrpe.t1800.negocio.beans.Pessoa;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

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
	private TableView<Receita> lista_receita;
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
	@FXML
	private ComboBox<Carteira> lista_carteira;
	
	private ObservableList<Receita> receitas;
	private Fachada controller;
	private Receita r;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		controller = Fachada.getInstance();
		
		lista_receita.setEditable(false);
		receitas = FXCollections.observableArrayList(controller.listarReceita());
		
		descricao = new TableColumn<>("Descricao");
		descricao.setResizable(true);
		
		categoria = new TableColumn<>("Categoria");
		categoria.setResizable(true);
		
		valor = new TableColumn<>("Valor");
		valor.setResizable(true);
		
		data = new TableColumn<>("Data");
		data.setResizable(true);
		
		pago = new TableColumn<>("Pago");
		pago.setResizable(true);
		
		lista_receita.getColumns().addAll(descricao, categoria, valor, data, pago);
		
		descricao.setCellValueFactory(new PropertyValueFactory<Receita, String>("Descricao"));
		categoria.setCellValueFactory(new PropertyValueFactory<Receita, String>("Categoria"));
		valor.setCellValueFactory(new PropertyValueFactory<Receita, Double>("Valor"));
		data.setCellValueFactory(new PropertyValueFactory<Receita, LocalDate>("Data"));
		pago.setCellValueFactory(new PropertyValueFactory<Receita, Boolean>("Pago"));
		
		lista_receita.setItems(receitas);
		
		lista_receita.setOnMouseClicked(e ->{
			r = lista_receita.getSelectionModel().getSelectedItem();
			
			v_rece.setText(Double.toString(r.getValor()));
			desc_rec.setText(r.getDescricao());
			cate_rec.setText(r.getCategoria());
			lista_carteira.setValue(r.getId());
			is_pago.setSelected(r.isPago());
			data_rece.setValue(r.getData());
			
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
	public void btnAtualizar(ActionEvent event) {
		String valor, descricao, categoria;
		LocalDate data;
		valor = v_rece.getText();
		descricao = desc_rec.getText();
		categoria = cate_rec.getText();
		data = data_rece.getValue();
		boolean pago = false;
		
		if(!this.cate_rec.getText().isEmpty() || !this.data_rece.getPromptText().isEmpty() || !this.v_rece.getText().isEmpty() 
				&& lista_carteira != null ){
			try {
				if(is_pago.isSelected()) {
					pago = true;
				}
				double v = Double.parseDouble(valor);
				Receita receita = new Receita(lista_carteira.getValue(), v, data, descricao, categoria, pago);
				
				try {
					
					Fachada.getInstance().atualizarReceita(receita);
					RepositorioReceita.getInstance().salvarArquivo();
					atualiza();
					
					
					try {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setHeaderText("Receita atualizada com sucesso");
						alert.setTitle("Receita atualizada");
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
		}
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
	public void atualiza() {
		lista_receita.getItems().clear();
		lista_receita.getItems().addAll(Fachada.getInstance().listarReceita());
	}

}

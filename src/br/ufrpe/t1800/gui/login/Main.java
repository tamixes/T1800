package br.ufrpe.t1800.gui.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent r = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
			Scene scene = new Scene(r);
			stage.setScene(scene);
			stage.setTitle("T1800 Finan�as Pessoais");	
			stage.initStyle(StageStyle.TRANSPARENT);
			stage.show();
			
			
		} catch (Exception e) {
			System.out.println("Erro!");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}

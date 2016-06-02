package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/vistas/Laboratorio.fxml"));
			AnchorPane root;
			root = (AnchorPane) loader.load();
			// LaboratorioControlador controller = (LaboratorioControlador)
			// loader.getController();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/gui/vistas/Laboratorio.css").toExternalForm());
			primaryStage.setTitle("Laboratorio");
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
			primaryStage.requestFocus();

		} catch (IOException e) {
			System.err.println(e);
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}

package gui.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MensajeControlador {

	@FXML
	private AnchorPane anchorPaneMain;

	@FXML
	private Text textMessage;

	@FXML
	private Button buttonAceptar;

	@FXML
	private void initialize() {
		assert anchorPaneMain != null : "fx:id=\"anchorPaneMain\" was not injected: check your FXML file 'Mensaje.fxml'.";
		assert textMessage != null : "fx:id=\"textMessage\" was not injected: check your FXML file 'Mensaje.fxml'.";
		assert buttonAceptar != null : "fx:id=\"buttonAceptar\" was not injected: check your FXML file 'Mensaje.fxml'.";

	}

	/**
	 * Inicializador con el mensaje
	 * 
	 * @param mensaje
	 */

	public void inicializador(String mensaje) {
		this.textMessage.setText(mensaje);
	}

	/**
	 * Acci�n del bot�n aceptar
	 */

	@FXML
	private void buttonAceptarOnAction() {

		Stage stage = (Stage) anchorPaneMain.getScene().getWindow();
		stage.close();

	}
}
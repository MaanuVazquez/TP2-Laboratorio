package gui.controladores;

import java.io.IOException;

import excepciones.StringVacioException;
import excepciones.ValoresNegativosException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import laboratorio.Laboratorio;
import laboratorio.Paciente;

public class AgregarPacienteControlador {

	@FXML
	private AnchorPane anchorPaneMain;

	@FXML
	private TextField textFieldNombre;

	@FXML
	private Button buttonAgregar;

	@FXML
	private TextField textFieldDNI;

	@FXML
	private TextField textFieldTelefono;

	@FXML
	private Label labelTelefono;

	@FXML
	private Label labelMail;

	@FXML
	private TextField textFieldMail;

	@FXML
	private Label labelDNI;

	@FXML
	private Label labelNombre;

	@FXML
	private LaboratorioControlador laboratorioControlador;

	@FXML
	void initialize() {
		assert anchorPaneMain != null : "fx:id=\"anchorPaneMain\" was not injected: check your FXML file 'AgregarPaciente.fxml'.";
		assert textFieldNombre != null : "fx:id=\"textFieldNombre\" was not injected: check your FXML file 'AgregarPaciente.fxml'.";
		assert buttonAgregar != null : "fx:id=\"buttonAgregar\" was not injected: check your FXML file 'AgregarPaciente.fxml'.";
		assert textFieldDNI != null : "fx:id=\"textFieldDNI\" was not injected: check your FXML file 'AgregarPaciente.fxml'.";
		assert textFieldTelefono != null : "fx:id=\"textFieldTelefono\" was not injected: check your FXML file 'AgregarPaciente.fxml'.";
		assert labelTelefono != null : "fx:id=\"labelTelefono\" was not injected: check your FXML file 'AgregarPaciente.fxml'.";
		assert labelMail != null : "fx:id=\"labelMail\" was not injected: check your FXML file 'AgregarPaciente.fxml'.";
		assert textFieldMail != null : "fx:id=\"textFieldMail\" was not injected: check your FXML file 'AgregarPaciente.fxml'.";
		assert labelDNI != null : "fx:id=\"labelDNI\" was not injected: check your FXML file 'AgregarPaciente.fxml'.";
		assert labelNombre != null : "fx:id=\"labelNombre\" was not injected: check your FXML file 'AgregarPaciente.fxml'.";

		// Validar los textField de Telefono y DNI
		this.textFieldDNI.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					textFieldDNI.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		this.textFieldTelefono.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					textFieldTelefono.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

	}

	/**
	 * Inicializa el controlador desde el Laboratorio con este como parametro
	 * 
	 * @param l
	 */

	public void inicializarLaboratorio(LaboratorioControlador l) {
		this.laboratorioControlador = l;
	}

	/**
	 * Acci�n del bot�n agregar
	 * 
	 * @throws IOException
	 */

	@FXML
	private void buttonAgregarOnAction() throws IOException {

		Laboratorio lab = Laboratorio.getIntance();
		try {
			lab.agregarPaciente(
					new Paciente(this.textFieldNombre.getText(), Integer.parseInt(this.textFieldDNI.getText()),
							this.textFieldTelefono.getText(), this.textFieldMail.getText()));
			laboratorioControlador.actualizarTablaPacientes();
			Stage stage = (Stage) anchorPaneMain.getScene().getWindow();
			stage.close();
		} catch (NumberFormatException | StringVacioException | ValoresNegativosException e) {
			laboratorioControlador.crearMensaje("Error", e.getMessage());
		}

	}
}
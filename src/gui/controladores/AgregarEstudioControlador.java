package gui.controladores;

import java.io.IOException;
import java.text.ParseException;

import excepciones.PrestacionExistenteException;
import excepciones.StringVacioException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import laboratorio.Estudio;
import laboratorio.GrupoDeEstudios;
import laboratorio.Laboratorio;
import laboratorio.Paciente;

public class AgregarEstudioControlador {

	@FXML
	private AnchorPane anchorPaneMain;

	@FXML
	private Label labelIndicaciones;

	@FXML
	private TextField textFieldNombreDeEstudio;

	@FXML
	private Button buttonAgregar;

	@FXML
	private TextArea textAreaIndicaciones;

	@FXML
	private Label labelNombreDeEstudio;

	private LaboratorioControlador laboratorioControlador;

	private Paciente pacienteAEstudiar;

	private AgregarGrupoDeEstudiosControlador controlador = null;

	private GrupoDeEstudios grupoAnterior = null;

	@FXML
	private void initialize() {
		assert anchorPaneMain != null : "fx:id=\"anchorPaneMain\" was not injected: check your FXML file 'AgregarEstudio.fxml'.";
		assert labelIndicaciones != null : "fx:id=\"labelIndicaciones\" was not injected: check your FXML file 'AgregarEstudio.fxml'.";
		assert textFieldNombreDeEstudio != null : "fx:id=\"textFieldNombreDeEstudio\" was not injected: check your FXML file 'AgregarEstudio.fxml'.";
		assert buttonAgregar != null : "fx:id=\"buttonAgregar\" was not injected: check your FXML file 'AgregarEstudio.fxml'.";
		assert textAreaIndicaciones != null : "fx:id=\"textAreaIndicaciones\" was not injected: check your FXML file 'AgregarEstudio.fxml'.";
		assert labelNombreDeEstudio != null : "fx:id=\"labelNombreDeEstudio\" was not injected: check your FXML file 'AgregarEstudio.fxml'.";

	}

	public void initData(LaboratorioControlador l, Paciente p) {
		this.laboratorioControlador = l;
		this.pacienteAEstudiar = p;
	}

	public void initDataDeGrupo(AgregarGrupoDeEstudiosControlador a, GrupoDeEstudios g) {
		grupoAnterior = g;
		controlador = a;
	}

	@FXML
	private void buttonAgregarOnAction() throws IOException, ParseException {

		Laboratorio lab = Laboratorio.getIntance();
		try {
			if (grupoAnterior != null) {
				grupoAnterior.agregarEstudio(
						new Estudio(textFieldNombreDeEstudio.getText(), textAreaIndicaciones.getText()));
				controlador.actualizarTablaPacientes();
			} else {
				lab.agregarVisita(new Estudio(textFieldNombreDeEstudio.getText(), textAreaIndicaciones.getText()),
						pacienteAEstudiar);
				laboratorioControlador.actualizarTablaPrestaciones(pacienteAEstudiar);
			}

			Stage stage = (Stage) anchorPaneMain.getScene().getWindow();
			stage.close();
		} catch (PrestacionExistenteException | StringVacioException e) {
			laboratorioControlador.mensaje("Error", e.getMessage());
		}

	}
}

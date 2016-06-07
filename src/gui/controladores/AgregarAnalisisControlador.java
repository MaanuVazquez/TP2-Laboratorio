package gui.controladores;

import java.io.IOException;
import java.text.ParseException;

import excepciones.PrestacionExistenteException;
import excepciones.RangoDeValoresInvalido;
import excepciones.StringVacioException;
import excepciones.ValoresNegativosException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import laboratorio.Analisis;
import laboratorio.GrupoDeEstudios;
import laboratorio.Laboratorio;
import laboratorio.Paciente;

public class AgregarAnalisisControlador {

	@FXML
	private AnchorPane anchorPaneMain;

	@FXML
	private TextField textFieldNombre;

	@FXML
	private Button buttonAgregar;

	@FXML
	private TextArea textAreaIndicacion;

	@FXML
	private TextField textFieldValorMinimo;

	@FXML
	private Label labelIndicacion;

	@FXML
	private TextField textFieldValorMaximo;

	@FXML
	private Label labelValorMaximo;

	@FXML
	private Label labelValorMinimo;

	@FXML
	private Label labelNombre;

	private LaboratorioControlador laboratorioControlador = new LaboratorioControlador();

	private Paciente paciente;

	private AgregarGrupoDeEstudiosControlador controlador;

	private GrupoDeEstudios grupoAnterior;

	@FXML
	private void initialize() {
		assert anchorPaneMain != null : "fx:id=\"anchorPaneMain\" was not injected: check your FXML file 'AgregarAnalisis.fxml'.";
		assert textFieldNombre != null : "fx:id=\"textFieldNombre\" was not injected: check your FXML file 'AgregarAnalisis.fxml'.";
		assert buttonAgregar != null : "fx:id=\"buttonAgregar\" was not injected: check your FXML file 'AgregarAnalisis.fxml'.";
		assert textAreaIndicacion != null : "fx:id=\"textAreaIndicacion\" was not injected: check your FXML file 'AgregarAnalisis.fxml'.";
		assert textFieldValorMinimo != null : "fx:id=\"textFieldValorMinimo\" was not injected: check your FXML file 'AgregarAnalisis.fxml'.";
		assert labelIndicacion != null : "fx:id=\"labelIndicacion\" was not injected: check your FXML file 'AgregarAnalisis.fxml'.";
		assert textFieldValorMaximo != null : "fx:id=\"textFieldValorMaximo\" was not injected: check your FXML file 'AgregarAnalisis.fxml'.";
		assert labelValorMaximo != null : "fx:id=\"labelValorMaximo\" was not injected: check your FXML file 'AgregarAnalisis.fxml'.";
		assert labelValorMinimo != null : "fx:id=\"labelValorMinimo\" was not injected: check your FXML file 'AgregarAnalisis.fxml'.";
		assert labelNombre != null : "fx:id=\"labelNombre\" was not injected: check your FXML file 'AgregarAnalisis.fxml'.";

		// Validar los textField de Valores medidos
		this.textFieldValorMaximo.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					textFieldValorMaximo.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		this.textFieldValorMinimo.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					textFieldValorMinimo.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

	}

	public void initData(LaboratorioControlador l, Paciente p) {
		this.laboratorioControlador = l;
		this.paciente = p;
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
				grupoAnterior.agregarEstudio(new Analisis(this.textFieldNombre.getText(),
						this.textAreaIndicacion.getText(), Integer.parseInt(this.textFieldValorMinimo.getText()),
						Integer.parseInt(this.textFieldValorMaximo.getText())));
				controlador.actualizarTablaPacientes();
			} else {
				lab.agregarVisita(new Analisis(this.textFieldNombre.getText(), this.textAreaIndicacion.getText(),
						Integer.parseInt(this.textFieldValorMinimo.getText()),
						Integer.parseInt(this.textFieldValorMaximo.getText())), paciente);
				laboratorioControlador.actualizarTablaPrestaciones(paciente);
			}
			Stage stage = (Stage) anchorPaneMain.getScene().getWindow();
			stage.close();
		} catch (NumberFormatException | ValoresNegativosException | RangoDeValoresInvalido
				| PrestacionExistenteException | StringVacioException e) {
			laboratorioControlador.mensaje("Error", e.getMessage());
		}

	}

}

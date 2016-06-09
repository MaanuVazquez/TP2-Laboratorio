package gui.controladores;

import java.io.IOException;

import excepciones.ValoresNegativosException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import laboratorio.Analisis;
import laboratorio.Paciente;

public class IngresarResultadoAnalisisControlador {

	@FXML
	private AnchorPane anchorPaneMain;

	@FXML
	private Label labelValorMedido;

	@FXML
	private Button buttonIngresar;

	@FXML
	private TextField textFieldValorMedido;

	@FXML
	private Label labelPrestacion;

	@FXML
	private Label labelValorMaximo;

	@FXML
	private Label labelValorMinimo;

	@FXML
	private Label labelNombre;

	private LaboratorioControlador laboratorioControlador;

	private IngresarResultadoGrupalControlador grupoControlador;

	private Analisis analisis;

	private Paciente paciente;

	private IngresarResultadoPorFiltroControlador filtroControlador;

	@FXML
	void initialize() {
		assert anchorPaneMain != null : "fx:id=\"anchorPaneMain\" was not injected: check your FXML file 'IngresarResultadoAnalisis.fxml'.";
		assert labelValorMedido != null : "fx:id=\"labelValorMedido\" was not injected: check your FXML file 'IngresarResultadoAnalisis.fxml'.";
		assert buttonIngresar != null : "fx:id=\"buttonIngresar\" was not injected: check your FXML file 'IngresarResultadoAnalisis.fxml'.";
		assert textFieldValorMedido != null : "fx:id=\"textFieldValorMedido\" was not injected: check your FXML file 'IngresarResultadoAnalisis.fxml'.";
		assert labelPrestacion != null : "fx:id=\"labelPrestacion\" was not injected: check your FXML file 'IngresarResultadoAnalisis.fxml'.";
		assert labelValorMaximo != null : "fx:id=\"labelValorMaximo\" was not injected: check your FXML file 'IngresarResultadoAnalisis.fxml'.";
		assert labelValorMinimo != null : "fx:id=\"labelValorMinimo\" was not injected: check your FXML file 'IngresarResultadoAnalisis.fxml'.";
		assert labelNombre != null : "fx:id=\"labelNombre\" was not injected: check your FXML file 'IngresarResultadoAnalisis.fxml'.";
		this.textFieldValorMedido.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					textFieldValorMedido.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
	}

	public void inicializarDeLaboratorio(LaboratorioControlador l, Analisis a, Paciente p) {
		this.laboratorioControlador = l;
		this.analisis = a;
		this.paciente = p;
		this.labelNombre.setText("Nombre: " + analisis.getNombre());
		this.labelValorMinimo.setText("Valor Mínimo: " + analisis.getValorNormalMinimo());
		this.labelValorMaximo.setText("Valor Máximo: " + analisis.getValorNormalMaximo());
	}

	public void inicializarDeGrupo(LaboratorioControlador l, IngresarResultadoGrupalControlador g, Analisis a,
			Paciente p) {
		this.laboratorioControlador = l;
		this.grupoControlador = g;
		this.analisis = a;
		this.paciente = p;
		this.labelNombre.setText("Nombre: " + analisis.getNombre());
		this.labelValorMinimo.setText("Valor Mínimo: " + analisis.getValorNormalMinimo());
		this.labelValorMaximo.setText("Valor Máximo: " + analisis.getValorNormalMaximo());
	}

	public void inicializarDeFiltro(LaboratorioControlador l, IngresarResultadoPorFiltroControlador f, Analisis a) {
		this.laboratorioControlador = l;
		this.analisis = a;
		this.filtroControlador = f;
		this.labelNombre.setText("Nombre: " + analisis.getNombre());
		this.labelValorMinimo.setText("Valor Mínimo: " + analisis.getValorNormalMinimo());
		this.labelValorMaximo.setText("Valor Máximo: " + analisis.getValorNormalMaximo());
	}

	@FXML
	void buttonIngresarOnAction() throws IOException {

		try {
			analisis.setResultado(Double.parseDouble(this.textFieldValorMedido.getText()));
			if (grupoControlador != null) {
				grupoControlador.actualizarTablasDeGrupo();
			} else if (filtroControlador != null) {
				filtroControlador.popularTabla(this.filtroControlador.search);
			} else {
				laboratorioControlador.actualizarTablaPrestaciones(paciente);
			}
			Stage stage = (Stage) anchorPaneMain.getScene().getWindow();
			stage.close();

		} catch (NumberFormatException | ValoresNegativosException e) {
			this.laboratorioControlador.crearMensaje("Error", e.getMessage());
		}

	}
}

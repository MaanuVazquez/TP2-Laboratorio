package gui.controladores;

import java.io.IOException;

import enums.ClasificacionEstudio;
import excepciones.StringVacioException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import laboratorio.Estudio;
import laboratorio.Paciente;

public class IngresarResultadoEstudioControlador {

	@FXML
	private AnchorPane anchorPaneMain;

	@FXML
	private Label labelClasificacion;

	@FXML
	private ChoiceBox<ClasificacionEstudio> choiceBoxClasificacion;

	@FXML
	private Button buttonIngresar;

	@FXML
	private TextArea textAreaInforme;

	@FXML
	private Label labelInforme;

	@FXML
	private Label labelNombre;

	private LaboratorioControlador laboratorioControlador;

	private Estudio estudio;

	private Paciente paciente;

	private IngresarResultadoGrupalControlador grupoControlador;

	private IngresarResultadoPorFiltroControlador filtroControlador;

	@FXML
	void initialize() {
		assert anchorPaneMain != null : "fx:id=\"anchorPaneMain\" was not injected: check your FXML file 'IngresarResultadoEstudio.fxml'.";
		assert labelClasificacion != null : "fx:id=\"labelClasificacion\" was not injected: check your FXML file 'IngresarResultadoEstudio.fxml'.";
		assert choiceBoxClasificacion != null : "fx:id=\"choiceBoxClasificacion\" was not injected: check your FXML file 'IngresarResultadoEstudio.fxml'.";
		assert buttonIngresar != null : "fx:id=\"buttonIngresar\" was not injected: check your FXML file 'IngresarResultadoEstudio.fxml'.";
		assert textAreaInforme != null : "fx:id=\"textAreaInforme\" was not injected: check your FXML file 'IngresarResultadoEstudio.fxml'.";
		assert labelInforme != null : "fx:id=\"labelInforme\" was not injected: check your FXML file 'IngresarResultadoEstudio.fxml'.";
		choiceBoxClasificacion.getItems().setAll(ClasificacionEstudio.values());
		choiceBoxClasificacion.getSelectionModel().select(1);
	}

	public void inicializarDeLaboratorio(LaboratorioControlador l, Estudio e, Paciente p) {
		laboratorioControlador = l;
		estudio = e;
		paciente = p;
		labelNombre.setText("Nombre: " + estudio.getNombre());
	}

	public void inicializarDeGrupo(LaboratorioControlador l, IngresarResultadoGrupalControlador g, Estudio e,
			Paciente p) {
		this.laboratorioControlador = l;
		this.grupoControlador = g;
		this.estudio = e;
		this.paciente = p;
		labelNombre.setText("Nombre: " + estudio.getNombre());
	}

	public void inicializarDeFiltro(LaboratorioControlador l, IngresarResultadoPorFiltroControlador f, Estudio e) {
		this.laboratorioControlador = l;
		this.filtroControlador = f;
		this.estudio = e;
		labelNombre.setText("Nombre: " + estudio.getNombre());
	}

	@FXML
	void buttonIngresarOnAction() throws IOException {

		try {
			estudio.setResultado(choiceBoxClasificacion.getValue(), this.textAreaInforme.getText());
			if (grupoControlador != null) {
				grupoControlador.actualizarTablasDeGrupo();
			} else if (filtroControlador != null) {
				filtroControlador.popularTabla(this.filtroControlador.search);
			} else {
				laboratorioControlador.actualizarTablaPrestaciones(paciente);
			}

			Stage stage = (Stage) anchorPaneMain.getScene().getWindow();
			stage.close();

		} catch (StringVacioException e) {
			laboratorioControlador.crearMensaje("Error", e.getMessage());

		}

	}
}

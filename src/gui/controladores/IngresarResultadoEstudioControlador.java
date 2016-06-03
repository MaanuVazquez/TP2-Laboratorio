package gui.controladores;

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

	private LaboratorioControlador lab;

	private Estudio estudio;

	private Paciente paciente;

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

	public void initData(LaboratorioControlador l, Estudio e, Paciente p) {
		lab = l;
		estudio = e;
		paciente = p;
	}

	@FXML
	void buttonIngresarOnAction() {

		try {
			estudio.setResultado(choiceBoxClasificacion.getValue(), this.textAreaInforme.getText());
			lab.actualizarTablaPrestaciones(paciente);
			Stage stage = (Stage) anchorPaneMain.getScene().getWindow();
			stage.close();
		} catch (StringVacioException e) {
			// TODO Mensaje de Error
			e.printStackTrace();
		}

	}
}

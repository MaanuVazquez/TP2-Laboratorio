package gui.controladores;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import eu.schudt.javafx.controls.calendar.DatePicker;
import excepciones.FechasInvalidasException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import laboratorio.Estadistica;
import laboratorio.Laboratorio;

public class MostrarEstadisticaControlador {

	@FXML
	private AnchorPane anchorPaneMain;

	@FXML
	private Button buttonAceptar;

	@FXML
	private GridPane gridPaneDate;

	@FXML
	private Button buttonMostrar;

	@FXML
	private TextArea textAreaEstadistica;

	private DatePicker desdeDatePicker;

	private DatePicker hastaDatePicker;

	private LaboratorioControlador laboratorioControlador;

	private Laboratorio laboratorio = Laboratorio.getIntance();

	@FXML
	private void initialize() {
		assert anchorPaneMain != null : "fx:id=\"anchorPaneMain\" was not injected: check your FXML file 'MostrarEstadistica.fxml'.";
		assert buttonAceptar != null : "fx:id=\"buttonAceptar\" was not injected: check your FXML file 'MostrarEstadistica.fxml'.";
		assert gridPaneDate != null : "fx:id=\"gridPaneDate\" was not injected: check your FXML file 'MostrarEstadistica.fxml'.";
		assert buttonMostrar != null : "fx:id=\"buttonMostrar\" was not injected: check your FXML file 'MostrarEstadistica.fxml'.";
		assert textAreaEstadistica != null : "fx:id=\"textAreaEstadistica\" was not injected: check your FXML file 'MostrarEstadistica.fxml'.";
		inicializarDatePickers();

	}

	private void inicializarDatePickers() {
		// Initialize the DatePicker for birthday
		desdeDatePicker = new DatePicker(Locale.getDefault());
		desdeDatePicker.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		desdeDatePicker.getCalendarView().todayButtonTextProperty().set("Today");
		desdeDatePicker.getCalendarView().setShowWeeks(false);
		desdeDatePicker.getStylesheets().add("gui/vistas/DatePicker.css");

		hastaDatePicker = new DatePicker(Locale.getDefault());
		hastaDatePicker.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		hastaDatePicker.getCalendarView().todayButtonTextProperty().set("Today");
		hastaDatePicker.getCalendarView().setShowWeeks(false);
		hastaDatePicker.getStylesheets().add("gui/vistas/DatePicker.css");

		// Add DatePicker to grid
		gridPaneDate.add(desdeDatePicker, 0, 0);
		gridPaneDate.add(hastaDatePicker, 1, 0);
	}

	public void inicializarDeLaboratorio(LaboratorioControlador l) {
		this.laboratorioControlador = l;
	}

	@FXML
	void buttonAceptarOnAction() {

	}

	@FXML
	void buttonMostrarOnAction() throws IOException {
		try {
			this.textAreaEstadistica.setText(this.laboratorio.listarEstadisticas(desdeDatePicker.getSelectedDate(),
					hastaDatePicker.getSelectedDate()));

		} catch (FechasInvalidasException e) {
			this.laboratorioControlador.mensaje("Error", e.getMessage());
		}
	}
}

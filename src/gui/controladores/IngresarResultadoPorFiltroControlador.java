package gui.controladores;

import java.io.IOException;

import enums.EstadoPrestacion;
import gui.modelos.ModeloPrestacion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import laboratorio.Analisis;
import laboratorio.Estudio;
import laboratorio.GrupoDeEstudios;
import laboratorio.Laboratorio;
import laboratorio.Prestacion;

public class IngresarResultadoPorFiltroControlador {

	@FXML
	private AnchorPane anchorPaneMain;

	@FXML
	private TableView<ModeloPrestacion> tableViewPrestaciones;

	@FXML
	private TableColumn<ModeloPrestacion, String> prestacionNombre;

	@FXML
	private TableColumn<ModeloPrestacion, String> prestacionIndicacion;

	@FXML
	private TableColumn<ModeloPrestacion, String> prestacionEstado;

	@FXML
	private Label labelPrestaciones;

	@FXML
	private Button buttonAccept;

	@FXML
	private Button buttonIngresarResultado;

	@FXML
	private TextField textFieldSearch;

	@FXML
	private ObservableList<ModeloPrestacion> listaPrestaciones;

	private LaboratorioControlador laboratorioControlador;

	private Laboratorio lab = Laboratorio.getIntance();

	// Ingresar Resultado
	private String resultadoFXML;
	private String resultadoTitle;
	private String tipoPrestacion;

	public String search;

	@FXML
	private void initialize() {
		assert anchorPaneMain != null : "fx:id=\"anchorPaneMain\" was not injected: check your FXML file 'IngresarResultadoPorFiltro.fxml'.";
		assert prestacionNombre != null : "fx:id=\"prestacionNombre\" was not injected: check your FXML file 'IngresarResultadoPorFiltro.fxml'.";
		assert prestacionEstado != null : "fx:id=\"prestacionEstado\" was not injected: check your FXML file 'IngresarResultadoPorFiltro.fxml'.";
		assert labelPrestaciones != null : "fx:id=\"labelPrestaciones\" was not injected: check your FXML file 'IngresarResultadoPorFiltro.fxml'.";
		assert tableViewPrestaciones != null : "fx:id=\"tableViewPrestaciones\" was not injected: check your FXML file 'IngresarResultadoPorFiltro.fxml'.";
		assert buttonAccept != null : "fx:id=\"buttonAccept\" was not injected: check your FXML file 'IngresarResultadoPorFiltro.fxml'.";
		assert prestacionIndicacion != null : "fx:id=\"prestacionIndicacion\" was not injected: check your FXML file 'IngresarResultadoPorFiltro.fxml'.";
		assert buttonIngresarResultado != null : "fx:id=\"buttonIngresarResultado\" was not injected: check your FXML file 'IngresarResultadoPorFiltro.fxml'.";
		this.tableViewPrestaciones.setPlaceholder(new Label(""));
		inicializarTablas();
		popularTabla("");

		// Realizamos el search
		this.textFieldSearch.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				search = newValue;
				popularTabla(newValue);
			}
		});

	}

	private void inicializarTablas() {
		/* Tabla prestaciones */
		this.prestacionNombre.setCellValueFactory(new PropertyValueFactory<ModeloPrestacion, String>("nombre"));
		this.prestacionIndicacion.setCellValueFactory(new PropertyValueFactory<ModeloPrestacion, String>("indicacion"));
		this.prestacionEstado.setCellValueFactory(new PropertyValueFactory<ModeloPrestacion, String>("estado"));
	}

	public void inicializarLaboratorio(LaboratorioControlador l) {
		this.laboratorioControlador = l;
	}

	public void popularTabla(String nombreEstudio) {
		this.tableViewPrestaciones.setPlaceholder(new Label("No se han encontrado resultados"));
		listaPrestaciones = FXCollections.observableArrayList();

		for (Prestacion prestacion : lab.getPrestaciones().values()) {
			if (containsIgnoreCase(prestacion.getNombre(), nombreEstudio)) {
				ModeloPrestacion modeloPrestacion = new ModeloPrestacion(prestacion.getId(), prestacion.getNombre(),
						prestacion.getIndicacion(), prestacion.getEstado().toString());
				listaPrestaciones.add(modeloPrestacion);
			}
		}

		tableViewPrestaciones.setItems(listaPrestaciones);

	}

	private boolean containsIgnoreCase(final String str, final String searchStr) {
		if (str == null || searchStr == null) {
			return false;
		}
		final int len = searchStr.length();
		final int max = str.length() - len;
		for (int i = 0; i <= max; i++) {
			if (str.regionMatches(true, i, searchStr, 0, len)) {
				return true;
			}
		}
		return false;
	}

	private void setResultadoForm(String tipoDePrestacion) {
		switch (tipoDePrestacion) {
		case "Analisis":
			this.resultadoFXML = "/gui/vistas/IngresarResultadoAnalisis.fxml";
			this.resultadoTitle = "Análisis ";
			break;
		case "GrupoDeEstudios":
			this.resultadoFXML = "/gui/vistas/IngresarResultadoGrupal.fxml";
			this.resultadoTitle = "Grupo de Estudios ";
			break;
		default:
			this.resultadoFXML = "/gui/vistas/IngresarResultadoEstudio.fxml";
			this.resultadoTitle = "Estudio ";
			break;
		}
		this.tipoPrestacion = tipoDePrestacion;
	}

	@FXML
	private void buttonOkOnAction() {
		Stage stage = (Stage) anchorPaneMain.getScene().getWindow();
		stage.close();
	}

	@FXML
	private void buttonIngresarResultadoOnAction() throws IOException {

		ModeloPrestacion modeloPrestacion;
		if ((modeloPrestacion = tableViewPrestaciones.getSelectionModel().getSelectedItem()) != null) {
			Prestacion prestacion = lab.getPrestaciones().get(modeloPrestacion.getId());
			if (prestacion.getEstado() != EstadoPrestacion.FINALIZADO) {
				setResultadoForm(prestacion.getResultForm());
				FXMLLoader loader = new FXMLLoader(getClass().getResource(this.resultadoFXML));
				AnchorPane root;
				root = (AnchorPane) loader.load();
				Scene scene = new Scene(root);
				Stage dialogoIngresarResultado = new Stage();
				scene.getStylesheets().add(getClass().getResource("/gui/vistas/Laboratorio.css").toExternalForm());
				dialogoIngresarResultado.initOwner(anchorPaneMain.getScene().getWindow());
				dialogoIngresarResultado.initStyle(StageStyle.DECORATED);
				dialogoIngresarResultado.initModality(Modality.APPLICATION_MODAL);
				dialogoIngresarResultado.setScene(scene);
				dialogoIngresarResultado.setTitle(this.resultadoTitle + prestacion.getId());
				dialogoIngresarResultado.setResizable(false);

				if (this.tipoPrestacion.equals("Analisis")) {
					IngresarResultadoAnalisisControlador controller = (IngresarResultadoAnalisisControlador) loader
							.getController();
					controller.inicializarDeFiltro(this.laboratorioControlador, this, (Analisis) prestacion);
				} else if (this.tipoPrestacion.equals("GrupoDeEstudios")) {
					IngresarResultadoGrupalControlador controller = (IngresarResultadoGrupalControlador) loader
							.getController();
					controller.inicializarDeFiltro(this.laboratorioControlador, this, (GrupoDeEstudios) prestacion);
				} else {
					IngresarResultadoEstudioControlador controller = (IngresarResultadoEstudioControlador) loader
							.getController();
					controller.inicializarDeFiltro(this.laboratorioControlador, this, (Estudio) prestacion);
				}
				dialogoIngresarResultado.show();
			} else {
				laboratorioControlador.mensaje("Error", "La prestación seleccionada ya se encuentra finalizada");
			}
		} else {
			laboratorioControlador.mensaje("Error", "No se ha seleccionado ningúna prestación");
		}

	}
}

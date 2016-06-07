package gui.controladores;

import java.io.IOException;

import enums.EstadoPrestacion;
import gui.modelos.ModeloPrestacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import laboratorio.Analisis;
import laboratorio.Estudio;
import laboratorio.GrupoDeEstudios;
import laboratorio.Paciente;
import laboratorio.Prestacion;

public class IngresarResultadoGrupalControlador {

	@FXML
	private AnchorPane anchorPaneMain;

	@FXML
	private TableColumn<ModeloPrestacion, String> prestacionNombre;

	@FXML
	private TableColumn<ModeloPrestacion, String> prestacionEstado;

	@FXML
	private Label labelPrestaciones;

	@FXML
	private TableView<ModeloPrestacion> tableViewPrestaciones;

	@FXML
	private Button buttonAccept;

	@FXML
	private TableColumn<ModeloPrestacion, String> prestacionIndicacion;

	@FXML
	private Label labelNombre;

	@FXML
	private Button buttonIngresarResultado;

	@FXML
	private ObservableList<ModeloPrestacion> listaPrestaciones;

	private LaboratorioControlador laboratorioControlador;
	private IngresarResultadoGrupalControlador grupoControlador;
	private IngresarResultadoPorFiltroControlador filtroControlador;
	private Paciente paciente;
	private GrupoDeEstudios grupo;
	private String resultadoFXML;
	private String resultadoTitle;
	private String tipoPrestacion;

	@FXML
	private void initialize() {
		assert anchorPaneMain != null : "fx:id=\"anchorPaneMain\" was not injected: check your FXML file 'IngresarResultadoGrupal.fxml'.";
		assert prestacionNombre != null : "fx:id=\"prestacionNombre\" was not injected: check your FXML file 'IngresarResultadoGrupal.fxml'.";
		assert prestacionEstado != null : "fx:id=\"prestacionEstado\" was not injected: check your FXML file 'IngresarResultadoGrupal.fxml'.";
		assert labelPrestaciones != null : "fx:id=\"labelPrestaciones\" was not injected: check your FXML file 'IngresarResultadoGrupal.fxml'.";
		assert tableViewPrestaciones != null : "fx:id=\"tableViewPrestaciones\" was not injected: check your FXML file 'IngresarResultadoGrupal.fxml'.";
		assert buttonAccept != null : "fx:id=\"buttonAccept\" was not injected: check your FXML file 'IngresarResultadoGrupal.fxml'.";
		assert prestacionIndicacion != null : "fx:id=\"prestacionIndicacion\" was not injected: check your FXML file 'IngresarResultadoGrupal.fxml'.";
		assert labelNombre != null : "fx:id=\"labelNombre\" was not injected: check your FXML file 'IngresarResultadoGrupal.fxml'.";
		assert buttonIngresarResultado != null : "fx:id=\"buttonIngresarResultado\" was not injected: check your FXML file 'IngresarResultadoGrupal.fxml'.";
		inicializarTablas();
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

	private void inicializarTablas() {
		/* Tabla prestaciones */
		this.prestacionNombre.setCellValueFactory(new PropertyValueFactory<ModeloPrestacion, String>("nombre"));
		this.prestacionIndicacion.setCellValueFactory(new PropertyValueFactory<ModeloPrestacion, String>("indicacion"));
		this.prestacionEstado.setCellValueFactory(new PropertyValueFactory<ModeloPrestacion, String>("estado"));
	}

	public void inicializarDeLaboratorio(LaboratorioControlador l, GrupoDeEstudios g, Paciente p) {
		this.laboratorioControlador = l;
		this.paciente = p;
		this.grupo = g;
		actualizarTablasDeGrupo();
		this.labelNombre.setText("Nombre: " + this.grupo.getNombre());
	}

	public void inicializarDeGrupo(LaboratorioControlador l, IngresarResultadoGrupalControlador gc, GrupoDeEstudios g,
			Paciente p) {
		this.laboratorioControlador = l;
		this.grupoControlador = gc;
		this.paciente = p;
		this.grupo = g;
		actualizarTablasDeGrupo();
		this.labelNombre.setText("Nombre: " + this.grupo.getNombre());
	}

	public void inicializarDeFiltro(LaboratorioControlador l, IngresarResultadoPorFiltroControlador f,
			GrupoDeEstudios g) {
		this.laboratorioControlador = l;
		this.filtroControlador = f;
		this.grupo = g;
		actualizarTablasDeGrupo();
		this.labelNombre.setText("Nombre: " + this.grupo.getNombre());
	}

	public void actualizarTablasDeGrupo() {

		listaPrestaciones = FXCollections.observableArrayList();

		for (Prestacion prestacion : grupo.getEstudios().values()) {
			ModeloPrestacion modeloPrestacion = new ModeloPrestacion(prestacion.getId(), prestacion.getNombre(),
					prestacion.getIndicacion(), prestacion.getEstado().toString());
			listaPrestaciones.add(modeloPrestacion);
		}

		tableViewPrestaciones.setItems(listaPrestaciones);

	}

	@FXML
	void buttonOkOnAction() {
		if (grupoControlador != null)
			grupoControlador.actualizarTablasDeGrupo();
		else if (filtroControlador != null) {
			filtroControlador.popularTabla(this.filtroControlador.search);
		} else {
			laboratorioControlador.actualizarTablaPrestaciones(paciente);
		}
		Stage stage = (Stage) anchorPaneMain.getScene().getWindow();
		stage.close();
	}

	@FXML
	void buttonIngresarResultadoOnAction() throws IOException {

		ModeloPrestacion modeloPrestacion;
		if ((modeloPrestacion = tableViewPrestaciones.getSelectionModel().getSelectedItem()) != null) {
			Prestacion prestacion = grupo.getEstudios().get(modeloPrestacion.getId());
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
					controller.inicializarDeGrupo(this.laboratorioControlador, this, (Analisis) prestacion, paciente);
				} else if (this.tipoPrestacion.equals("GrupoDeEstudios")) {
					IngresarResultadoGrupalControlador controller = (IngresarResultadoGrupalControlador) loader
							.getController();
					controller.inicializarDeGrupo(this.laboratorioControlador, this, (GrupoDeEstudios) prestacion,
							paciente);
				} else {
					IngresarResultadoEstudioControlador controller = (IngresarResultadoEstudioControlador) loader
							.getController();
					controller.inicializarDeGrupo(this.laboratorioControlador, this, (Estudio) prestacion, paciente);
				}
				dialogoIngresarResultado.show();
			} else {
				this.laboratorioControlador.mensaje("Error", "La prestación seleccionada ya se encuentra finalizada");
			}
		} else {
			this.laboratorioControlador.mensaje("Error", "No se ha seleccionado ningúna prestación");
		}

	}

}

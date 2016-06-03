package gui.controladores;

import java.io.IOException;

import excepciones.PrestacionExistenteException;
import excepciones.StringVacioException;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import laboratorio.GrupoDeEstudios;
import laboratorio.Laboratorio;
import laboratorio.Paciente;
import laboratorio.Prestacion;

public class AgregarGrupoDeEstudiosControlador {

	@FXML
	private TextField textFieldNombre;

	@FXML
	private Button buttonAgregarEstudio;

	@FXML
	private VBox vBox;

	@FXML
	private Label labelIndicacion;

	@FXML
	private TextArea textAreaIndicacion;

	@FXML
	private Button buttonAgregarAnalisis;

	@FXML
	private TableColumn<ModeloPrestacion, String> prestacionIndicacion;

	@FXML
	private AnchorPane anchorPaneMain;

	@FXML
	private TableColumn<ModeloPrestacion, String> prestacionNombre;

	@FXML
	private Button buttonAgregar;

	@FXML
	private TableColumn<ModeloPrestacion, String> prestacionEstado;

	@FXML
	private Label labelPrestaciones;

	@FXML
	private TableView<ModeloPrestacion> tableViewPrestaciones;

	@FXML
	private Button buttonAgregarGrupoDeEstudios;

	@FXML
	private Label labelNombre;

	private LaboratorioControlador laboratorioControlador;

	private Paciente paciente;

	private GrupoDeEstudios grupo;

	private AgregarGrupoDeEstudiosControlador controlador = null;

	private GrupoDeEstudios grupoAnterior = null;

	@FXML
	private ObservableList<ModeloPrestacion> listaPrestaciones;

	@FXML
	private void initialize() throws StringVacioException {
		assert textFieldNombre != null : "fx:id=\"textFieldNombre\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
		assert buttonAgregarEstudio != null : "fx:id=\"buttonAgregarEstudio\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
		assert vBox != null : "fx:id=\"vBox\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
		assert labelIndicacion != null : "fx:id=\"labelIndicacion\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
		assert textAreaIndicacion != null : "fx:id=\"textFieldIndicacion\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
		assert buttonAgregarAnalisis != null : "fx:id=\"buttonAgregarAnalisis\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
		assert prestacionIndicacion != null : "fx:id=\"prestacionIndicacion\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
		assert anchorPaneMain != null : "fx:id=\"anchorPaneMain\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
		assert prestacionNombre != null : "fx:id=\"prestacionNombre\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
		assert buttonAgregar != null : "fx:id=\"buttonAgregar\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
		assert prestacionEstado != null : "fx:id=\"prestacionEstado\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
		assert labelPrestaciones != null : "fx:id=\"labelPrestaciones\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
		assert tableViewPrestaciones != null : "fx:id=\"tableViewPrestaciones\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
		assert buttonAgregarGrupoDeEstudios != null : "fx:id=\"buttonAgregarGrupoDeEstudios\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
		assert labelNombre != null : "fx:id=\"labelNombre\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
		this.tableViewPrestaciones.setPlaceholder(new Label("Ninguna prestación agregada"));
		grupo = new GrupoDeEstudios("nombre", "indicacion");
		inicializarColumnas();
		actualizarTablaPacientes();
	}

	private void inicializarColumnas() {

		/* Tabla prestaciones */
		this.prestacionNombre.setCellValueFactory(new PropertyValueFactory<ModeloPrestacion, String>("nombre"));
		this.prestacionIndicacion.setCellValueFactory(new PropertyValueFactory<ModeloPrestacion, String>("indicacion"));
		this.prestacionEstado.setCellValueFactory(new PropertyValueFactory<ModeloPrestacion, String>("estado"));

	}

	public void actualizarTablaPacientes() {
		listaPrestaciones = FXCollections.observableArrayList();

		for (Prestacion prestacion : grupo.getEstudios().values()) {
			ModeloPrestacion modeloPrestacion = new ModeloPrestacion(prestacion.getId(), prestacion.getNombre(),
					prestacion.getIndicacion(), prestacion.getEstado().toString());
			listaPrestaciones.add(modeloPrestacion);
		}

		tableViewPrestaciones.setItems(listaPrestaciones);

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
	private void buttonAgregarEstudioOnAction() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/vistas/agregarEstudio.fxml"));
		AnchorPane root;
		root = (AnchorPane) loader.load();
		Scene scene = new Scene(root);
		Stage dialogoAgregarEstudio = new Stage();
		scene.getStylesheets().add(getClass().getResource("/gui/vistas/Laboratorio.css").toExternalForm());
		dialogoAgregarEstudio.initOwner(anchorPaneMain.getScene().getWindow());
		dialogoAgregarEstudio.initStyle(StageStyle.DECORATED);
		dialogoAgregarEstudio.initModality(Modality.APPLICATION_MODAL);
		dialogoAgregarEstudio.setScene(scene);
		dialogoAgregarEstudio.setTitle("Agregar Estudio");
		dialogoAgregarEstudio.setResizable(false);
		AgregarEstudioControlador controller = (AgregarEstudioControlador) loader.getController();
		controller.initDataDeGrupo(this, grupo);
		dialogoAgregarEstudio.show();

	}

	@FXML
	private void buttonAgregarAnalisisOnAction() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/vistas/agregarAnalisis.fxml"));
		AnchorPane root;
		root = (AnchorPane) loader.load();
		Scene scene = new Scene(root);
		Stage dialogoAgregarAnalisis = new Stage();
		scene.getStylesheets().add(getClass().getResource("/gui/vistas/Laboratorio.css").toExternalForm());
		dialogoAgregarAnalisis.initOwner(anchorPaneMain.getScene().getWindow());
		dialogoAgregarAnalisis.initStyle(StageStyle.DECORATED);
		dialogoAgregarAnalisis.initModality(Modality.APPLICATION_MODAL);
		dialogoAgregarAnalisis.setScene(scene);
		dialogoAgregarAnalisis.setTitle("Agregar Estudio");
		dialogoAgregarAnalisis.setResizable(false);
		AgregarAnalisisControlador controller = (AgregarAnalisisControlador) loader.getController();
		controller.initDataDeGrupo(this, grupo);
		dialogoAgregarAnalisis.show();

	}

	@FXML
	private void buttonAgregarGrupoDeEstudiosOnAction() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/vistas/agregarGrupoDeEstudios.fxml"));
		AnchorPane root;
		root = (AnchorPane) loader.load();
		Scene scene = new Scene(root);
		Stage dialogoAgregarGrupoDeEstudios = new Stage();
		scene.getStylesheets().add(getClass().getResource("/gui/vistas/Laboratorio.css").toExternalForm());
		dialogoAgregarGrupoDeEstudios.initOwner(anchorPaneMain.getScene().getWindow());
		dialogoAgregarGrupoDeEstudios.initStyle(StageStyle.DECORATED);
		dialogoAgregarGrupoDeEstudios.initModality(Modality.APPLICATION_MODAL);
		dialogoAgregarGrupoDeEstudios.setScene(scene);
		dialogoAgregarGrupoDeEstudios.setTitle("Agregar Estudio");
		dialogoAgregarGrupoDeEstudios.setResizable(false);
		AgregarGrupoDeEstudiosControlador controller = (AgregarGrupoDeEstudiosControlador) loader.getController();
		controller.initDataDeGrupo(this, grupo);
		dialogoAgregarGrupoDeEstudios.show();

	}

	@FXML
	private void buttonAgregarOnAction() {

		grupo.setNombre(this.textFieldNombre.getText());
		grupo.setIndicacion(this.textAreaIndicacion.getText());

		if (grupoAnterior != null) {
			grupoAnterior.agregarEstudio(grupo);
			controlador.actualizarTablaPacientes();
		} else {
			Laboratorio lab = Laboratorio.getIntance();
			try {
				lab.agregarVisita(grupo, paciente);
				laboratorioControlador.actualizarTablaPrestaciones(paciente);
			} catch (NumberFormatException | PrestacionExistenteException e) {
				// agregar mensaje de error jeje
				e.printStackTrace();
			}
		}
		Stage stage = (Stage) anchorPaneMain.getScene().getWindow();
		stage.close();
	}

}

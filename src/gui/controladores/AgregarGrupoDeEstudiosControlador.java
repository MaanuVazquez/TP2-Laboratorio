package gui.controladores;

import java.io.IOException;
import java.text.ParseException;

import excepciones.PrestacionExistenteException;
import excepciones.StringVacioException;
import gui.modelos.ModeloPrestacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
	private TextArea textAreaIndicacion;

	@FXML
	private Label labelIndicacion;

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

	private AgregarGrupoDeEstudiosControlador grupoDeEstudiosControlador;

	private GrupoDeEstudios grupoDeEstudiosRecursivo;

	@FXML
	private ObservableList<ModeloPrestacion> listaPrestaciones;

	@FXML
	private void initialize() throws StringVacioException {
		assert textFieldNombre != null : "fx:id=\"textFieldNombre\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
		assert buttonAgregarEstudio != null : "fx:id=\"buttonAgregarEstudio\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
		assert textAreaIndicacion != null : "fx:id=\"textAreaIndicacion\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
		assert labelIndicacion != null : "fx:id=\"labelIndicacion\" was not injected: check your FXML file 'AgregarGrupoDeEstudios.fxml'.";
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
		grupoDeEstudiosRecursivo = g;
		grupoDeEstudiosControlador = a;
	}

	private void verificarString() throws StringVacioException {
		if (this.textFieldNombre.getText().trim().isEmpty() || this.textAreaIndicacion.getText().trim().isEmpty()) {
			throw new StringVacioException();
		}
	}

	@FXML
	private void buttonAgregarEstudioOnAction() throws IOException {
		Stage dialogo = new Stage();
		FXMLLoader loader = this.laboratorioControlador.crearFormulario(dialogo, "agregarEstudio", "Agregar Estudio");
		AgregarEstudioControlador controller = (AgregarEstudioControlador) loader.getController();
		controller.initDataDeGrupo(this, grupo);
		dialogo.show();

	}

	@FXML
	private void buttonAgregarAnalisisOnAction() throws IOException {
		Stage dialogo = new Stage();
		FXMLLoader loader = this.laboratorioControlador.crearFormulario(dialogo, "agregarAnalisis", "Agregar Análisis");
		AgregarAnalisisControlador controller = (AgregarAnalisisControlador) loader.getController();
		controller.initDataDeGrupo(this, grupo);
		dialogo.show();

	}

	@FXML
	private void buttonAgregarGrupoDeEstudiosOnAction() throws IOException {
		Stage dialogo = new Stage();
		FXMLLoader loader = this.laboratorioControlador.crearFormulario(dialogo, "agregarGrupoDeEstudios",
				"Agregar Grupo de Estudios");
		AgregarGrupoDeEstudiosControlador controller = (AgregarGrupoDeEstudiosControlador) loader.getController();
		controller.initDataDeGrupo(this, grupo);
		dialogo.show();

	}

	@FXML
	private void buttonAgregarOnAction() throws IOException, ParseException {

		grupo.setNombre(this.textFieldNombre.getText());
		grupo.setIndicacion(this.textAreaIndicacion.getText());

		if (grupoDeEstudiosRecursivo != null) {
			try {
				verificarString();
				grupoDeEstudiosRecursivo.agregarEstudio(grupo);
				grupoDeEstudiosControlador.actualizarTablaPacientes();
				Stage stage = (Stage) anchorPaneMain.getScene().getWindow();
				stage.close();
			} catch (StringVacioException e) {
				laboratorioControlador.crearMensaje("Error", e.getMessage());
			}

		} else {
			Laboratorio lab = Laboratorio.getIntance();
			try {
				verificarString();
				lab.agregarVisita(grupo, paciente);
				laboratorioControlador.actualizarTablaPrestaciones(paciente);
				Stage stage = (Stage) anchorPaneMain.getScene().getWindow();
				stage.close();
			} catch (PrestacionExistenteException | StringVacioException e) {
				laboratorioControlador.crearMensaje("Error", e.getMessage());
			}

		}

	}

}

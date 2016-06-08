package gui.controladores;

import java.io.IOException;
import java.text.ParseException;

import enums.EstadoPrestacion;
import excepciones.PrestacionExistenteException;
import excepciones.RangoDeValoresInvalido;
import excepciones.StringVacioException;
import excepciones.ValoresNegativosException;
import gui.modelos.ModeloPaciente;
import gui.modelos.ModeloPrestacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import laboratorio.Analisis;
import laboratorio.Estudio;
import laboratorio.GrupoDeEstudios;
import laboratorio.Laboratorio;
import laboratorio.Paciente;
import laboratorio.Prestacion;
import laboratorio.Visita;

public class LaboratorioControlador {

	@FXML
	private AnchorPane anchorPaneMain;

	@FXML
	private Accordion accordionMenu;

	@FXML
	private TitledPane titledPaneVisita;

	@FXML
	private TitledPane titledPaneIngresarResultado;

	@FXML
	private VBox VBoxVisita;

	@FXML
	private VBox VBoxIngresarResultado;

	@FXML
	private HBox hBox;

	@FXML
	private Button buttonVerEstadistica;

	@FXML
	private Button buttonAgregarEstudio;

	@FXML
	private Button buttonAgregarAnalisis;

	@FXML
	private Button buttonAgregarPaciente;

	@FXML
	private Button buttonAgregarGrupoDeEstudios;

	@FXML
	private Button buttonIngresarResultadoPorPaciente;

	@FXML
	private Button buttonIngresarResultadoPorPrestacion;

	@FXML
	private Label labelPrestaciones;

	@FXML
	private Label labelPacientes;

	@FXML
	private TableView<ModeloPrestacion> tableViewPrestaciones;

	@FXML
	private TableColumn<ModeloPrestacion, String> prestacionNombre;

	@FXML
	private TableColumn<ModeloPrestacion, String> prestacionIndicacion;

	@FXML
	private TableColumn<ModeloPrestacion, String> prestacionEstado;

	@FXML
	private TableView<ModeloPaciente> tableViewPacientes;

	@FXML
	private TableColumn<ModeloPaciente, Integer> pacienteID;

	@FXML
	private TableColumn<ModeloPaciente, String> pacienteNombre;
	@FXML
	private TableColumn<ModeloPaciente, Integer> pacienteDNI;

	@FXML
	private TableColumn<ModeloPaciente, String> pacienteTelefono;

	@FXML
	private TableColumn<ModeloPaciente, String> pacienteMail;

	@FXML
	private ObservableList<ModeloPaciente> listaPacientes;

	@FXML
	private ObservableList<ModeloPrestacion> listaPrestaciones;

	private static Laboratorio laboratorio = Laboratorio.getIntance();

	private String resultadoFXML;
	private String resultadoTitle;
	private String tipoPrestacion;

	@FXML
	private void initialize() throws StringVacioException, ValoresNegativosException, PrestacionExistenteException,
			RangoDeValoresInvalido, ParseException {
		assert buttonAgregarEstudio != null : "fx:id=\"buttonAgregarEstudio\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert buttonIngresarResultadoPorPaciente != null : "fx:id=\"buttonIngresarResultadoPorPaciente\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert buttonAgregarPaciente != null : "fx:id=\"buttonAgregarPaciente\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert tableViewPacientes != null : "fx:id=\"tableViewPacientes\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert buttonAgregarAnalisis != null : "fx:id=\"buttonAgregarAnalisis\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert prestacionIndicacion != null : "fx:id=\"prestacionIndicacion\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert pacienteMail != null : "fx:id=\"pacienteMail\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert VBoxIngresarResultado != null : "fx:id=\"VBoxIngresarResultado\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert pacienteNombre != null : "fx:id=\"pacienteNombre\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert buttonVerEstadistica != null : "fx:id=\"buttonVerEstadistica\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert anchorPaneMain != null : "fx:id=\"anchorPaneMain\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert titledPaneIngresarResultado != null : "fx:id=\"titledPaneIngresarResultado\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert labelPrestaciones != null : "fx:id=\"labelPrestaciones\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert labelPacientes != null : "fx:id=\"labelPacientes\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert titledPaneVisita != null : "fx:id=\"titledPaneVisita\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert tableViewPrestaciones != null : "fx:id=\"tableViewPrestaciones\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert buttonIngresarResultadoPorPrestacion != null : "fx:id=\"buttonIngresarResultadoPorPrestacion\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert accordionMenu != null : "fx:id=\"accordionMenu\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert pacienteTelefono != null : "fx:id=\"pacienteTelefono\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert prestacionNombre != null : "fx:id=\"prestacionNombre\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert prestacionEstado != null : "fx:id=\"prestacionEstado\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert VBoxVisita != null : "fx:id=\"VBoxVisita\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert pacienteID != null : "fx:id=\"pacienteID\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert pacienteDNI != null : "fx:id=\"pacienteDNI\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert buttonAgregarGrupoDeEstudios != null : "fx:id=\"buttonAgregarGrupoDeEstudios\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		popularPrograma();
		inicializarColumnas();
		actualizarTablaPacientes();
	}

	private void popularPrograma() throws StringVacioException, ValoresNegativosException, PrestacionExistenteException,
			RangoDeValoresInvalido, ParseException {
		Paciente p = new Paciente("Juan Perez", 12345670, "03034567", "hola@hola.com");
		Paciente p2 = new Paciente("Roberto Gomez Bolaños", 12345671, "03034567", "hola@hola.com");
		Paciente p3 = new Paciente("Bruce Wayne", 12345672, "03034567", "hola@hola.com");
		Paciente p4 = new Paciente("Danny Trejo", 12345673, "03034567", "hola@hola.com");
		laboratorio.agregarPaciente(p);
		laboratorio.agregarPaciente(p2);
		laboratorio.agregarPaciente(p3);
		laboratorio.agregarPaciente(p4);
		laboratorio.agregarVisita(new Estudio("Electroencefalograma", "faltan elementos necesarios"), p);
		laboratorio.agregarVisita(new Analisis("Sangre", "ninguna", 1, 10), p);
		GrupoDeEstudios g = new GrupoDeEstudios("Grupo Hemograma", "ninguna");
		g.agregarEstudio(new Analisis("Hematocrito", "ninguna", 1, 10));
		g.agregarEstudio(new Analisis("Prequirúrjico", "ninguna", 1, 10));
		g.agregarEstudio(new Estudio("Electroencefalograma", "faltan elementos necesarios"));
		g.agregarEstudio(new GrupoDeEstudios("Grupo perfil de leucocitos", "ninguna"));
		laboratorio.agregarVisita(g, p);
	}

	private void inicializarColumnas() {

		/* Tabla Paciente */
		this.tableViewPacientes.setPlaceholder(new Label("No hay pacientes"));
		this.pacienteID.setCellValueFactory(new PropertyValueFactory<ModeloPaciente, Integer>("id"));
		this.pacienteNombre.setCellValueFactory(new PropertyValueFactory<ModeloPaciente, String>("nombre"));
		this.pacienteDNI.setCellValueFactory(new PropertyValueFactory<ModeloPaciente, Integer>("DNI"));
		this.pacienteTelefono.setCellValueFactory(new PropertyValueFactory<ModeloPaciente, String>("telefono"));
		this.pacienteMail.setCellValueFactory(new PropertyValueFactory<ModeloPaciente, String>("mail"));

		/* Tabla prestaciones */
		this.tableViewPrestaciones.setPlaceholder(new Label("No se ha seleccionado un paciente"));
		this.prestacionNombre.setCellValueFactory(new PropertyValueFactory<ModeloPrestacion, String>("nombre"));
		this.prestacionIndicacion.setCellValueFactory(new PropertyValueFactory<ModeloPrestacion, String>("indicacion"));
		this.prestacionEstado.setCellValueFactory(new PropertyValueFactory<ModeloPrestacion, String>("estado"));

	}

	public void actualizarTablaPacientes() {
		listaPacientes = FXCollections.observableArrayList();

		for (Paciente paciente : laboratorio.getPacientes().values()) {
			ModeloPaciente modeloPaciente = new ModeloPaciente(paciente.getId(), paciente.getNombre(),
					paciente.getDni(), paciente.getTelefono(), paciente.getMail());
			listaPacientes.add(modeloPaciente);
		}

		tableViewPacientes.setItems(listaPacientes);

	}

	public void actualizarTablaPrestaciones(Paciente p) {

		listaPrestaciones = FXCollections.observableArrayList();

		for (Visita v : laboratorio.getVisitas().values()) {
			if (v.getPaciente() == p) {
				Prestacion prestacion = v.getPrestacion();
				ModeloPrestacion modeloPrestacion = new ModeloPrestacion(prestacion.getId(), prestacion.getNombre(),
						prestacion.getIndicacion(), prestacion.getEstado().toString());
				listaPrestaciones.add(modeloPrestacion);
			}

		}
		tableViewPrestaciones.setPlaceholder(new Label("El paciente no tiene prestaciones"));
		tableViewPrestaciones.setItems(listaPrestaciones);

	}

	public void setResultadoForm(String tipoDePrestacion) {
		switch (tipoDePrestacion) {
		case "Analisis":
			this.resultadoFXML = "IngresarResultadoAnalisis";
			this.resultadoTitle = "Análisis ";
			break;
		case "GrupoDeEstudios":
			this.resultadoFXML = "IngresarResultadoGrupal";
			this.resultadoTitle = "Grupo de Estudios ";
			break;
		default:
			this.resultadoFXML = "IngresarResultadoEstudio";
			this.resultadoTitle = "Estudio ";
			break;
		}
		this.tipoPrestacion = tipoDePrestacion;
	}

	public FXMLLoader crearDialogo(Stage dialogo, String nombreFXML, String tituloDialogo) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/vistas/" + nombreFXML + ".fxml"));
		AnchorPane root;
		root = (AnchorPane) loader.load();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/gui/vistas/Laboratorio.css").toExternalForm());
		dialogo.initStyle(StageStyle.DECORATED);
		dialogo.initModality(Modality.APPLICATION_MODAL);
		dialogo.setScene(scene);
		dialogo.setTitle(tituloDialogo);
		dialogo.setResizable(false);
		return loader;
	}

	public void mensaje(String titulo, String mensaje) throws IOException {

		Stage dialogo = new Stage();
		FXMLLoader loader = crearDialogo(dialogo, "Mensaje", titulo);
		MensajeControlador controller = (MensajeControlador) loader.getController();
		controller.inicializador(mensaje);
		dialogo.show();

	}

	@FXML
	void tableViewPacientesOnMouseClicked() {
		ModeloPaciente modeloPaciente;
		if ((modeloPaciente = tableViewPacientes.getSelectionModel().getSelectedItem()) != null) {
			for (Paciente p : laboratorio.getPacientes().values()) {
				if (p.getId() == modeloPaciente.getId()) {
					actualizarTablaPrestaciones(p);
				}
			}
		}
	}

	@FXML
	private void buttonAgregarPacienteOnAction() throws IOException {

		Stage dialogo = new Stage();
		FXMLLoader loader = crearDialogo(dialogo, "agregarPaciente", "Agregar Paciente");
		AgregarPacienteControlador controller = (AgregarPacienteControlador) loader.getController();
		controller.initData(this);
		dialogo.show();

	}

	@FXML
	void buttonAgregarAnalisisOnAction() throws IOException {

		if (tableViewPacientes.getSelectionModel().getSelectedItem() != null) {
			Stage dialogo = new Stage();
			FXMLLoader loader = crearDialogo(dialogo, "agregarAnalisis", "Agregar Análisis");
			AgregarAnalisisControlador controller = (AgregarAnalisisControlador) loader.getController();
			Paciente p = laboratorio.buscarPaciente(tableViewPacientes.getSelectionModel().getSelectedItem().getDNI());
			controller.initData(this, p);
			dialogo.show();
		} else {
			mensaje("Error", "No se ha seleccionado ningún paciente");
		}

	}

	@FXML
	void buttonAgregarEstudioOnAction() throws IOException {
		if (tableViewPacientes.getSelectionModel().getSelectedItem() != null) {
			Stage dialogo = new Stage();
			FXMLLoader loader = crearDialogo(dialogo, "agregarEstudio", "Agregar Estudio");
			AgregarEstudioControlador controller = (AgregarEstudioControlador) loader.getController();
			Paciente p = laboratorio.buscarPaciente(tableViewPacientes.getSelectionModel().getSelectedItem().getDNI());
			controller.initData(this, p);
			dialogo.show();
		} else {
			mensaje("Error", "No se ha seleccionado ningún paciente");
		}
	}

	@FXML
	void buttonAgregarGrupoDeEstudiosOnAction() throws IOException {
		if (tableViewPacientes.getSelectionModel().getSelectedItem() != null) {
			Stage dialogo = new Stage();
			FXMLLoader loader = crearDialogo(dialogo, "agregarGrupoDeEstudios", "Agregar Grupo de Estudios");
			AgregarGrupoDeEstudiosControlador controller = (AgregarGrupoDeEstudiosControlador) loader.getController();
			Paciente p = laboratorio.buscarPaciente(tableViewPacientes.getSelectionModel().getSelectedItem().getDNI());
			controller.initData(this, p);
			dialogo.show();
		} else {
			mensaje("Error", "No se ha seleccionado ningún paciente");
		}
	}

	@FXML
	void buttonIngresarResultadoPorPrestacionOnAction() throws IOException {
		Stage dialogo = new Stage();
		FXMLLoader loader = crearDialogo(dialogo, "IngresarResultadoPorFiltro", "Filtrar Prestaciones");
		IngresarResultadoPorFiltroControlador controller = (IngresarResultadoPorFiltroControlador) loader
				.getController();
		if (tableViewPacientes.getSelectionModel().getSelectedItem() != null) {
			Paciente p = laboratorio.buscarPaciente(tableViewPacientes.getSelectionModel().getSelectedItem().getDNI());
			controller.inicializarLaboratorio(this, p);

		} else {
			controller.inicializarLaboratorio(this);
		}
		dialogo.show();
	}

	@FXML
	void buttonIngresarResultadoPorPacienteOnAction() throws IOException {

		ModeloPrestacion modeloPrestacion;
		if ((modeloPrestacion = tableViewPrestaciones.getSelectionModel().getSelectedItem()) != null) {
			Prestacion prestacion = laboratorio.getPrestaciones().get(modeloPrestacion.getId());
			if (prestacion.getEstado() != EstadoPrestacion.FINALIZADO) {
				setResultadoForm(prestacion.getResultForm());
				Stage dialogo = new Stage();
				FXMLLoader loader = crearDialogo(dialogo, this.resultadoFXML, this.resultadoTitle + prestacion.getId());
				Paciente paciente = laboratorio
						.buscarPaciente(tableViewPacientes.getSelectionModel().getSelectedItem().getDNI());
				if (this.tipoPrestacion.equals("Analisis")) {
					IngresarResultadoAnalisisControlador controller = (IngresarResultadoAnalisisControlador) loader
							.getController();
					controller.inicializarDeLaboratorio(this, (Analisis) prestacion, paciente);
				} else if (this.tipoPrestacion.equals("GrupoDeEstudios")) {
					IngresarResultadoGrupalControlador controller = (IngresarResultadoGrupalControlador) loader
							.getController();
					controller.inicializarDeLaboratorio(this, (GrupoDeEstudios) prestacion, paciente);
				} else {
					IngresarResultadoEstudioControlador controller = (IngresarResultadoEstudioControlador) loader
							.getController();
					controller.inicializarDeLaboratorio(this, (Estudio) prestacion, paciente);
				}
				dialogo.show();
			} else {
				mensaje("Error", "La prestación seleccionada ya se encuentra finalizada");
			}
		} else {
			mensaje("Error", "No se ha seleccionado ningúna prestación");
		}

	}

	@FXML
	void buttonVerEstadisticaOnAction() throws IOException {
		Stage dialogo = new Stage();
		FXMLLoader loader = crearDialogo(dialogo, "MostrarEstadistica", "Estadisticas de Prestaciones");
		MostrarEstadisticaControlador controller = (MostrarEstadisticaControlador) loader.getController();
		controller.inicializarDeLaboratorio(this);
		dialogo.show();
	}

}

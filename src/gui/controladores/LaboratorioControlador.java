package gui.controladores;

import java.io.IOException;

import excepciones.PrestacionExistenteException;
import excepciones.StringVacioException;
import excepciones.ValoresNegativosException;
import gui.modelos.ModeloPaciente;
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
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import laboratorio.Estudio;
import laboratorio.Laboratorio;
import laboratorio.Paciente;
import laboratorio.Prestacion;
import laboratorio.Visita;

public class LaboratorioControlador {

	private static Laboratorio lab = Laboratorio.getIntance();

	@FXML
	private AnchorPane anchorPaneMain;

	@FXML
	private HBox hBox;

	@FXML
	private Button buttonAgregarEstudio;

	@FXML
	private Button buttonAgregarAnalisis;

	@FXML
	private Button buttonAgregarPaciente;

	@FXML
	private Button buttonAgregarGrupoDeEstudios;

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

	@FXML
	private void initialize() throws StringVacioException, ValoresNegativosException, PrestacionExistenteException {
		assert anchorPaneMain != null : "fx:id=\"anchorPaneMain\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert buttonAgregarPaciente != null : "fx:id=\"buttonAgregarPaciente\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert tableViewPacientes != null : "fx:id=\"tableViewPacientes\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert pacienteMail != null : "fx:id=\"pacienteMail\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert pacienteID != null : "fx:id=\"pacienteID\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert pacienteNombre != null : "fx:id=\"pacienteNombre\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert pacienteDNI != null : "fx:id=\"pacienteDNI\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		assert pacienteTelefono != null : "fx:id=\"pacienteTelefono\" was not injected: check your FXML file 'Laboratorio.fxml'.";
		popularPrograma();
		inicializarColumnas();
		actualizarTablaPacientes();
		this.tableViewPacientes.setPlaceholder(new Label("No hay pacientes"));
		this.tableViewPrestaciones.setPlaceholder(new Label("No se ha seleccionado un paciente"));
	}

	private void popularPrograma()
			throws StringVacioException, ValoresNegativosException, PrestacionExistenteException {
		Paciente p = new Paciente("Juan Perez", 12345670, "03034567", "hola@hola.com");
		Paciente p2 = new Paciente("Roberto Gomez Bolaños", 12345671, "03034567", "hola@hola.com");
		Paciente p3 = new Paciente("Bruce Wayne", 12345672, "03034567", "hola@hola.com");
		Paciente p4 = new Paciente("Danny Trejo", 12345673, "03034567", "hola@hola.com");
		lab.agregarPaciente(p);
		lab.agregarPaciente(p2);
		lab.agregarPaciente(p3);
		lab.agregarPaciente(p4);
		lab.agregarVisita(new Estudio("Lisopotocotomiaterapiapeutica", "morira en 1 dia"), p);
	}

	private void inicializarColumnas() {

		/* Tabla Paciente */
		this.pacienteID.setCellValueFactory(new PropertyValueFactory<ModeloPaciente, Integer>("id"));
		this.pacienteNombre.setCellValueFactory(new PropertyValueFactory<ModeloPaciente, String>("nombre"));
		this.pacienteDNI.setCellValueFactory(new PropertyValueFactory<ModeloPaciente, Integer>("DNI"));
		this.pacienteTelefono.setCellValueFactory(new PropertyValueFactory<ModeloPaciente, String>("telefono"));
		this.pacienteMail.setCellValueFactory(new PropertyValueFactory<ModeloPaciente, String>("mail"));

		/* Tabla prestaciones */
		this.prestacionNombre.setCellValueFactory(new PropertyValueFactory<ModeloPrestacion, String>("nombre"));
		this.prestacionIndicacion.setCellValueFactory(new PropertyValueFactory<ModeloPrestacion, String>("indicacion"));
		this.prestacionEstado.setCellValueFactory(new PropertyValueFactory<ModeloPrestacion, String>("estado"));

	}

	public void actualizarTablaPacientes() {
		listaPacientes = FXCollections.observableArrayList();

		for (Paciente paciente : lab.getPacientes().values()) {
			ModeloPaciente modeloPaciente = new ModeloPaciente(paciente.getId(), paciente.getNombre(),
					paciente.getDni(), paciente.getTelefono(), paciente.getMail());
			listaPacientes.add(modeloPaciente);
		}

		tableViewPacientes.setItems(listaPacientes);

	}

	public void actualizarTablaPrestaciones(Paciente p) {

		listaPrestaciones = FXCollections.observableArrayList();

		for (Visita v : lab.getVisitas().values()) {
			if (v.getPaciente() == p) {
				Prestacion prestacion = v.getPrestacion();
				ModeloPrestacion modeloPrestacion = new ModeloPrestacion(prestacion.getNombre(),
						prestacion.getIndicacion(), prestacion.getEstado().toString());
				listaPrestaciones.add(modeloPrestacion);
			}

		}
		tableViewPrestaciones.setPlaceholder(new Label("El paciente no tiene prestaciones"));
		tableViewPrestaciones.setItems(listaPrestaciones);

	}

	@FXML
	void tableViewPacientesOnMouseClicked() {
		ModeloPaciente modeloPaciente;
		if ((modeloPaciente = tableViewPacientes.getSelectionModel().getSelectedItem()) != null) {
			for (Paciente p : lab.getPacientes().values()) {
				if (p.getId() == modeloPaciente.getId()) {
					actualizarTablaPrestaciones(p);
				}
			}
		}
	}

	@FXML
	private void buttonAgregarPacienteOnAction() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/vistas/agregarPaciente.fxml"));
		AnchorPane root;
		root = (AnchorPane) loader.load();
		Scene scene = new Scene(root);
		Stage dialogoAgregarPaciente = new Stage();
		scene.getStylesheets().add(getClass().getResource("/gui/vistas/Laboratorio.css").toExternalForm());
		dialogoAgregarPaciente.initOwner(anchorPaneMain.getScene().getWindow());
		dialogoAgregarPaciente.initStyle(StageStyle.DECORATED);
		dialogoAgregarPaciente.initModality(Modality.APPLICATION_MODAL);
		dialogoAgregarPaciente.setScene(scene);
		dialogoAgregarPaciente.setTitle("Agregar Paciente");
		dialogoAgregarPaciente.setResizable(false);
		AgregarPacienteControlador controller = (AgregarPacienteControlador) loader.getController();
		controller.initData(this);
		dialogoAgregarPaciente.show();

	}

	@FXML
	void buttonAgregarAnalisisOnAction() throws IOException {

		if (tableViewPacientes.getSelectionModel().getSelectedItem() != null) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/vistas/agregarAnalisis.fxml"));
			AnchorPane root;
			root = (AnchorPane) loader.load();
			Scene scene = new Scene(root);
			Stage dialogoAgregarEstudio = new Stage();
			scene.getStylesheets().add(getClass().getResource("/gui/vistas/Laboratorio.css").toExternalForm());
			dialogoAgregarEstudio.initOwner(anchorPaneMain.getScene().getWindow());
			dialogoAgregarEstudio.initStyle(StageStyle.DECORATED);
			dialogoAgregarEstudio.initModality(Modality.APPLICATION_MODAL);
			dialogoAgregarEstudio.setScene(scene);
			dialogoAgregarEstudio.setTitle("Agregar Analisis");
			dialogoAgregarEstudio.setResizable(false);
			AgregarAnalisisControlador controller = (AgregarAnalisisControlador) loader.getController();
			Paciente p = lab.buscarPaciente(tableViewPacientes.getSelectionModel().getSelectedItem().getId());
			controller.initData(this, p);
			dialogoAgregarEstudio.show();
		} else {
			// UN VALE DE MOSTRAR ERROR jeje
		}

	}

	@FXML
	void buttonAgregarEstudioOnAction() throws IOException {
		if (tableViewPacientes.getSelectionModel().getSelectedItem() != null) {
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
			Paciente p = lab.buscarPaciente(tableViewPacientes.getSelectionModel().getSelectedItem().getId());
			controller.initData(this, p);
			dialogoAgregarEstudio.show();
		} else {
			// UN VALE DE MOSTRAR ERROR jeje
		}
	}

	@FXML
	void buttonAgregarGrupoDeEstudiosOnAction() throws IOException {
		if (tableViewPacientes.getSelectionModel().getSelectedItem() != null) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/vistas/agregarGrupoDeEstudios.fxml"));
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
			AgregarGrupoDeEstudiosControlador controller = (AgregarGrupoDeEstudiosControlador) loader.getController();
			Paciente p = lab.buscarPaciente(tableViewPacientes.getSelectionModel().getSelectedItem().getId());
			controller.initData(this, p);
			dialogoAgregarEstudio.show();
		} else {
			// UN VALE DE MOSTRAR ERROR jeje
		}
	}

}

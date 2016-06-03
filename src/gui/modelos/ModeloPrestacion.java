package gui.modelos;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ModeloPrestacion {

	private SimpleIntegerProperty id = new SimpleIntegerProperty();
	private SimpleStringProperty nombre = new SimpleStringProperty();
	private SimpleStringProperty indicacion = new SimpleStringProperty();
	private SimpleStringProperty estado = new SimpleStringProperty();

	public ModeloPrestacion(Integer id, String nombre, String indicacion, String estado) {
		setId(id);
		setNombre(nombre);
		setIndicacion(indicacion);
		setEstado(estado);
	}

	public Integer getId() {
		return this.id.get();
	}

	public void setId(Integer id) {
		this.id.set(id);
	}

	public String getNombre() {
		return this.nombre.get();
	}

	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}

	public String getIndicacion() {
		return this.indicacion.get();
	}

	public void setIndicacion(String indicacion) {
		this.indicacion.set(indicacion);
	}

	public String getEstado() {
		return this.estado.get();
	}

	public void setEstado(String estado) {
		this.estado.set(estado);
	}

}

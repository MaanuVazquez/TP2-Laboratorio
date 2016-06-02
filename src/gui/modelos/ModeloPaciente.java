package gui.modelos;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ModeloPaciente {

	private SimpleIntegerProperty id = new SimpleIntegerProperty();
	private SimpleStringProperty nombre = new SimpleStringProperty();
	private SimpleIntegerProperty DNI = new SimpleIntegerProperty();
	private SimpleStringProperty telefono = new SimpleStringProperty();
	private SimpleStringProperty mail = new SimpleStringProperty();

	public ModeloPaciente(Integer id, String nombre, Integer DNI, String telefono, String mail) {
		setId(id);
		setNombre(nombre);
		setDNI(DNI);
		setTelefono(telefono);
		setMail(mail);
	}

	public Integer getId() {
		return id.get();
	}

	public void setId(Integer id) {
		this.id.set(id);
	}

	public String getNombre() {
		return nombre.get();
	}

	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}

	public Integer getDNI() {
		return DNI.get();
	}

	public void setDNI(Integer DNI) {
		this.DNI.set(DNI);
	}

	public String getTelefono() {
		return telefono.get();
	}

	public void setTelefono(String telefono) {
		this.telefono.set(telefono);
	}

	public String getMail() {
		return mail.get();
	}

	public void setMail(String mail) {
		this.mail.set(mail);
	}

}

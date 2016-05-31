package laboratorio;

import excepciones.StringVacioException;
import excepciones.ValoresNegativosException;

public class Paciente {

	private static int idMax = 1;
	private int id;
	private String nombre;
	private Integer dni;
	private String telefono;
	private String mail;

	public Paciente(String nombre, Integer dni, String telefono, String mail)
			throws StringVacioException, ValoresNegativosException {
		this.id = idMax;
		idMax++;
		this.setNombre(nombre);
		this.setDni(dni);
		this.setTelefono(telefono);
		this.setMail(mail);

	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws StringVacioException {
		this.validarStrings(nombre);
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) throws ValoresNegativosException {
		this.validarEnteros(dni);
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) throws StringVacioException {
		this.validarStrings(telefono);
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) throws StringVacioException {
		this.validarStrings(mail);
		this.mail = mail;
	}

	private void validarStrings(String str) throws StringVacioException {

		if ("".equals(str) || str == null) {
			throw new StringVacioException();
		}

	}

	private void validarEnteros(Integer valor) throws ValoresNegativosException {

		if (valor <= 0) {
			throw new ValoresNegativosException(valor);
		}
	}
}

package laboratorio;

import excepciones.PacienteRegistroException;

public class Paciente {

	private static int idMax = 1;
	private int id;
	private String nombre;
	private Integer dni;
	private String telefono;
	private String mail;

	public Paciente(String nombre, Integer dni, String telefono, String mail) throws PacienteRegistroException {
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

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws PacienteRegistroException {
		this.validarStrings(nombre);
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) throws PacienteRegistroException {
		this.validarEnteros(dni);
		this.dni = dni;
	}

	

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) throws PacienteRegistroException {
		this.validarStrings(telefono);
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) throws PacienteRegistroException {
		this.validarStrings(mail);
		this.mail = mail;
	}
	
	private void validarStrings(String str) throws PacienteRegistroException {
		
		if("".equals(str) || str == null){
			throw new PacienteRegistroException("Las cadenas de caracteres no pueden estar vacías");
		}
		
	}
	
	private void validarEnteros(Integer entero) throws PacienteRegistroException {
		
		if(entero <= 0){
			throw new PacienteRegistroException("Los numeros enteros deben ser mayores a cero");
		}
		
	}
	
	

}

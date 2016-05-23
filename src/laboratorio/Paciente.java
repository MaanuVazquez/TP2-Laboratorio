package laboratorio;

public class Paciente {

	private static int idMax = 1;
	private int id;
	private String nombre;
	private String dni;
	private String telefono;
	private String mail;

	public Paciente(String nombre, String dni, String telefono, String mail) {
		this.id = idMax;
		idMax++;
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.mail = mail;
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}

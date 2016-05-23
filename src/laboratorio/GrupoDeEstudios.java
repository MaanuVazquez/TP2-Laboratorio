package laboratorio;

import java.util.LinkedList;

public class GrupoDeEstudios extends Prestacion {

	private LinkedList<Prestacion> estudios;

	public GrupoDeEstudios(String nombre, String indicacion) {
		super(nombre, indicacion);
		this.estudios = new LinkedList<Prestacion>();
	}

	public void agregarEstudio(Prestacion e) {
		this.estudios.add(e);
	}

	public void removerEstudio(Prestacion e) {
		this.estudios.remove(e);
	}

	public String toString() {
		String cadena = "Lista de Estudios: ";
		for (Prestacion e : estudios) {
			cadena += " " + e + "\n";
		}
		return cadena;
	}

	public void mostrarEstudios() {
		System.out.println(this);
	}

	@Override
	public String getResultado() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

}

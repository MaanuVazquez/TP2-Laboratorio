package laboratorio;

import java.util.LinkedList;

import excepciones.PrestacionRegistroException;

public class GrupoDeEstudios extends Prestacion {

	//PREGUNTA NO SERIA MEJOR UN MAP QUE IDENTIFICA POR ID LAS PRESTACIONES DEL GRUPO DE ESTUDIOS, ES MAS FACIL DE BORRAR LUEGO
	//PUEDEN EXISTIR IGUAL MULTIPLES GRUPOS DE ESTUDIOS CON ESTUDIOS IGUALES, SER MAP NO LO AFECTO A ESO
	private LinkedList<Prestacion> estudios;

	public GrupoDeEstudios(String nombre, String indicacion) throws PrestacionRegistroException {
		super(nombre, indicacion);
		this.estudios = new LinkedList<Prestacion>();
	}

	public void agregarEstudio(Prestacion e) {
		this.estudios.add(e);
	}

	public void removerEstudio(Prestacion e) {
		this.estudios.remove(e);
		//ACA HABRIA QUE SOBREESCRIBIR EL EQUALS PERO SI FUESE UN MAP SOLO LO BORRAMOS POR LA CLAVE
	}

	public String toString() {
		String cadena = "Lista de estudios de "+this.getNombre()+": \n";
		for (Prestacion e : estudios) {
			cadena += " " + e.getNombre() + "\n";
		}
		return cadena;
	}

	public void mostrarEstudios() {
		System.out.println(this.toString());
	}

	@Override
	public String getResultado() {
		return null;
		
	}

	@Override
	public void setValoresEstadisticos(Estadistica estadistica) {
		//hay que recorrer la lista y hacer la estadistica, queda para despues si con las hojas lo hace bien
		
	}

}

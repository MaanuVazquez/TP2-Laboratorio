package laboratorio;

import java.util.HashMap;

import excepciones.StringVacioException;

public class GrupoDeEstudios extends Prestacion {

	private HashMap<Integer, Prestacion> estudios;

	public GrupoDeEstudios(String nombre, String indicacion) throws StringVacioException {
		super(nombre, indicacion);
		this.estudios = new HashMap<Integer, Prestacion>();
	}

	/*
	 * return false si el estudio ya se encontraba agregado
	 */
	
	public boolean agregarEstudio(Prestacion prestacion) {
		return (this.estudios.put(prestacion.getId(), prestacion) == null);
	}

	public String toString() {
		String cadena = "Lista de estudios de "+this.getNombre()+": \n";
		for (Prestacion e : estudios.values()) {
			cadena += " " + e.getNombre() + "\n";
		}
		return cadena;
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

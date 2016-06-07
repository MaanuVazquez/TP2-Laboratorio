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

	public HashMap<Integer, Prestacion> getEstudios() {
		return this.estudios;
	}

	@Override
	public String getResultado() {
		String resultado = super.toString() + "/n";
		for (Prestacion prestacion : estudios.values()) {
			resultado += " " + prestacion.getResultado() + "\n";
		}
		return resultado;
	}

	@Override
	public void getValoresEstadisticos(Estadistica estadistica) {
		for (Integer i : estudios.keySet()) {
			estudios.get(i).getValoresEstadisticos(estadistica);
		}
	}

	@Override
	public String getResultForm() {
		return "GrupoDeEstudios";
	}
}

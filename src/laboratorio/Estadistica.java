package laboratorio;

import java.util.Iterator;
import java.util.TreeMap;

import estadisticas.EstadisticaAnalisis;
import estadisticas.EstadisticaEstudios;
import estadisticas.EstadisticaIndividual;

public class Estadistica {

	TreeMap<String, EstadisticaIndividual> estadisticas;

	public Estadistica() {
		estadisticas = new TreeMap<String, EstadisticaIndividual>();
	}

	public void addPrestacion(Prestacion p) {
		p.getValoresEstadisticos(this);
	}

	public String mostrarEstadistica() {
		String resultado = "";
		Iterator<String> iterador = estadisticas.keySet().iterator();
		while (iterador.hasNext()) {
			resultado += estadisticas.get(iterador.next()).toString();
		}
		return resultado;
	}

	public void agregarAnalisis(Analisis analisis) {
		if (!estadisticas.containsKey(analisis.getNombre())) {
			estadisticas.put(analisis.getNombre(), new EstadisticaAnalisis(analisis));
		} else {
			estadisticas.get(analisis.getNombre()).agregarPrestacion(analisis);
		}
	}

	public void agregarEstudio(Estudio estudio) {
		if (!estadisticas.containsKey(estudio.getNombre())) {
			estadisticas.put(estudio.getNombre(), new EstadisticaEstudios(estudio));
		} else {
			estadisticas.get(estudio.getNombre()).agregarPrestacion(estudio);
		}
	}
}
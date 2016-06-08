package laboratorio;

import enums.ClasificacionEstudio;
import enums.EstadoPrestacion;
import excepciones.StringVacioException;

public class Estudio extends Prestacion {

	private ClasificacionEstudio clasificacion;
	private String informe;

	public Estudio(String nombre, String indicacion) throws StringVacioException {
		super(nombre, indicacion);
	}

	public void setResultado(ClasificacionEstudio clasificacion, String informe) throws StringVacioException {
		this.validarStrings(informe);
		this.clasificacion = clasificacion;
		this.informe = informe;
		this.setEstado(EstadoPrestacion.FINALIZADO);
	}

	public ClasificacionEstudio getClasificacion() {
		return clasificacion;
	}

	public String getInforme() {
		return informe;
	}

	@Override
	public void getValoresEstadisticos(Estadistica estadistica) {
		if (this.getEstado().equals(EstadoPrestacion.FINALIZADO)) {
			estadistica.agregarEstudio(this);
		}
	}

	@Override
	public String getResultado() {
		return super.getResultado() + "Clasificacion: " + this.getClasificacion().toString() + ". " + this.informe + ".";
	}

	@Override
	public String getResultForm() {
		return "Estudio";
	}
}

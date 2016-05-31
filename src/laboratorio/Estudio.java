package laboratorio;

import enums.ClasificacionEstudio;
import enums.EstadoPrestacion;
import estadisticas.EstadisticaEstudios;
import excepciones.StringVacioException;

public class Estudio extends Prestacion {
	
	private ClasificacionEstudio clasificacion;
	private String informe;

	public Estudio(String nombre, String indicacion) throws StringVacioException  {
		super(nombre, indicacion);
	}
	
	public void setResultado(ClasificacionEstudio clasificacion , String informe) throws StringVacioException {
		this.validarStrings(informe);
		this.clasificacion = clasificacion;
		this.informe = informe;
		
		//CUANDO SE CARGAN LOS RESULTADOS SE PONE EN FINALIZADO
		this.setEstado(EstadoPrestacion.FINALIZADO);
	}
	
	@Override
	public void setValoresEstadisticos(Estadistica estadistica) {
		
		if (estadistica.estadisticaEstudios == null) {
			estadistica.estadisticaEstudios = new EstadisticaEstudios();
		}
		
		//Aca esta la clave de la estadistica sin hacer instance of
		estadistica.estadisticaEstudios.setValoresEstadisticos(this);
		
	}

	public ClasificacionEstudio getClasificacion() {
		return clasificacion;
	}

	public String getInforme() {
		return informe;
	}

	@Override
	public String getResultado() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
	}

}

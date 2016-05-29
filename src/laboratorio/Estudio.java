package laboratorio;

import enums.ClasificacionEstudio;
import enums.EstadoPrestacion;
import excepciones.PrestacionRegistroException;

public class Estudio extends Prestacion {
	
	private ClasificacionEstudio clasificacion;
	private String informe;

	public Estudio(String nombre, String indicacion) throws PrestacionRegistroException {
		super(nombre, indicacion);
	}

	public ClasificacionEstudio getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(ClasificacionEstudio clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getInforme() {
		return informe;
	}

	public void setInforme(String informe) throws PrestacionRegistroException {
		this.validarStrings(informe);
		this.informe = informe;
	}

	@Override
	public String getResultado() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
	}
	
	public void setResultado(ClasificacionEstudio clasificacion , String informe) throws PrestacionRegistroException {
		this.setClasificacion(clasificacion);
		this.setInforme(informe);
		
		//CUANDO SE CARGAN LOS RESULTADOS SE PONE EN FINALIZADO
		this.setEstado(EstadoPrestacion.FINALIZADO);
	}

	
	

}

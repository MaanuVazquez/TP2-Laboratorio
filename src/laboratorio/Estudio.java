package laboratorio;

import enums.ClasificacionEstudio;

public class Estudio extends Prestacion {
	
	private ClasificacionEstudio clasificacion;
	private String informe;

	public Estudio(String nombre, String indicacion, boolean resultado) {
		super(nombre, indicacion);
	}

	@Override
	public String getResultado() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
	}
	
	public void setResultado(ClasificacionEstudio clasificacion , String informe) {
		this.clasificacion = clasificacion;
		this.informe = informe;
	}

	
	

}

package laboratorio;

import enums.EstadoPrestacion;
import excepciones.StringVacioException;

public abstract class Prestacion {
	
	private static Integer idMax = 1;
	private Integer id;
	private String nombre;
	private String indicacion;
	private EstadoPrestacion estado;
	
	public Prestacion(String nombre, String indicacion) throws StringVacioException {
		validarStrings(indicacion);
		validarStrings(nombre);
		this.id = new Integer(Prestacion.idMax.intValue());
		Prestacion.idMax++;
		this.nombre = nombre;
		this.indicacion = indicacion;
		this.setEstado(EstadoPrestacion.PENDIENTE);
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getIndicacion() {
		return indicacion;
	}
	
	public EstadoPrestacion getEstado() {
		return estado;
	}
	
	protected void validarStrings(String str) throws StringVacioException {
		
		if("".equals(str) || str == null){
			throw new StringVacioException();
		}
	}
	
	protected void setEstado(EstadoPrestacion estado) {
		this.estado = estado;
	}
	
	public abstract String getResultado();

	public abstract void setValoresEstadisticos(Estadistica estadistica);
}

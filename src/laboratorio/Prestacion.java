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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIndicacion() {
		return indicacion;
	}

	public void setIndicacion(String indicacion) {
		this.indicacion = indicacion;
	}

	public EstadoPrestacion getEstado() {
		return estado;
	}

	protected void validarStrings(String str) throws StringVacioException {

		if ("".equals(str) || str == null) {
			throw new StringVacioException();
		}
	}

	protected void setEstado(EstadoPrestacion estado) {
		this.estado = estado;
	}

	public String getResultado() {
		return ("Nombre del estudio: " + nombre + ". ");
	}

	public abstract void getValoresEstadisticos(Estadistica estadistica);
}

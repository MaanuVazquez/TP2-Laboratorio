package laboratorio;

import enums.EstadoPrestacion;
import excepciones.PrestacionRegistroException;

public abstract class Prestacion {
	
	private static Integer idMax = 1;
	private Integer id;
	private String nombre;
	private String indicacion;
	private EstadoPrestacion estado;
	
	public Prestacion(String nombre, String indicacion) throws PrestacionRegistroException {
		this.id = new Integer(idMax.intValue());
		idMax++;
		this.setNombre(nombre);
		this.setIndicacion(indicacion);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws PrestacionRegistroException {
		this.validarStrings(nombre);
		this.nombre = nombre;
	}

	public String getIndicacion() {
		return indicacion;
	}
	
	public EstadoPrestacion getEstado() {
		return estado;
	}

	public void setEstado(EstadoPrestacion estado) {
		this.estado = estado;
	}

	public void setIndicacion(String indicacion) throws PrestacionRegistroException {
		this.validarStrings(indicacion);
		this.indicacion = indicacion;
	}
	
	private void validarStrings(String str) throws PrestacionRegistroException {
		
		if("".equals(str) || str == null){
			throw new PrestacionRegistroException("Las cadenas de caracteres no pueden ser vacías");
		}
		
	}
	
	public abstract String getResultado();
}

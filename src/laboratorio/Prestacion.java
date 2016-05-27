package laboratorio;

import enums.EstadoPrestaciones;

public abstract class Prestacion {
	
	private static Integer idMax = 1;
	private Integer id;
	private String nombre;
	private String indicacion;
	private EstadoPrestaciones estado;
	
	public Prestacion(String nombre, String indicacion) {
		this.id = new Integer(idMax.intValue());
		idMax++;
		this.nombre = nombre;
		this.indicacion = indicacion;
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIndicacion() {
		return indicacion;
	}

	public void setIndicacion(String indicacion) {
		this.indicacion = indicacion;
	}
	
	public abstract String getResultado();
}

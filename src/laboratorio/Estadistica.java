package laboratorio;

import java.util.HashMap;

public class Estadistica {
	
	private String nombre;
	private int numeroDePacientes;
	
	public Estadistica(String nombre) {
		
		this.nombre = nombre;
	}
	
	public void add(Prestacion p) {
		p.getValoresEstadisticos(this);
	}
	
	public void setEstatAnalisis(Analisis analisis){
		
	}
	
	public void setEstatEstudio(Estudio estudio){
		
	}
	
}

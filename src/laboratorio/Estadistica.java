package laboratorio;

import estadisticas.EstadisticaEstudios;
import estadisticas.EstadisticaAnalisis;

public class Estadistica {
	
	protected EstadisticaAnalisis estadisticaAnalisis;
	protected EstadisticaEstudios estadisticaEstudios;
	
	public Estadistica(Prestacion p) {
		//POR LO QUE ENTIENDO LA ESTADISTICA ES DE LAS HOJAS, NO DE LOS GRUPOS DE ESTUDIOS
		p.setValoresEstadisticos(this);
	}


	public void addPrestacion(Prestacion p) {
		p.setValoresEstadisticos(this);
	}
	
	
	public String mostrarEstadistica(){
		//Terminar toString, para despues si anda bien la estadistica
		return this.estadisticaAnalisis.toString()+"/n"+this.estadisticaEstudios.toString();
		
	}
	
}

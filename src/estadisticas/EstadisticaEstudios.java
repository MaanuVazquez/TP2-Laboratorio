package estadisticas;

import enums.ClasificacionEstudio;
import laboratorio.Estudio;

public class EstadisticaEstudios extends EstadisticaGeneral{
	protected Integer cantidadResultadosNormales;
	protected Integer cantidadResultadosAnormales;
	
	public void setValoresEstadisticos(Estudio estudio) {
		this.nombre = estudio.getNombre();
		this.numeroDePacientes++;
		this.setCantidadPorClasificacion(estudio.getClasificacion());
		
	}

	private void setCantidadPorClasificacion(ClasificacionEstudio clasificacion) {
		
		if(clasificacion == ClasificacionEstudio.NORMAL){
			this.cantidadResultadosNormales++;
		}else{
			this.cantidadResultadosAnormales++;
		}
	}
}

package estadisticas;

import enums.ClasificacionEstudio;
import laboratorio.Estudio;
import laboratorio.Prestacion;

public class EstadisticaEstudios extends EstadisticaIndividual {

	private Integer cantidadResultadosNormales;
	private Integer cantidadResultadosAnormales;

	public EstadisticaEstudios(Prestacion prestacion) {
		super(prestacion);
		this.cantidadResultadosAnormales = 0;
		this.cantidadResultadosNormales = 0;
	}

	public void agregarPrestacion(Prestacion estudio) {
		this.numeroDePacientes++;
		this.setCantidadPorClasificacion(((Estudio) estudio).getClasificacion());
	}

	public String toString() {
		return (super.toString() + "Cantidad de Resultados Normales: " + cantidadResultadosNormales
				+ ", Cantidad de Resultados Anormales: " + cantidadResultadosAnormales + "]\n\n");
	}

	private void setCantidadPorClasificacion(ClasificacionEstudio clasificacion) {
		if (clasificacion == ClasificacionEstudio.NORMAL) {
			this.cantidadResultadosNormales++;
		} else {
			this.cantidadResultadosAnormales++;
		}
	}
}

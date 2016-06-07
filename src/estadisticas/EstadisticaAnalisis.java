package estadisticas;

import laboratorio.Analisis;
import laboratorio.Prestacion;

public class EstadisticaAnalisis extends EstadisticaIndividual {

	private Double valorMinimoMedido;
	private Double valorMaximoMedido;
	private Double sumaValoresMedidos;

	public EstadisticaAnalisis(Prestacion prestacion) {
		super(prestacion);
		Analisis analisis = (Analisis) prestacion;
		this.sumaValoresMedidos = analisis.getValorMedido();
		this.valorMinimoMedido = analisis.getValorMedido();
		this.valorMaximoMedido = analisis.getValorMedido();
	}

	public void agregarPrestacion(Prestacion prestacion) {
		Analisis analisis = (Analisis) prestacion;
		this.numeroDePacientes++;
		this.comprobarValorMaximoMedido(analisis.getValorMedido());
		this.comprobarValorMinimoMedido(analisis.getValorMedido());
		this.sumarValor(analisis.getValorMedido());
	}

	public String toString() {
		return (super.toString() + "Valor Maximo Medido: " + valorMaximoMedido + ", Valor Minimo Medido: "
				+ valorMinimoMedido + ", Promedio de Valores: " + this.getPromedioValores() + "]\n\n");
	}

	private void comprobarValorMinimoMedido(Double valorMedido) {
		if (this.valorMinimoMedido > valorMedido) {
			this.valorMinimoMedido = valorMedido;
		}
	}

	private void comprobarValorMaximoMedido(Double valorMedido) {
		if (this.valorMaximoMedido < valorMedido) {
			this.valorMaximoMedido = valorMedido;
		}
	}

	private void sumarValor(Double valorMedido) {
		this.sumaValoresMedidos += valorMedido;
	}

	private Double getPromedioValores() {
		return (this.sumaValoresMedidos / this.numeroDePacientes);
	}

}

package laboratorio;

import enums.ClasificacionEstudio;
import enums.EstadoPrestacion;
import excepciones.RangoDeValoresInvalido;
import excepciones.StringVacioException;
import excepciones.ValoresNegativosException;

public class Analisis extends Prestacion {

	private double valorNormalMinimo;
	private double valorNormalMaximo;
	private Double valorMedido;
	private ClasificacionEstudio clasificacion;

	public Analisis(String nombre, String indicacion, double valorNormalMinimo, double valorNormalMaximo)
			throws StringVacioException, ValoresNegativosException, RangoDeValoresInvalido {

		super(nombre, indicacion);
		this.validarValores(valorNormalMaximo);
		this.validarValores(valorNormalMinimo);
		this.valorNormalMaximo = valorNormalMaximo;
		this.valorNormalMinimo = valorNormalMinimo;
		this.validarRangoValores();
	}

	public void setResultado(double valorMedido) throws ValoresNegativosException {

		this.validarValores(valorMedido);
		this.valorMedido = valorMedido;

		if (this.valorMedido <= this.valorNormalMaximo && this.valorMedido >= this.valorNormalMinimo) {
			this.clasificacion = ClasificacionEstudio.NORMAL;
		} else {
			this.clasificacion = ClasificacionEstudio.ANORMAL;
		}
		this.setEstado(EstadoPrestacion.FINALIZADO);
	}

	@Override
	public String getResultado() {
		return (super.getResultado() + "Valor Medido: " + this.valorMedido + ". Clasificacion: "
				+ this.getClasificacion().toString() + ". Rango de Normalidad [" + this.getValorNormalMinimo() + " - "
				+ this.getValorNormalMaximo() + "].");
	}

	public double getValorNormalMinimo() {
		return valorNormalMinimo;
	}

	public double getValorNormalMaximo() {

		return this.valorNormalMaximo;
	}

	public Double getValorMedido() {
		return valorMedido;
	}

	public ClasificacionEstudio getClasificacion() {
		return clasificacion;
	}

	@Override
	public void getValoresEstadisticos(Estadistica estadistica) {
		if (this.getEstado().equals(EstadoPrestacion.FINALIZADO)) {
			estadistica.agregarAnalisis(this);
		}
	}

	private void validarValores(double valor) throws ValoresNegativosException {

		if (valor < 0) {
			throw new ValoresNegativosException(valor);
		}
	}

	private void validarRangoValores() throws RangoDeValoresInvalido {

		if (this.getValorNormalMaximo() <= this.getValorNormalMinimo()) {
			throw new RangoDeValoresInvalido(this.getValorNormalMinimo(), this.getValorNormalMaximo());
		}
	}

	@Override
	public String getResultForm() {
		return "Analisis";
	}
}

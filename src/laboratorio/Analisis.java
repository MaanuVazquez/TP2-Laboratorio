package laboratorio;

import enums.ClasificacionEstudio;
import estadisticas.EstadisticaAnalisis;
import excepciones.RangoDeValoresInvalido;
import excepciones.StringVacioException;
import excepciones.ValoresNegativosException;

public class Analisis extends Prestacion {

	private double valorNormalMinimo;
	private double valorNormalMaximo;
	private double valorMedido;
	private ClasificacionEstudio clasificacion;

	public Analisis(String nombre, String indicacion, double valorNormalMinimo,
			double valorNormalMaximo) throws StringVacioException,
			ValoresNegativosException, RangoDeValoresInvalido {

		super(nombre, indicacion);
		this.validarValores(valorNormalMaximo);
		this.validarValores(valorNormalMinimo);
		this.valorNormalMaximo = valorNormalMaximo;
		this.valorNormalMinimo = valorNormalMinimo;
		this.validarRangoValores();
	}

	// public void setValorMedido(double valorMedido)
	// throws AnalisisRegistroException {
	//
	// this.validarValores(valorMedido);
	// this.valorMedido = valorMedido;
	//
	// if (this.valorMedido <= this.valorNormalMaximo
	// && this.valorMedido >= this.valorNormalMinimo) {
	// this.clasificacion = ClasificacionEstudio.NORMAL;
	// } else {
	// this.clasificacion = ClasificacionEstudio.ANORMAL;
	// }
	//
	// }

	@Override
	public String getResultado() {

		// VALOR - CLASIFICACION RANGO [MAX-MIN]
		return (this.valorMedido + " - " + this.getClasificacion().toString()
				+ "[" + this.getValorNormalMinimo() + "-"
				+ this.getValorNormalMaximo() + "]");
	}

	public double getValorNormalMinimo() {
		return valorNormalMinimo;
	}

	public double getValorNormalMaximo() {

		return this.valorNormalMaximo;
	}

	public double getValorMedido() {
		return valorMedido;
	}

	public ClasificacionEstudio getClasificacion() {
		return clasificacion;
	}

	public String setResultado() {

		// NO OLVIDAR LLAMAR DEL PADRE EL QUE CAMBIA EL STATUS A FINALIZADO
		return null;
		// ACA DEBERIA MOSTRARSE EL FORMULARIO DE CARGA DE RESULTADOS QUE Y
		// APARTIR DE LOS QUE CARGA
		// SE LLAMA AL METODO CARGAR RESULTADO CON LOS PARAMETROS ESPECIFICOS DE
		// LOS ANALISIS
	}

	public void cargarResultado(double valorMedido) {

	}

	@Override
	public void setValoresEstadisticos(Estadistica estadistica) {

		if (estadistica.estadisticaAnalisis == null) {
			estadistica.estadisticaAnalisis = new EstadisticaAnalisis();
		}

		// Aca esta la clave de la estadistica sin hacer instanceof
		estadistica.estadisticaAnalisis.setValoresEstadisticos(this);

	}

	private void validarValores(double valor) throws ValoresNegativosException {

		if (valor < 0) {
			throw new ValoresNegativosException(valor);
		}
	}

	private void validarRangoValores() throws RangoDeValoresInvalido {

		if (this.getValorNormalMaximo() <= this.getValorNormalMinimo()) {
			throw new RangoDeValoresInvalido(this.getValorNormalMinimo(),
					this.getValorNormalMaximo());
		}
	}
}

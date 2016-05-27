package laboratorio;

public class Analisis extends Prestacion {

	private double valorNormalMinimo;
	private double valorNormalMaximo;
	private double valorMedido;
	private boolean resultadoConcluido;
	
	public Analisis(String nombre, String indicacion, double valorNormalMinimo,
			double valorNormalMaximo, double valorMedido) {
		super(nombre, indicacion);
		this.setValorNormalMaximo(valorNormalMaximo);
		this.setValorNormalMinimo(valorNormalMinimo);
	}

	@Override
	public String getResultado() {
		if(!this.resultadoConcluido){
			return "";
		}
		String resultado = "Anormal";
		if(valorMedido <= valorNormalMaximo && valorMedido >= valorNormalMinimo){
			resultado = "Normal";
		}
		return (valorMedido + " " + resultado);
	}

	public double getValorNormalMinimo() {
		return valorNormalMinimo;
	}

	public void setValorNormalMinimo(double valorNormalMinimo) {
		this.valorNormalMinimo = valorNormalMinimo;
	}

	public double getValorNormalMaximo() {
		return valorNormalMaximo;
	}

	public void setValorNormalMaximo(double valorNormalMaximo) {
		this.valorNormalMaximo = valorNormalMaximo;
	}


	public double getValorMedido() {
		return valorMedido;
	}

	public void setValorMedido(double valorMedido) {
		this.valorMedido = valorMedido;
	}

	@Override
	public String setResultado() {
		return null;
		//ACA DEBERIA MOSTRARSE EL FORMULARIO DE CARGA DE RESULTADOS QUE Y APARTIR DE LOS QUE CARGA
		//SE LLAMA AL METODO CARGAR RESULTADO CON LOS PARAMETROS ESPECIFICOS DE LOS ANALISIS
	}
	
	public void cargarResultado(double valorMedido){
		
	}
	


}

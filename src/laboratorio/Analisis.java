package laboratorio;

import enums.ClasificacionEstudio;
import enums.EstadoPrestacion;
import excepciones.AnalisisRegistroException;
import excepciones.PrestacionRegistroException;

public class Analisis extends Prestacion {

	private double valorNormalMinimo;
	private double valorNormalMaximo;
	private double valorMedido;
	private ClasificacionEstudio clasificacion;
	
	public Analisis(String nombre, String indicacion, double valorNormalMinimo,
		double valorNormalMaximo) throws AnalisisRegistroException, PrestacionRegistroException {
		
		super(nombre, indicacion);
		this.setValorNormalMaximo(valorNormalMaximo);
		this.setValorNormalMinimo(valorNormalMinimo);
		
		this.validarRangoValores();
	}

	@Override
	public String getResultado() {
		
		//VALOR - CLASIFICACION  RANGO [MAX-MIN]
		return (
				this.valorMedido + " - " + this.getClasificacion().toString() + 
				"["+this.getValorNormalMinimo()+"-"+this.getValorNormalMaximo()+"]"
				);
	}

	public double getValorNormalMinimo() {
		return valorNormalMinimo;
	}

	public void setValorNormalMinimo(double valorNormalMinimo) throws AnalisisRegistroException {
		
		this.validarValores(valorNormalMinimo);
		
		this.valorNormalMinimo = valorNormalMinimo;
		
		this.validarRangoValores();
		
	}

	public double getValorNormalMaximo(){

		return this.valorNormalMaximo;
	}

	public void setValorNormalMaximo(double valorNormalMaximo) throws AnalisisRegistroException {
		this.validarValores(valorNormalMinimo);
		
		this.valorNormalMaximo = valorNormalMaximo;
		
		this.validarRangoValores();
		
	}


	public double getValorMedido() {
		return valorMedido;
	}

	public void setValorMedido(double valorMedido) throws AnalisisRegistroException {
		
		this.validarValores(valorNormalMinimo);
		this.valorMedido = valorMedido;
		
		if(this.valorMedido <= this.valorNormalMaximo && this.valorMedido >= this.valorNormalMinimo){
			this.setClasificacion(ClasificacionEstudio.NORMAL);
		}else{
			this.setClasificacion(ClasificacionEstudio.ANORMAL);
		}
		
	}
	
	public ClasificacionEstudio getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(ClasificacionEstudio clasificacion) {
		this.clasificacion = clasificacion;
	}

	private void validarValores(double valor) throws AnalisisRegistroException {
		
		if(valor < 0){
			throw new AnalisisRegistroException("Los valores ingresados deben ser positivos");
		}	
	}
	
	private void validarRangoValores() throws AnalisisRegistroException {
		
		if(this.getValorNormalMaximo() <= this.getValorNormalMinimo()){
			throw new AnalisisRegistroException("El rango de valor mínimo debe ser menor al valor máximo del rango ingresado");
		}
		
	}

	public String setResultado() {
		
		//NO OLVIDAR LLAMAR DEL PADRE EL QUE CAMBIA EL STATUS A FINALIZADO
		return null;
		//ACA DEBERIA MOSTRARSE EL FORMULARIO DE CARGA DE RESULTADOS QUE Y APARTIR DE LOS QUE CARGA
		//SE LLAMA AL METODO CARGAR RESULTADO CON LOS PARAMETROS ESPECIFICOS DE LOS ANALISIS
	}
	
	public void cargarResultado(double valorMedido){
		
	}
	


}

package estadisticas;

import laboratorio.Analisis;

public class EstadisticaAnalisis extends EstadisticaGeneral{
	
	protected Double valorMinimoMedido;
	protected Double valorMaximoMedido;
	protected Double sumaValoresMedidos;
	
	public void setValoresEstadisticos(Analisis analisis) {
		this.nombre = analisis.getNombre();
		this.numeroDePacientes++;
		this.setSumaValoresMedidos(analisis.getValorMedido());
		this.setValorMaximoMedido(analisis.getValorMedido());
		this.setValorMinimoMedido(analisis.getValorMedido());
		
	}

	public Double getValorMinimoMedido() {
		return valorMinimoMedido;
	}

	public void setValorMinimoMedido(Double valorMedido) {
		
		if(this.valorMinimoMedido > valorMedido){
			this.valorMinimoMedido = valorMedido;			
		}
	
	}

	public Double getValorMaximoMedido() {
		return valorMaximoMedido;
	}

	public void setValorMaximoMedido(Double valorMedido) {
		if(this.valorMaximoMedido < valorMedido){
			this.valorMaximoMedido = valorMedido;			
		}

	}

	public Double getSumaValoresMedidos() {
		return sumaValoresMedidos;
	}

	public void setSumaValoresMedidos(Double valorMedido) {
		this.sumaValoresMedidos += valorMedido;
	}
	
	public Double getPromedioValores(){
		return (this.sumaValoresMedidos/this.numeroDePacientes);
	}
	
}

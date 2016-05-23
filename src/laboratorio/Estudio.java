package laboratorio;

public class Estudio extends Prestacion {

	private boolean resultado;
	
	public Estudio(String nombre, String indicacion, boolean resultado) {
		super(nombre, indicacion);
		this.setResultado(resultado);
	}

	@Override
	public String getResultado() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	public boolean isResultado() {
		return resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}
	
	

}

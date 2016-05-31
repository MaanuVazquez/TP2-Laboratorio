package excepciones;

public class ValoresNegativosException extends Exception {

	public ValoresNegativosException(double valor) {
		super("El valor ingresado: " + valor + " debe ser positivo.");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8704677898717979832L;

}

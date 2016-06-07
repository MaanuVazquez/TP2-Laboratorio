package excepciones;

public class RangoDeValoresInvalido extends Exception {

	public RangoDeValoresInvalido(double valorNormalMinimo,
			double valorNormalMaximo) {
		super("El valor minimo: " + valorNormalMinimo + " es mayor o igual al valor maximo: " + valorNormalMaximo + ".");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8033763824480888431L;

}

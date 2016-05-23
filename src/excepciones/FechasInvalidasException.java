package excepciones;

import java.util.Date;

public class FechasInvalidasException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7378306910100197716L;

	public FechasInvalidasException(Date inicio, Date fin) {
		super("La fecha de Inicio : " + inicio
				+ " es posterior a la fecha de finalizacion: " + fin + ".");
	}

}

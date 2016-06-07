package excepciones;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FechasInvalidasException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7378306910100197716L;

	public FechasInvalidasException(Date inicio, Date fin) {

		super("La fecha de Inicio : " + new SimpleDateFormat("yyyy-MM-dd").format(inicio)
				+ " es posterior a la fecha de finalizacion: " + new SimpleDateFormat("yyyy-MM-dd").format(fin) + ".");
	}

}

package test;



//favor de borrar los "//" es por el warning 
//import laboratorio.*;

import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.junit.Test;

//favor de borrar los "//" es por el warning
//import excepciones.FechasInvalidasException;

public class TestLaboratorioException {

	/*
	 * Recuerden que no testeo nada eso lo tienen que realizar ustedes desde ya
	 * tomo como si esto ya lo leyeron.
	 */

	@Rule
	public final ExpectedException excepcionEsperada = ExpectedException.none();

	/*
	 * Prueba error Fechas Invalidas.
	 */

	@Test
	public void testFechasInvalidas() {
		// excepcionEsperada.expect(FechasInvalidasException.class);
	}

	/*
	 * Prueba error prestacion ya existente
	 */

	@Test
	public void testPrestacionExistente() {
		// excepcionEsperada.expect(PrestacionExistenteException.class);
	}


	/*
	 * 
	 */
	
	/*
	 * 
	 */
}

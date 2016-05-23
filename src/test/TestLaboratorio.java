package test;

import laboratorio.Analisis;
import laboratorio.Estudio;
import laboratorio.GrupoDeEstudios;
import laboratorio.*;

import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.junit.Test;

import excepciones.*;

public class TestLaboratorio {

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
	 * Prueba constructor de analisis
	 */

	@Test
	public void testConstructorDeAnalisis() {

		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0, (10.0 + 50.0) / 2);

	}

	/*
	 * prueba obtener un resultado de un analisis
	 */

	@Test
	public void testGetResultadoAnalisis() {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0, (10.0 + 50.0) / 2);

		analisisDePrueba.getResultado();

	}

	/*
	 * Prueba obtener el valor minimo del analisis.
	 */

	@Test
	public void testGetValorMinimo() {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0, (10.0 + 50.0) / 2);

		analisisDePrueba.getValorNormalMinimo();
	}

	/*
	 * Prueba obtener el valor maximo del analisis.
	 */

	@Test
	public void testGetValorMaximo() {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0, (10.0 + 50.0) / 2);

		analisisDePrueba.getValorNormalMaximo();
	}

	/*
	 * Prueba obtener el valor medido del analisis.
	 */

	@Test
	public void testGetValorMedido() {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0, (10.0 + 50.0) / 2);

		analisisDePrueba.getValorMedido();
	}

	/*
	 * Prueba setear el valor minimo del analisis.
	 */

	@Test
	public void testSetValorMinimo() {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0, (10.0 + 50.0) / 2);

		analisisDePrueba.setValorNormalMinimo(10);
	}

	/*
	 * Prueba setear el valor maximo del analisis.
	 */

	@Test
	public void testSetValorMaximo() {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0, (10.0 + 50.0) / 2);

		analisisDePrueba.setValorNormalMaximo(50);
	}

	/*
	 * Prueba setear el valor medido del analisis.
	 */

	@Test
	public void testSetValorMedido() {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0, (10.0 + 50.0) / 2);

		analisisDePrueba.setValorMedido(30);
	}

	/*
	 * Prueba constructor de estudio
	 */

	@Test
	public void testConstructorDeEstudio() {

		Estudio estudioDePrueba = new Estudio("nombre", "indicacion", true);

	}

	/*
	 * Prueba obtener resultado de un estudio
	 */

	@Test
	public void testGetResultadoDeEstudio() {
		Estudio estudioDePrueba = new Estudio("nombre", "indicacion", true);

		estudioDePrueba.getResultado();
	}

	/*
	 * Prueba metodo isResultado de la clase Estudio. (arreglar comentario (nose
	 * que hace))
	 */

	@Test
	public void testIsResultado() {

		Estudio estudioDePrueba = new Estudio("nombre", "indicacion", true);

		estudioDePrueba.isResultado();
	}

	/*
	 * Prueba setear resultado.
	 */

	@Test
	public void testSetResultado() {
		Estudio estudioDePrueba = new Estudio("nombre", "indicacion", true);

		estudioDePrueba.setResultado(false);
	}

	/*
	 * Prueba constructor de GrupoDeEstudio.
	 */

	@Test
	public void testConstructorGrupoDeEstudios() {

		GrupoDeEstudios grupoDeEstudiosDePrueba = new GrupoDeEstudios("nombre",
				"indicacion");
	}
	
	/*
	 * 
	 */
}

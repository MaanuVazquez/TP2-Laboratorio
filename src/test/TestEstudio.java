package test;

import laboratorio.Estudio;

import org.junit.Test;

public class TestEstudio {


	/*
	 * Prueba constructor de estudio
	 */

	@Test
	public void testConstructorDeEstudio() {

		Estudio estudioDePrueba = new Estudio("nombre", "indicacion", true);

		// favor de borrar es por el warning
		estudioDePrueba.getId();
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

}

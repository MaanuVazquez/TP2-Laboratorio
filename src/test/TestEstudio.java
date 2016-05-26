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
	 * Prueba get y set resultado de un estudio
	 */

	@Test
	public void testGetandSetResultadoDeEstudio() {
		Estudio estudioDePrueba = new Estudio("nombre", "indicacion", true);

		estudioDePrueba.setResultado(false);
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

}

package test;

import laboratorio.Analisis;

import org.junit.Test;

public class TestAnalisis {


	/*
	 * Prueba constructor de analisis
	 */

	@Test
	public void testConstructorDeAnalisis() {

		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0, (10.0 + 50.0) / 2);

		// favor de borrar es por el warning
		analisisDePrueba.getNombre();
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
}

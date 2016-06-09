package test;

import laboratorio.Analisis;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import enums.ClasificacionEstudio;
import enums.EstadoPrestacion;
import excepciones.RangoDeValoresInvalido;
import excepciones.StringVacioException;
import excepciones.ValoresNegativosException;

public class TestAnalisis {

	/*
	 * Se crea una regla para testear los throws
	 */
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	/*
	 * Prueba del constructor de analisis
	 */
	@Test
	public void testConstructorDeAnalisis() throws StringVacioException,
			ValoresNegativosException, RangoDeValoresInvalido {

		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		Assert.assertEquals("nombre", analisisDePrueba.getNombre());
	}

	/*
	 * Prueba devolver el estado de un analisis
	 */

	@Test
	public void testEstadoDeAnalisisAlCrearlo() throws StringVacioException,
			ValoresNegativosException, RangoDeValoresInvalido {

		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		Assert.assertEquals(EstadoPrestacion.PENDIENTE,
				analisisDePrueba.getEstado());
	}

	/*
	 * Prueba esperar ValoresNegativosException
	 */
	
	@Test
	public void testConstructorDeAnalisisConErrorDeAnalisis()
			throws StringVacioException, ValoresNegativosException,
			RangoDeValoresInvalido {
		exception.expect(ValoresNegativosException.class);
		new Analisis("Glucemia", "Indicaciones", -200.0, 100.0);
	}

	/*
	 * Prueba esperar StringVacioException
	 */
	
	@Test
	public void testConstructorDeAnalisisConErrorDePrestacion()
			throws StringVacioException, ValoresNegativosException,
			RangoDeValoresInvalido {

		exception.expect(StringVacioException.class);
		new Analisis("Glucemia", "", 10.0, 100.0);
	}

	/*
	 * Prueba esperar RangoDeValoresInvalido
	 */
	
	@Test
	public void testAnalisisConValorMinimoMedidoMayorOIgualAlMayor()
			throws StringVacioException, ValoresNegativosException,
			RangoDeValoresInvalido {

		exception.expect(RangoDeValoresInvalido.class);
		new Analisis("Glucemia", "Indicacion", 10.0, 5);
	}

	/*
	 * Prueba obtener un resultado de un analisis
	 */

	@Test
	public void testAnalisisConResultadoCargado() throws StringVacioException,
			ValoresNegativosException, RangoDeValoresInvalido {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		analisisDePrueba.setResultado(20);

		Assert.assertEquals(20, analisisDePrueba.getValorMedido(), 0);

	}

	/*
	 * Prueba obtener un valor medido de un analisis
	 */
	
	@Test
	public void testAnalisisSinResultadoCargado() throws StringVacioException,
			ValoresNegativosException, RangoDeValoresInvalido {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		Assert.assertEquals(null, analisisDePrueba.getValorMedido());
	}

	/*
	 * Prueba obtener el valor minimo del analisis.
	 */

	@Test
	public void testGetValorMinimo() throws StringVacioException,
			ValoresNegativosException, RangoDeValoresInvalido {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		Assert.assertEquals(10, analisisDePrueba.getValorNormalMinimo(), 0);
	}

	/*
	 * Prueba obtener el valor maximo del analisis.
	 */

	@Test
	public void testAnalisisGetValorMaximo() throws StringVacioException,
			ValoresNegativosException, RangoDeValoresInvalido {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		Assert.assertEquals(50, analisisDePrueba.getValorNormalMaximo(), 0);
	}

	/*
	 * Prueba obtener un valot normal de un analisis
	 */
	
	@Test
	public void testClasificacionEstudioNormalDeAnalisis()
			throws StringVacioException, ValoresNegativosException,
			RangoDeValoresInvalido {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		analisisDePrueba.setResultado(49);

		Assert.assertEquals(ClasificacionEstudio.NORMAL,
				analisisDePrueba.getClasificacion());

	}

	/*
	 * Prueba obtener un valot anormal de un analisis
	 */
	
	@Test
	public void testClasificacionEstudioAnormalDeAnalisis()
			throws StringVacioException, ValoresNegativosException,
			RangoDeValoresInvalido {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		analisisDePrueba.setResultado(51);

		Assert.assertEquals(ClasificacionEstudio.ANORMAL,
				analisisDePrueba.getClasificacion());

	}

	/*
	 * Prueba obtener un resultado
	 */
	
	@Test
	public void testgetResultado() throws StringVacioException,
			ValoresNegativosException, RangoDeValoresInvalido {
		Analisis analisisDePrueba = new Analisis("Sangre", "indicacion", 10.0,
				50.0);

		analisisDePrueba.setResultado(14);
		String resultado = "Nombre del estudio: Sangre. Valor Medido: 14.0. Clasificacion: NORMAL. Rango de Normalidad [10.0 - 50.0].";
		Assert.assertTrue(analisisDePrueba.getResultado().contains(resultado));
	}
}

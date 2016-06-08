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

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void ConstructorDeAnalisis() throws StringVacioException,
			ValoresNegativosException, RangoDeValoresInvalido {

		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		Assert.assertEquals("nombre", analisisDePrueba.getNombre());
	}

	@Test
	public void EstadoDeAnalisisAlCrearlo() throws StringVacioException,
			ValoresNegativosException, RangoDeValoresInvalido {

		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		Assert.assertEquals(EstadoPrestacion.PENDIENTE,
				analisisDePrueba.getEstado());
	}

	@Test
	public void ConstructorDeAnalisisConErrorDeAnalisis()
			throws StringVacioException, ValoresNegativosException,
			RangoDeValoresInvalido {
		exception.expect(ValoresNegativosException.class);
		new Analisis("Glucemia", "Indicaciones", -200.0, 100.0);
	}

	@Test
	public void ConstructorDeAnalisisConErrorDePrestacion()
			throws StringVacioException, ValoresNegativosException,
			RangoDeValoresInvalido {

		exception.expect(StringVacioException.class);
		new Analisis("Glucemia", "", 10.0, 100.0);
	}

	@Test
	public void AnalisisConValorMinimoMedidoMayorOIgualAlMayor()
			throws StringVacioException, ValoresNegativosException,
			RangoDeValoresInvalido {

		exception.expect(RangoDeValoresInvalido.class);
		new Analisis("Glucemia", "Indicacion", 10.0, 5);
	}

	/*
	 * prueba obtener un resultado de un analisis
	 */

	@Test
	public void AnalisisConResultadoCargado() throws StringVacioException,
			ValoresNegativosException, RangoDeValoresInvalido {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		analisisDePrueba.setResultado(20);

		Assert.assertEquals(20, analisisDePrueba.getValorMedido(), 0);

	}

	@Test
	public void AnalisisSinResultadoCargado() throws StringVacioException,
			ValoresNegativosException, RangoDeValoresInvalido {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		Assert.assertEquals(null, analisisDePrueba.getValorMedido());
	}

	/*
	 * Prueba obtener el valor minimo del analisis.
	 */

	@Test
	public void GetValorMinimo() throws StringVacioException,
			ValoresNegativosException, RangoDeValoresInvalido {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		Assert.assertEquals(10, analisisDePrueba.getValorNormalMinimo(), 0);
	}

	/*
	 * Prueba obtener el valor maximo del analisis.
	 */

	@Test
	public void AnalisisGetValorMaximo() throws StringVacioException,
			ValoresNegativosException, RangoDeValoresInvalido {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		Assert.assertEquals(50, analisisDePrueba.getValorNormalMaximo(), 0);
	}

	@Test
	public void ClasificacionEstudioNormalDeAnalisis()
			throws StringVacioException, ValoresNegativosException,
			RangoDeValoresInvalido {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		analisisDePrueba.setResultado(49);

		Assert.assertEquals(ClasificacionEstudio.NORMAL,
				analisisDePrueba.getClasificacion());

	}

	@Test
	public void ClasificacionEstudioAnormalDeAnalisis()
			throws StringVacioException, ValoresNegativosException,
			RangoDeValoresInvalido {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		analisisDePrueba.setResultado(51);

		Assert.assertEquals(ClasificacionEstudio.ANORMAL,
				analisisDePrueba.getClasificacion());

	}

	@Test
	public void getResultado() throws StringVacioException,
			ValoresNegativosException, RangoDeValoresInvalido {
		Analisis analisisDePrueba = new Analisis("Sangre", "indicacion", 10.0,
				50.0);

		analisisDePrueba.setResultado(14);
		String resultado = "Nombre del estudio: Sangre. Valor Medido: 14.0. Clasificacion: NORMAL. Rango de Normalidad [10.0 - 50.0].";
		Assert.assertTrue(analisisDePrueba.getResultado().contains(resultado));
	}
}

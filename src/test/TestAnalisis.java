package test;

import laboratorio.Analisis;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import enums.ClasificacionEstudio;
import enums.EstadoPrestacion;
import excepciones.AnalisisRegistroException;
import excepciones.PrestacionRegistroException;

public class TestAnalisis {
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testConstructorDeAnalisis() throws AnalisisRegistroException, PrestacionRegistroException {

		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0, 50.0);

		Assert.assertEquals("nombre", analisisDePrueba.getNombre());
	}
	
	@Test
	public void testEstadoDeAnalisisAlCrearlo() throws AnalisisRegistroException, PrestacionRegistroException {

		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0, 50.0);

		Assert.assertEquals(EstadoPrestacion.PENDIENTE, analisisDePrueba.getEstado());
	}
	
	
	@SuppressWarnings("unused")
	@Test
	public void testConstructorDeAnalisisConErrorDeAnalisis() throws AnalisisRegistroException, PrestacionRegistroException{
		exception.expect(AnalisisRegistroException.class);
		Analisis analisisDePrueba = new Analisis("Glucemia", "Indicaciones", -200.0, 100.0);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testConstructorDeAnalisisConErrorDePrestacion() throws AnalisisRegistroException, PrestacionRegistroException {
		
		exception.expect(PrestacionRegistroException.class);
		Analisis analisisDePrueba = new Analisis("Glucemia", "", 10.0, 100.0);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testAnalisisConValorMinimoMedidoMayorOIgualAlMayor() throws AnalisisRegistroException, PrestacionRegistroException {
		
		exception.expect(AnalisisRegistroException.class);
		Analisis analisisDePrueba = new Analisis("Glucemia", "Indicacion", 10.0, 5);
	}

	/*
	 * prueba obtener un resultado de un analisis
	 */

	@Test
	public void testAnalisisConResultadoCargado() throws AnalisisRegistroException, PrestacionRegistroException {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,50.0);

		analisisDePrueba.setValorMedido(20);
		
		Assert.assertEquals(20, analisisDePrueba.getValorMedido() , 0);

	}

	/*
	 * Prueba obtener el valor minimo del analisis.
	 */

	@Test
	public void testGetValorMinimo() throws AnalisisRegistroException, PrestacionRegistroException {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		Assert.assertEquals(10, analisisDePrueba.getValorNormalMinimo() , 0);
	}

	/*
	 * Prueba obtener el valor maximo del analisis.
	 */

	@Test
	public void testAnalisisGetValorMaximo() throws AnalisisRegistroException, PrestacionRegistroException {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		Assert.assertEquals(10, analisisDePrueba.getValorNormalMinimo() , 0);
	}


	/*
	 * Prueba setear el valor minimo del analisis.
	 */

	@Test
	public void testAnalisisSetValorMinimo() throws AnalisisRegistroException, PrestacionRegistroException {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		analisisDePrueba.setValorNormalMinimo(30);
		Assert.assertEquals(30, analisisDePrueba.getValorNormalMinimo() , 0);
	}

	/*
	 * Prueba setear el valor maximo del analisis.
	 */

	@Test
	public void testSetValorMaximo() throws AnalisisRegistroException, PrestacionRegistroException {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,
				50.0);

		analisisDePrueba.setValorNormalMaximo(100);
		Assert.assertEquals(100, analisisDePrueba.getValorNormalMaximo() , 0);
	}
	
	@Test
	public void testSetValorMaximoConRangoErroneoEnSeteo() throws AnalisisRegistroException, PrestacionRegistroException {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0, 50.0);
		exception.expect(AnalisisRegistroException.class);
		analisisDePrueba.setValorNormalMaximo(1);
	}
	
	@Test
	public void testSetValorMinimoConRangoErroneoEnSeteo() throws AnalisisRegistroException, PrestacionRegistroException {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0, 50.0);
		exception.expect(AnalisisRegistroException.class);
		analisisDePrueba.setValorNormalMinimo(100);
	}


	@Test
	public void testClasificacionEstudioNormalDeAnalisis() throws AnalisisRegistroException, PrestacionRegistroException {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,50.0);
		
		analisisDePrueba.setValorMedido(49);
		
		Assert.assertEquals(ClasificacionEstudio.NORMAL, analisisDePrueba.getClasificacion());

	}
	
	@Test
	public void testClasificacionEstudioAnormalDeAnalisis() throws AnalisisRegistroException, PrestacionRegistroException {
		Analisis analisisDePrueba = new Analisis("nombre", "indicacion", 10.0,50.0);
		
		analisisDePrueba.setValorMedido(51);
		
		Assert.assertEquals(ClasificacionEstudio.ANORMAL, analisisDePrueba.getClasificacion());

	}
}

package test;

import org.junit.Assert;
import org.junit.Test;

import estadisticas.EstadisticaAnalisis;
import excepciones.RangoDeValoresInvalido;
import excepciones.StringVacioException;
import excepciones.ValoresNegativosException;
import laboratorio.Analisis;

public class TestEstadisticaAnalisis {

	@Test
	public void testConstructorEstadisticaAnalisis() throws StringVacioException, ValoresNegativosException, RangoDeValoresInvalido{
		
		Analisis analisis = new Analisis("Analisis 1", "Indicacion", 0, 100);
		analisis.setResultado(50);
		EstadisticaAnalisis est = new EstadisticaAnalisis(analisis);
		
		Assert.assertTrue(est.getSumaValoresMedidos() == 50);
		
	}
	
	@Test
	public void testValorMaximoEstadisticaAnalisis() throws StringVacioException, ValoresNegativosException, RangoDeValoresInvalido{
		
		Analisis analisis = new Analisis("Analisis 1", "Indicacion", 0, 100);
		Analisis analisis2 = new Analisis("Analisis 2", "Indicacion", 1, 1000);
		Analisis analisis3 = new Analisis("Analisis 3", "Indicacion", 10, 300);
		analisis.setResultado(50);
		analisis2.setResultado(500);
		analisis3.setResultado(200);
		EstadisticaAnalisis est = new EstadisticaAnalisis(analisis);
		est.agregarPrestacion(analisis2);
		est.agregarPrestacion(analisis3);
		
		Assert.assertEquals(500, est.getValorMaximoMedido() , 0);
		
	}
	@Test
	public void testvalorMinimoEstadisticaAnalisis() throws StringVacioException, ValoresNegativosException, RangoDeValoresInvalido{
		
		Analisis analisis = new Analisis("Analisis 1", "Indicacion", 0, 100);
		Analisis analisis2 = new Analisis("Analisis 2", "Indicacion", 1, 1000);
		Analisis analisis3 = new Analisis("Analisis 3", "Indicacion", 10, 300);
		analisis.setResultado(50);
		analisis2.setResultado(500);
		analisis3.setResultado(200);
		EstadisticaAnalisis est = new EstadisticaAnalisis(analisis);
		est.agregarPrestacion(analisis2);
		est.agregarPrestacion(analisis3);
		
		Assert.assertEquals(50, est.getValorMinimoMedido() , 0);
		
	}
	@Test
	public void testValorPromedioEstadisticaAnalisis() throws StringVacioException, ValoresNegativosException, RangoDeValoresInvalido{
		
		Analisis analisis = new Analisis("Analisis 1", "Indicacion", 0, 100);
		Analisis analisis2 = new Analisis("Analisis 2", "Indicacion", 1, 1000);
		Analisis analisis3 = new Analisis("Analisis 3", "Indicacion", 10, 300);
		analisis.setResultado(50);
		analisis2.setResultado(500);
		analisis3.setResultado(200);
		EstadisticaAnalisis est = new EstadisticaAnalisis(analisis);
		est.agregarPrestacion(analisis2);
		est.agregarPrestacion(analisis3);
		
		Assert.assertEquals(250, est.getPromedioValores() , 0);
		
	}
	
	@Test
	public void testCantidadPacientesEstadisticaAnalisis() throws StringVacioException, ValoresNegativosException, RangoDeValoresInvalido{
		
		Analisis analisis = new Analisis("Analisis 1", "Indicacion", 0, 100);
		Analisis analisis2 = new Analisis("Analisis 2", "Indicacion", 1, 1000);
		Analisis analisis3 = new Analisis("Analisis 3", "Indicacion", 10, 300);
		analisis.setResultado(50);
		analisis2.setResultado(500);
		analisis3.setResultado(200);
		EstadisticaAnalisis est = new EstadisticaAnalisis(analisis);
		est.agregarPrestacion(analisis2);
		est.agregarPrestacion(analisis3);
		
		
		Assert.assertEquals(3, est.getNumeroDePacientes() , 0);
		
	}

}

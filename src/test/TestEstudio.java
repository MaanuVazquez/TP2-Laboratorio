package test;

import laboratorio.Estudio;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import enums.ClasificacionEstudio;
import enums.EstadoPrestacion;
import excepciones.StringVacioException;

public class TestEstudio {

	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	/*
	 * Prueba constructor de estudio
	 */
	@Test
	public void ConstructorDeEstudio() throws StringVacioException  {

		Estudio estudioDePrueba = new Estudio("nombre", "indicacion");
		Assert.assertEquals("nombre", estudioDePrueba.getNombre());
		
	}
	
	@Test
	public void ConstructorDeEstudioConExcepcion() throws StringVacioException {
		
		exception.expect(StringVacioException.class);
		new Estudio("", "");
		
	}

	/*
	 * Prueba get resultado de un estudio
	 */

	@Test
	public void EstudioConIndicacion() throws StringVacioException {
		Estudio estudioDePrueba = new Estudio("nombre", "indicacion");
		Assert.assertEquals("indicacion", estudioDePrueba.getIndicacion());
	}
	
	@Test
	public void EstudioConSeteoResultado() throws StringVacioException {
		Estudio estudioDePrueba = new Estudio("nombre", "indicacion");
		
		estudioDePrueba.setResultado(ClasificacionEstudio.NORMAL, "OK");
		
		Assert.assertEquals(EstadoPrestacion.FINALIZADO,estudioDePrueba.getEstado());
	}
	
	@Test
	public void testEstudioConSeteoResultadoErroneo() throws StringVacioException {
		Estudio estudioDePrueba = new Estudio("nombre", "indicacion");
		
		exception.expect(StringVacioException.class);
		estudioDePrueba.setResultado(null, "");
	}

	/*
	 * Prueba metodo isResultado de la clase Estudio.
	 */

}

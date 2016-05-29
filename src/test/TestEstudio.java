package test;

import laboratorio.Estudio;
import laboratorio.Paciente;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import enums.ClasificacionEstudio;
import enums.EstadoPrestacion;
import excepciones.PrestacionRegistroException;

public class TestEstudio {

	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	/*
	 * Prueba constructor de estudio
	 */
	@Test
	public void testConstructorDeEstudio() throws PrestacionRegistroException {

		Estudio estudioDePrueba = new Estudio("nombre", "indicacion");
		Assert.assertTrue(estudioDePrueba instanceof Estudio);
		
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testConstructorDeEstudioConExcepcion() throws PrestacionRegistroException {
		
		exception.expect(PrestacionRegistroException.class);
		Estudio estudioDePrueba = new Estudio("", "");
		
	}

	/*
	 * Prueba get y set resultado de un estudio
	 */

	@Test
	public void testEstudioConIndicacion() throws PrestacionRegistroException {
		Estudio estudioDePrueba = new Estudio("nombre", "indicacion");
		Assert.assertEquals("indicacion", estudioDePrueba.getIndicacion());
	}
	
	@Test
	public void testEstudioConNombreModificado() throws PrestacionRegistroException {
		Estudio estudioDePrueba = new Estudio("nombre", "indicacion");
		
		estudioDePrueba.setNombre("Otro nombre");
		Assert.assertEquals("Otro nombre", estudioDePrueba.getNombre());
	}
	
	@Test
	public void testEstudioConNombreModificadoPeroErroneo() throws PrestacionRegistroException {
		Estudio estudioDePrueba = new Estudio("nombre", "indicacion");
		
		exception.expect(PrestacionRegistroException.class);
		estudioDePrueba.setNombre("");
	}
	
	@Test
	public void testEstudioConIndicacionModificada() throws PrestacionRegistroException {
		Estudio estudioDePrueba = new Estudio("nombre", "indicacion");
		
		estudioDePrueba.setIndicacion("Otra Indicacion");
		Assert.assertEquals("Otra Indicacion", estudioDePrueba.getIndicacion());
	}
	
	@Test
	public void testEstudioConIndicacionModificadaPeroErronea() throws PrestacionRegistroException {
		Estudio estudioDePrueba = new Estudio("nombre", "indicacion");
		
		exception.expect(PrestacionRegistroException.class);
		estudioDePrueba.setIndicacion("");
	}
	
	
	@Test
	public void testEstudioConSeteoResultado() throws PrestacionRegistroException {
		Estudio estudioDePrueba = new Estudio("nombre", "indicacion");
		
		estudioDePrueba.setResultado(ClasificacionEstudio.NORMAL, "OK");
		
		Assert.assertEquals(EstadoPrestacion.FINALIZADO,estudioDePrueba.getEstado());
	}
	
	@Test
	public void testEstudioConSeteoResultadoErroneo() throws PrestacionRegistroException {
		Estudio estudioDePrueba = new Estudio("nombre", "indicacion");
		
		exception.expect(PrestacionRegistroException.class);
		estudioDePrueba.setResultado(null, "");
	}

	/*
	 * Prueba metodo isResultado de la clase Estudio.
	 */

}

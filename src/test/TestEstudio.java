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
	public void ConstructorDeEstudio() throws StringVacioException {

		Estudio estudioDePrueba = new Estudio("nombre", "indicacion");
		Assert.assertEquals("nombre", estudioDePrueba.getNombre());

	}

	@Test
	public void ConstructorDeEstudioConExcepcion() throws StringVacioException {

		exception.expect(StringVacioException.class);
		new Estudio("", "");

	}

	@Test
	public void EstudioConIndicacion() throws StringVacioException {
		Estudio estudioDePrueba = new Estudio("nombre", "indicacion");
		Assert.assertEquals("indicacion", estudioDePrueba.getIndicacion());
	}

	/*
	 * Prueba get resultado de un estudio
	 */

	@Test
	public void EstudioConResultado() throws StringVacioException {
		Estudio estudioDePrueba = new Estudio("nombre", "indicacion");

		estudioDePrueba.setResultado(ClasificacionEstudio.NORMAL, "OK");

		Assert.assertEquals(EstadoPrestacion.FINALIZADO,
				estudioDePrueba.getEstado());
	}

	@Test
	public void EstudioConResultadoNormal() throws StringVacioException {
		Estudio estudioDePrueba = new Estudio("nombre", "indicacion");

		estudioDePrueba.setResultado(ClasificacionEstudio.NORMAL, "OK");

		Assert.assertEquals(ClasificacionEstudio.NORMAL,
				estudioDePrueba.getClasificacion());
	}

	@Test
	public void EstudioConResultadoAnormal() throws StringVacioException {
		Estudio estudioDePrueba = new Estudio("nombre", "indicacion");

		estudioDePrueba.setResultado(ClasificacionEstudio.ANORMAL, "No OK");

		Assert.assertEquals(ClasificacionEstudio.ANORMAL,
				estudioDePrueba.getClasificacion());
	}

	@Test
	public void getResultado() throws StringVacioException {
		Estudio estudioDePrueba = new Estudio("Tomografia", "indicacion");

		estudioDePrueba.setResultado(ClasificacionEstudio.NORMAL, "OK");

		String resultado = "Nombre del estudio: Tomografia. Clasificacion: NORMAL. OK.";
		Assert.assertTrue(estudioDePrueba.getResultado().contains(resultado));
	}

	@Test
	public void testEstudioConSeteoResultadoErroneo()
			throws StringVacioException {
		Estudio estudioDePrueba = new Estudio("nombre", "indicacion");

		exception.expect(StringVacioException.class);
		estudioDePrueba.setResultado(null, "");
	}

}

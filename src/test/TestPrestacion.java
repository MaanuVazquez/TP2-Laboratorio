package test;

import laboratorio.Estudio;
import laboratorio.Prestacion;

import org.junit.Assert;
import org.junit.Test;

import enums.EstadoPrestacion;
import excepciones.StringVacioException;

public class TestPrestacion {

	/*
	 * Prueba constructor
	 */

	@Test
	public void testConstructor() throws StringVacioException {

		Prestacion prestacion = new Estudio("nombre", "indicacion");
		Assert.assertEquals("nombre", prestacion.getNombre());
		Assert.assertEquals(EstadoPrestacion.PENDIENTE, prestacion.getEstado());

	}

	/*
	 * Prueba incremento del id
	 */

	@Test
	public void testGetId() throws StringVacioException {
		Prestacion prestacion1 = new Estudio("nombre", "indicacion");
		Prestacion prestacion2 = new Estudio("nombre2", "indicacion");
		Assert.assertEquals(prestacion1.getId() + 1, prestacion2.getId());
	}

}

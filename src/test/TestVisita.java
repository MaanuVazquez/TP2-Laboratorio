package test;

import java.text.ParseException;

import laboratorio.Estudio;
import laboratorio.Paciente;
import laboratorio.Prestacion;
import laboratorio.Visita;

import org.junit.Assert;
import org.junit.Test;

import excepciones.StringVacioException;
import excepciones.ValoresNegativosException;

public class TestVisita {

	/*
	 * Prueba Constructor
	 */

	@Test
	public void crearVisita() throws StringVacioException,
			ValoresNegativosException, ParseException {
		Prestacion prestacion = new Estudio("Nombre", "indicacion");
		Paciente paciente = new Paciente("nombre", 123, "telefono", "mail");
		Visita visita = new Visita(prestacion, paciente);
		Assert.assertEquals(paciente, visita.getPaciente());
		Assert.assertEquals(prestacion, visita.getPrestacion());
	}

	/*
	 * Prueba incremento del id
	 */

	@Test
	public void testGetId() throws StringVacioException,
			ValoresNegativosException, ParseException {
		Prestacion prestacion = new Estudio("Nombre", "indicacion");
		Paciente paciente = new Paciente("nombre", 123, "telefono", "mail");
		Visita visita1 = new Visita(prestacion, paciente);
		Visita visita2 = new Visita(prestacion, paciente);
		Assert.assertEquals(visita1.getId() + 1, (int) visita2.getId());
	}

}

package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import laboratorio.Analisis;
import laboratorio.Estudio;
import laboratorio.GrupoDeEstudios;
import laboratorio.Paciente;
import laboratorio.Prestacion;
import laboratorio.Visita;

import org.junit.Assert;
import org.junit.Test;

import excepciones.RangoDeValoresInvalido;
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
	
	@Test
	public void testPacienteVisita() throws StringVacioException, ValoresNegativosException, ParseException{
		
		Prestacion prestacion = new Estudio("Nombre", "indicacion");
		Paciente paciente = new Paciente("nombre", 123, "telefono", "mail");
		
		Visita visita1 = new Visita(prestacion, paciente);
		Assert.assertTrue(paciente.getDni() == visita1.getPaciente().getDni());
	}
	
	@Test
	public void testVisitaConAnalisis() throws StringVacioException, ValoresNegativosException, ParseException, RangoDeValoresInvalido{
		
		Prestacion prestacion = new Analisis("Analisis 1", "indicacion", 10, 100);
		Paciente paciente = new Paciente("nombre", 123, "telefono", "mail");
		
		Visita visita1 = new Visita(prestacion, paciente);
		Assert.assertEquals("Analisis 1" , visita1.getPrestacion().getNombre());
	}
	
	@Test
	public void testVisitaConEstudios() throws StringVacioException, ValoresNegativosException, ParseException{
		
		Prestacion prestacion = new Estudio("Estudio 1", "indicacion");
		Paciente paciente = new Paciente("nombre", 123, "telefono", "mail");
		
		Visita visita1 = new Visita(prestacion, paciente);
		Assert.assertEquals("Estudio 1" , visita1.getPrestacion().getNombre());
	}
	
	@Test
	public void testVisitaConGrupoDeEstudios() throws StringVacioException, ValoresNegativosException, ParseException, RangoDeValoresInvalido{
		
		GrupoDeEstudios prestacion = new GrupoDeEstudios("Grupo 1", "indicacion");
		Analisis analisis = new Analisis("Analisis 1" , "indicacion" , 0 ,100);
		prestacion.agregarEstudio(analisis);
		Paciente paciente = new Paciente("nombre", 123, "telefono", "mail");
		
		Visita visita1 = new Visita(prestacion, paciente);
		Assert.assertEquals("Grupo 1" , visita1.getPrestacion().getNombre());
	}
	
	@Test
	public void testFechaVisita() throws StringVacioException, ValoresNegativosException, ParseException, RangoDeValoresInvalido{
		
		GrupoDeEstudios prestacion = new GrupoDeEstudios("Grupo 1", "indicacion");
		Analisis analisis = new Analisis("Analisis 1" , "indicacion" , 0 ,100);
		prestacion.agregarEstudio(analisis);
		Paciente paciente = new Paciente("nombre", 123, "telefono", "mail");
		
		Visita visita1 = new Visita(prestacion, paciente);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaTest = formatter.parse(formatter.format(new Date()));
		
		Assert.assertTrue(fechaTest.equals(visita1.getFecha()));
	}

}

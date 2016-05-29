package test;

import laboratorio.Paciente;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import excepciones.PacienteRegistroException;


public class TestPaciente {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testConstructorPaciente() throws PacienteRegistroException {
		Paciente pacienteDePrueba = new Paciente("nombre", 1111111, "123123112","mail");
		
		Assert.assertTrue(pacienteDePrueba instanceof Paciente);
		
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testPacienteConDniErroneo() throws PacienteRegistroException {
		
		exception.expect(PacienteRegistroException.class);
		Paciente pacienteDePrueba = new Paciente("nombre", -10, "123123112","mail");
		
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testPacienteConCadenasVaciasErroneo() throws PacienteRegistroException {
		
		exception.expect(PacienteRegistroException.class);
		Paciente pacienteDePrueba = new Paciente("nombre", 10, "","");
		
	}
	
	/*
	 * Prueba getId y setId
	 */

	@Test
	public void testIdPacienteIncremental() throws PacienteRegistroException {
		Paciente pacienteDePruebaA = new Paciente("Paciente A", 1111111, "123123112","mailA");
		Paciente pacienteDePruebaB = new Paciente("Paciente B", 1111112, "123123112","mailB");
		
		Integer idPacienteA = pacienteDePruebaA.getId();
		idPacienteA++;
		Assert.assertEquals(idPacienteA, pacienteDePruebaB.getId() , 0);
	}

	/*
	 * Prueba getNombre y setNombre
	 */

	@Test
	public void testGetAndSetNombre() throws PacienteRegistroException {
		Paciente pacienteDePrueba = new Paciente("nombre", 1111111, "123123112","mail");
		pacienteDePrueba.setNombre("nombre b");
		
		Assert.assertEquals("nombre b",pacienteDePrueba.getNombre());
	}

	/*
	 * Prueba getDni
	 */

	@Test
	public void testGetAndSetDni() throws PacienteRegistroException {
		Paciente pacienteDePrueba = new Paciente("nombre", 1111111, "123123112","mail");
		pacienteDePrueba.setDni(12312365);
		Assert.assertEquals(12312365,pacienteDePrueba.getDni() , 0);

	}

	/*
	 * Prueba getTelefono y setTelefono
	 */

	@Test
	public void testGetAndSetTelefono() throws PacienteRegistroException {
		Paciente pacienteDePrueba = new Paciente("nombre", 1111111, "123123112","mail");
		
		pacienteDePrueba.setTelefono("011-123123112");
		Assert.assertEquals("011-123123112",pacienteDePrueba.getTelefono());
	}

	/*
	 * Prueba getMail y setMail
	 */

	@Test
	public void testGetAndSetMail() throws PacienteRegistroException {
		Paciente pacienteDePrueba = new Paciente("nombre", 1111111, "123123112","mail");

		pacienteDePrueba.setMail("no-tengo-mail@hotmail.com");
		Assert.assertEquals("no-tengo-mail@hotmail.com",pacienteDePrueba.getMail());
	}


}

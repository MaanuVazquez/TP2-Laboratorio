package test;

import laboratorio.Paciente;

import org.junit.Test;

public class TestPaciente {

	/*
	 * Prueba constructor
	 */

	@Test
	public void testConstructorPaciente() {
		Paciente pacienteDePrueba = new Paciente("nombre", "dni", "telefono",
				"mail");

	}

	/*
	 * Prueba getId y setId
	 */

	@Test
	public void testGetAndSetId() {
		Paciente pacienteDePrueba = new Paciente("nombre", "dni", "telefono",
				"mail");
		pacienteDePrueba.setId(10);
		pacienteDePrueba.getId();
	}

	/*
	 * Prueba getNombre y setNombre
	 */

	@Test
	public void testGetAndSetNombre() {
		Paciente pacienteDePrueba = new Paciente("nombre", "dni", "telefono",
				"mail");
		pacienteDePrueba.setNombre("nombre");
		pacienteDePrueba.getNombre();
	}

	/*
	 * Prueba getDni
	 */

	@Test
	public void testGetAndSetDni() {
		Paciente pacienteDePrueba = new Paciente("nombre", "dni", "telefono",
				"mail");
		pacienteDePrueba.setDni("12312365");
		pacienteDePrueba.getDni();

	}

	/*
	 * Prueba getTelefono y setTelefono
	 */

	@Test
	public void testGetAndSetTelefono() {
		Paciente pacienteDePrueba = new Paciente("nombre", "dni", "telefono",
				"mail");
		pacienteDePrueba.setDni("45645632");
		pacienteDePrueba.getDni();
	}

	/*
	 * Prueba getMail y setMail
	 */

	@Test
	public void testGetAndSetMail() {
		Paciente pacienteDePrueba = new Paciente("nombre", "dni", "telefono",
				"mail");

		pacienteDePrueba.setMail("no-tengo-mail@hotmail.com");
		pacienteDePrueba.getMail();
	}

}

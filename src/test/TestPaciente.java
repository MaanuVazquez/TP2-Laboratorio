package test;

import laboratorio.Paciente;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import excepciones.StringVacioException;
import excepciones.ValoresNegativosException;

public class TestPaciente {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void ConstructorDePaciente() throws StringVacioException,
			ValoresNegativosException {

		Paciente pacienteDePrueba = new Paciente("nombre", 10, "123123112",
				"mail");

		Assert.assertEquals("nombre", pacienteDePrueba.getNombre());
	}

	@Test
	public void PacienteConDniErroneo() throws StringVacioException,
			ValoresNegativosException {

		exception.expect(ValoresNegativosException.class);
		new Paciente("nombre", -10, "123123112", "mail");

	}

	@Test
	public void PacienteConCadenasVaciasErroneo() throws StringVacioException,
			ValoresNegativosException {

		exception.expect(StringVacioException.class);
		new Paciente("nombre", 10, "", "");

	}

	/*
	 * Prueba incremento del Id al crear paciente
	 */

	@Test
	public void IdPacienteIncremental() throws StringVacioException,
			ValoresNegativosException {
		Paciente pacienteDePruebaA = new Paciente("Paciente A", 1111111,
				"123123112", "mailA");
		Paciente pacienteDePruebaB = new Paciente("Paciente B", 1111112,
				"123123112", "mailB");

		Integer idPacienteA = pacienteDePruebaA.getId();
		idPacienteA++;
		Assert.assertEquals(idPacienteA, pacienteDePruebaB.getId(), 0);
	}

	/*
	 * Prueba getNombre y setNombre
	 */

	@Test
	public void GetAndSetNombre() throws StringVacioException,
			ValoresNegativosException {
		Paciente pacienteDePrueba = new Paciente("nombre", 1111111,
				"123123112", "mail");
		pacienteDePrueba.setNombre("nombre b");

		Assert.assertEquals("nombre b", pacienteDePrueba.getNombre());
	}

	/*
	 * Prueba getDni
	 */

	@Test
	public void GetAndSetDni() throws StringVacioException,
			ValoresNegativosException {
		Paciente pacienteDePrueba = new Paciente("nombre", 1111111,
				"123123112", "mail");
		pacienteDePrueba.setDni(12312365);
		Assert.assertEquals(12312365, pacienteDePrueba.getDni(), 0);

	}

	/*
	 * Prueba getTelefono y setTelefono
	 */

	@Test
	public void GetAndSetTelefono() throws StringVacioException,
			ValoresNegativosException {
		Paciente pacienteDePrueba = new Paciente("nombre", 1111111,
				"123123112", "mail");

		pacienteDePrueba.setTelefono("011-123123112");
		Assert.assertEquals("011-123123112", pacienteDePrueba.getTelefono());
	}

	/*
	 * Prueba getMail y setMail
	 */

	@Test
	public void GetAndSetMail() throws StringVacioException,
			ValoresNegativosException {
		Paciente pacienteDePrueba = new Paciente("nombre", 1111111,
				"123123112", "mail");

		pacienteDePrueba.setMail("no-tengo-mail@hotmail.com");
		Assert.assertEquals("no-tengo-mail@hotmail.com",
				pacienteDePrueba.getMail());
	}

}

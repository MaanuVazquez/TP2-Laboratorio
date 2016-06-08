package test;

import java.text.ParseException;
import java.util.Date;

import laboratorio.Analisis;
import laboratorio.Estudio;
import laboratorio.Laboratorio;
import laboratorio.Paciente;
import laboratorio.Prestacion;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import enums.ClasificacionEstudio;
import excepciones.FechasInvalidasException;
import excepciones.PrestacionExistenteException;
import excepciones.RangoDeValoresInvalido;
import excepciones.StringVacioException;
import excepciones.ValoresNegativosException;

public class TestLaboratorio {

	@Rule
	public final ExpectedException excepcionEsperada = ExpectedException.none();

	/*
	 * Prueba buscarPaciente
	 */

	@Test
	public void testBuscarPaciente() throws StringVacioException,
			ValoresNegativosException {
		Paciente paciente = new Paciente("nombre", 10, "123123112", "mail");
		Laboratorio.getIntance().agregarPaciente(paciente);
		Assert.assertEquals(paciente,
				Laboratorio.getIntance().buscarPaciente(paciente.getDni()));
	}

	/*
	 * Test despues de agregar un analisis te lo muestra
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void listarEstadisticas() throws FechasInvalidasException,
			ValoresNegativosException, StringVacioException,
			RangoDeValoresInvalido, PrestacionExistenteException,
			ParseException {
		Date inicio = new Date(0, 0, 0);
		Date fin = new Date(1000, 0, 0);
		Analisis analisis = new Analisis("El Analisis De La Estadistica",
				"indicacion", 10.0, 50.0);
		Paciente paciente = new Paciente("nombre", 10, "123123112", "mail");
		Laboratorio.getIntance().agregarVisita(analisis, paciente);
		analisis.setResultado(20);
		String estadistica = "Valor Maximo Medido: 20.0, Valor Minimo Medido: 20.0, Promedio de Valores: 20.0";
		Assert.assertTrue(Laboratorio.getIntance()
				.listarEstadisticas(inicio, fin).contains(estadistica));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void listarMultiplesEstadisticas() throws FechasInvalidasException,
			ValoresNegativosException, StringVacioException,
			RangoDeValoresInvalido, PrestacionExistenteException,
			ParseException {
		Laboratorio laboratorio = Laboratorio.getIntance();
		Date inicio = new Date(0, 0, 0);
		Date fin = new Date(1000, 0, 0);
		Analisis analisis1 = new Analisis("Analisis Estadistica", "indicacion",
				10.0, 50.0);
		Paciente paciente = new Paciente("nombre", 10, "123123112", "mail");
		Analisis analisis2 = new Analisis("Analisis Estadistica", "indicacion",
				10.0, 50.0);
		laboratorio.agregarVisita(analisis1, paciente);
		laboratorio.agregarVisita(analisis2, paciente);
		analisis1.setResultado(20);
		analisis2.setResultado(30);
		Estudio estudio1 = new Estudio("El Estudio De La Estadistica",
				"indicacion");
		Estudio estudio2 = new Estudio("El Estudio De La Estadistica",
				"indicacion");
		estudio1.setResultado(ClasificacionEstudio.NORMAL, "ok");
		laboratorio.agregarVisita(estudio1, paciente);
		laboratorio.agregarVisita(estudio2, paciente);
		estudio2.setResultado(ClasificacionEstudio.ANORMAL, "ok");
		String EstadisticasAnalisis = "Valor Maximo Medido: 30.0, Valor Minimo Medido: 20.0, Promedio de Valores: 25.0";
		String EstadisticasEstudios = "Cantidad de Resultados Normales: 1, Cantidad de Resultados Anormales: 1";
		Assert.assertTrue(laboratorio.listarEstadisticas(inicio, fin).contains(
				EstadisticasAnalisis));
		Assert.assertTrue(laboratorio.listarEstadisticas(inicio, fin).contains(
				EstadisticasEstudios));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void NolistarEstadisticasFueraDeFecha() throws FechasInvalidasException,
			ValoresNegativosException, StringVacioException,
			RangoDeValoresInvalido, PrestacionExistenteException,
			ParseException {
		Laboratorio laboratorio = Laboratorio.getIntance();
		Date inicio = new Date(100, 0, 0);
		Date fin = new Date(110, 0, 0);
		Analisis analisis1 = new Analisis("Analisis", "indicacion",
				10.0, 50.0);
		Paciente paciente = new Paciente("nombre", 10, "123123112", "mail");
		Analisis analisis2 = new Analisis("Analisis", "indicacion",
				10.0, 50.0);
		laboratorio.agregarVisita(analisis1, paciente);
		laboratorio.agregarVisita(analisis2, paciente);
		analisis1.setResultado(20);
		analisis2.setResultado(30);
		Estudio estudio1 = new Estudio("Estudio",
				"indicacion");
		Estudio estudio2 = new Estudio("Estudio",
				"indicacion");
		estudio1.setResultado(ClasificacionEstudio.NORMAL, "ok");
		laboratorio.agregarVisita(estudio1, paciente);
		laboratorio.agregarVisita(estudio2, paciente);
		estudio2.setResultado(ClasificacionEstudio.ANORMAL, "ok");
		String EstadisticasAnalisis = "Valor Maximo Medido: 30.0, Valor Minimo Medido: 20.0, Promedio de Valores: 25.0";
		String EstadisticasEstudios = "Cantidad de Resultados Normales: 1, Cantidad de Resultados Anormales: 1";
		Assert.assertFalse(laboratorio.listarEstadisticas(inicio, fin).contains(
				EstadisticasAnalisis));
		Assert.assertFalse(laboratorio.listarEstadisticas(inicio, fin).contains(
				EstadisticasEstudios));
	}

	/*
	 * Prueba error Fechas Invalidas.
	 */

	@Test
	@SuppressWarnings("deprecation")
	public void testFechasInvalidas() throws FechasInvalidasException {
		excepcionEsperada.expect(FechasInvalidasException.class);
		Date inicio = new Date(200, 1, 1);
		Date fin = new Date(100, 1, 1);
		Laboratorio.getIntance().listarEstadisticas(inicio, fin);
	}

	/*
	 * Prueba error prestacion ya existente
	 */

	@Test
	public void testPrestacionExistente() throws StringVacioException,
			PrestacionExistenteException, ParseException,
			ValoresNegativosException {
		excepcionEsperada.expect(PrestacionExistenteException.class);
		Prestacion prestacion = new Estudio("nombre", "indicacion");
		Paciente paciente = new Paciente("nombre", 123, "telefono", "mail");
		Laboratorio.getIntance().agregarVisita(prestacion, paciente);
		Laboratorio.getIntance().agregarVisita(prestacion, paciente);
	}

}

package test;

import java.text.ParseException;
import java.util.Date;

import laboratorio.Analisis;
import laboratorio.Laboratorio;
import laboratorio.Paciente;

import org.junit.Assert;
import org.junit.Test;

import excepciones.FechasInvalidasException;
import excepciones.PrestacionExistenteException;
import excepciones.RangoDeValoresInvalido;
import excepciones.StringVacioException;
import excepciones.ValoresNegativosException;

public class TestEstadistica {
	/*
	 * Test despues de agregar un analisis te lo muestra 
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void iniciarEstadistica() throws FechasInvalidasException, ValoresNegativosException, StringVacioException,
			RangoDeValoresInvalido, PrestacionExistenteException, ParseException {
		Date inicio = new Date(0, 0, 0);
		Date fin = new Date(1000, 0, 0);
		Analisis analisis = new Analisis("nombre", "indicacion", 10.0, 50.0);
		Paciente paciente = new Paciente("nombre", 10, "123123112", "mail");
		Laboratorio.getIntance().agregarVisita(analisis, paciente);
		analisis.setResultado(20);
		System.out.print(Laboratorio.getIntance().listarEstadisticas(inicio, fin));
		String estadistica = "Valor Maximo Medido: 20.0, Valor Minimo Medido: 20.0, Promedio de Valores: 20.0";
		Assert.assertTrue(Laboratorio.getIntance().listarEstadisticas(inicio, fin).contains(estadistica));
	}
}

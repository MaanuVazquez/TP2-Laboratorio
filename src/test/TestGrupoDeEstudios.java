package test;

import laboratorio.Analisis;
import laboratorio.GrupoDeEstudios;

import org.junit.Assert;
import org.junit.Test;

import excepciones.RangoDeValoresInvalido;
import excepciones.StringVacioException;
import excepciones.ValoresNegativosException;

public class TestGrupoDeEstudios {

	/*
	 * Prueba constructor de GrupoDeEstudio.
	 */

	@Test
	public void ConstructorGrupoDeEstudios() throws StringVacioException {

		GrupoDeEstudios grupoDeEstudiosDePrueba = new GrupoDeEstudios("nombre",
				"indicacion");
		Assert.assertEquals("nombre", grupoDeEstudiosDePrueba.getNombre());
	}

	/*
	 * Prueba agregarEstudio
	 */
	
	@Test
	public void AgregarEstudio() throws StringVacioException, ValoresNegativosException, RangoDeValoresInvalido {
		GrupoDeEstudios grupoDeEstudiosDePrueba = new GrupoDeEstudios("nombre",
				"indicacion");
		Analisis analisis = new Analisis("Analisis1", "Ninguna", 15, 30);
		analisis.setResultado(20);
		grupoDeEstudiosDePrueba.agregarEstudio(analisis);
		String Resultado = analisis.getResultado();
		Assert.assertTrue(grupoDeEstudiosDePrueba.getResultado().contains(Resultado));
	}
	
}

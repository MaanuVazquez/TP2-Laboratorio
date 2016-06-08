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
	 * Prueba agregarEstudio y devolver resultado
	 */

	@Test
	public void AgregarEstudio() throws StringVacioException,
			ValoresNegativosException, RangoDeValoresInvalido {
		GrupoDeEstudios grupoDeEstudiosDePrueba = new GrupoDeEstudios("nombre",
				"indicacion");
		Analisis analisis = new Analisis("Analisis1", "Ninguna", 15, 30);
		analisis.setResultado(20);
		grupoDeEstudiosDePrueba.agregarEstudio(analisis);
		String Resultado = analisis.getResultado();
		Assert.assertTrue(grupoDeEstudiosDePrueba.getResultado().contains(
				Resultado));
	}

	/*
	 * Prueba multiples grupos de estudios anidados
	 */

	@Test
	public void AnidarGruposDeEstudios() throws StringVacioException,
			ValoresNegativosException, RangoDeValoresInvalido {
		GrupoDeEstudios grupoDeEstudiosPadre = new GrupoDeEstudios("nombre",
				"indicacion");
		GrupoDeEstudios grupoDeEstudiosHijo = new GrupoDeEstudios("nombre",
				"indicacion");
		Analisis analisis = new Analisis("Analisis1", "Ninguna", 15, 30);
		analisis.setResultado(20);
		grupoDeEstudiosHijo.agregarEstudio(analisis);
		grupoDeEstudiosPadre.agregarEstudio(grupoDeEstudiosHijo);
		Assert.assertTrue(grupoDeEstudiosPadre.getResultado().contains(
				analisis.getResultado()));
		Assert.assertTrue(grupoDeEstudiosPadre.getResultado().contains(
				grupoDeEstudiosHijo.getResultado()));
	}
}

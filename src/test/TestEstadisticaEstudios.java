package test;

import org.junit.Assert;
import org.junit.Test;
import enums.ClasificacionEstudio;
import estadisticas.EstadisticaEstudios;
import excepciones.RangoDeValoresInvalido;
import excepciones.StringVacioException;
import excepciones.ValoresNegativosException;

import laboratorio.Estudio;

public class TestEstadisticaEstudios {

	@Test
	public void testConstructorEstadisticaEstudios()
			throws StringVacioException, ValoresNegativosException,
			RangoDeValoresInvalido {

		Estudio estudio = new Estudio("Estudio 1", "Indicacion");
		estudio.setResultado(ClasificacionEstudio.NORMAL, "informe");
		EstadisticaEstudios est = new EstadisticaEstudios(estudio);

		Assert.assertTrue(est.getNumeroDePacientes() == 1);

	}

	@Test
	public void testCantidadPacientesEstadisticaEstudios()
			throws StringVacioException, ValoresNegativosException,
			RangoDeValoresInvalido {

		Estudio estudio = new Estudio("Estudio 1", "Indicacion");
		estudio.setResultado(ClasificacionEstudio.NORMAL, "informe");

		Estudio estudio2 = new Estudio("Estudio 2", "Indicacion");
		estudio2.setResultado(ClasificacionEstudio.NORMAL, "informe");

		Estudio estudio3 = new Estudio("Estudio 3", "Indicacion");
		estudio3.setResultado(ClasificacionEstudio.NORMAL, "informe");

		Estudio estudio4 = new Estudio("Estudio 4", "Indicacion");
		estudio4.setResultado(ClasificacionEstudio.NORMAL, "informe");

		Estudio estudio5 = new Estudio("Estudio 5", "Indicacion");
		estudio5.setResultado(ClasificacionEstudio.NORMAL, "informe");

		EstadisticaEstudios est = new EstadisticaEstudios(estudio);
		est.agregarPrestacion(estudio2);
		est.agregarPrestacion(estudio3);
		est.agregarPrestacion(estudio4);
		est.agregarPrestacion(estudio5);

		Assert.assertEquals(5, est.getNumeroDePacientes(), 0);

	}

	@Test
	public void testCantidadResultadosNormalesEstadisticaEstudios()
			throws StringVacioException, ValoresNegativosException,
			RangoDeValoresInvalido {

		Estudio estudio = new Estudio("Estudio 1", "Indicacion");
		estudio.setResultado(ClasificacionEstudio.ANORMAL, "informe");

		Estudio estudio2 = new Estudio("Estudio 2", "Indicacion");
		estudio2.setResultado(ClasificacionEstudio.ANORMAL, "informe");

		Estudio estudio3 = new Estudio("Estudio 3", "Indicacion");
		estudio3.setResultado(ClasificacionEstudio.NORMAL, "informe");

		Estudio estudio4 = new Estudio("Estudio 4", "Indicacion");
		estudio4.setResultado(ClasificacionEstudio.NORMAL, "informe");

		Estudio estudio5 = new Estudio("Estudio 5", "Indicacion");
		estudio5.setResultado(ClasificacionEstudio.NORMAL, "informe");

		EstadisticaEstudios est = new EstadisticaEstudios(estudio);
		est.agregarPrestacion(estudio2);
		est.agregarPrestacion(estudio3);
		est.agregarPrestacion(estudio4);
		est.agregarPrestacion(estudio5);

		Assert.assertEquals(3, est.getCantidadResultadosNormales(), 0);

	}

	@Test
	public void testCantidadResultadosAnormalesEstadisticaEstudios()
			throws StringVacioException, ValoresNegativosException,
			RangoDeValoresInvalido {

		Estudio estudio = new Estudio("Estudio 1", "Indicacion");
		estudio.setResultado(ClasificacionEstudio.ANORMAL, "informe");

		Estudio estudio2 = new Estudio("Estudio 2", "Indicacion");
		estudio2.setResultado(ClasificacionEstudio.ANORMAL, "informe");

		Estudio estudio3 = new Estudio("Estudio 3", "Indicacion");
		estudio3.setResultado(ClasificacionEstudio.NORMAL, "informe");

		Estudio estudio4 = new Estudio("Estudio 4", "Indicacion");
		estudio4.setResultado(ClasificacionEstudio.NORMAL, "informe");

		Estudio estudio5 = new Estudio("Estudio 5", "Indicacion");
		estudio5.setResultado(ClasificacionEstudio.NORMAL, "informe");

		EstadisticaEstudios est = new EstadisticaEstudios(estudio);
		est.agregarPrestacion(estudio2);
		est.agregarPrestacion(estudio3);
		est.agregarPrestacion(estudio4);
		est.agregarPrestacion(estudio5);

		Assert.assertEquals(2, est.getCantidadResultadosAnormales(), 0);

	}

}

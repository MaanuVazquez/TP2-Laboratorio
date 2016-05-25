package test;

import laboratorio.GrupoDeEstudios;

import org.junit.Test;

public class TestGrupoDeEstudios {

	/*
	 * Prueba constructor de GrupoDeEstudio.
	 */

	@Test
	public void testConstructorGrupoDeEstudios() {

		GrupoDeEstudios grupoDeEstudiosDePrueba = new GrupoDeEstudios("nombre",
				"indicacion");

		// favor de borrar es por el warning
		grupoDeEstudiosDePrueba.getId();
	}

	/*
	 * Prueba agregarEstudio
	 */
	
	@Test
	public void testAgregarEstudio() {
		GrupoDeEstudios grupoDeEstudiosDePrueba = new GrupoDeEstudios("nombre",
				"indicacion");
		
		//grupoDeEstudiosDePrueba.agregarEstudio();
	}
	
	/*
	 * Prueba removerEstudio
	 */
	
	@Test
	public void testRemoverEstudio(){
		GrupoDeEstudios grupoDeEstudiosDePrueba = new GrupoDeEstudios("nombre",
				"indicacion");
		
		//grupoDeEstudiosDePrueba.removerEstudio(e);
	}
	
	/*
	 * Prueba mostrarEstudios
	 */
	
	@Test
	public void testMostrarEstudio(){
		GrupoDeEstudios grupoDeEstudiosDePrueba = new GrupoDeEstudios("nombre",
				"indicacion");
		
		grupoDeEstudiosDePrueba.mostrarEstudios();
	}
	
	/*
	 * Prueba getResultado
	 */
	
	@Test
	public void testGetResultado(){
		GrupoDeEstudios grupoDeEstudiosDePrueba = new GrupoDeEstudios("nombre",
				"indicacion");
		
		grupoDeEstudiosDePrueba.getResultado();
	}
	

}

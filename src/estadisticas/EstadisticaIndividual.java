package estadisticas;

import laboratorio.Prestacion;

public abstract class EstadisticaIndividual {

	private String nombre;
	protected int numeroDePacientes;

	public EstadisticaIndividual(Prestacion prestacion) {
		this.nombre = prestacion.getNombre();
		this.numeroDePacientes = 0;
	}

	public abstract void agregarPrestacion(Prestacion prestacion);

	public String toString() {
		return "[Nombre: " + nombre + ", Cantidad de pacientes: " + numeroDePacientes + ", \n";
	}
}

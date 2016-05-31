package laboratorio;

import java.util.Date;
import java.util.HashMap;

import excepciones.FechasInvalidasException;
import excepciones.PrestacionExistenteException;

public class Laboratorio {

	private static Laboratorio laboratorioInstance = new Laboratorio();

	private HashMap<Integer, Prestacion> prestaciones;
	private HashMap<Integer, Paciente> pacientes;
	private HashMap<Integer, Visita> prestacionPaciente;

	private Laboratorio() {
		this.prestaciones = new HashMap<Integer, Prestacion>();
		this.pacientes = new HashMap<Integer, Paciente>();
		this.prestacionPaciente = new HashMap<Integer, Visita>();
	}

	public void cargarResultado(Prestacion prestacion, Paciente paciente)
			throws PrestacionExistenteException {
		if (this.prestaciones.put(prestacion.getId(), prestacion) != null) {
			throw new PrestacionExistenteException();
		}
		Visita visita = new Visita(prestacion, paciente);
		this.prestacionPaciente.put(visita.getId(), visita);
	}

	public void agregarPaciente(Paciente p) {
		this.pacientes.put(p.getId(), p);
	}

	public Paciente buscarPaciente(int id) {
		return pacientes.get(id);
	}

	public static Laboratorio getIntance() {
		return laboratorioInstance;
	}

	public String listarEstadisticas(Date inicio, Date fin)
			throws FechasInvalidasException {

		if (inicio.compareTo(fin) > 0) {
			throw new FechasInvalidasException(inicio, fin);
		}

		Estadistica estadistica = new Estadistica();

		for (Integer i : prestacionPaciente.keySet()) {
			Visita visita = prestacionPaciente.get(i);

			if (visita.getFecha().compareTo(inicio) >= 0	&& visita.getFecha().compareTo(fin) <= 0) {
				estadistica.addPrestacion(visita.getPrestacion());
			}
		}
		return estadistica.toString();
	}
}

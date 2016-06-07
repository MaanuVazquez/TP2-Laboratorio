package laboratorio;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

import excepciones.FechasInvalidasException;
import excepciones.PrestacionExistenteException;

public class Laboratorio {

	private static Laboratorio laboratorioInstance = new Laboratorio();

	private HashMap<Integer, Prestacion> prestaciones;
	private HashMap<Integer, Paciente> pacientes;
	private HashMap<Integer, Visita> visitas;

	private Laboratorio() {
		this.prestaciones = new HashMap<Integer, Prestacion>();
		this.pacientes = new HashMap<Integer, Paciente>();
		this.visitas = new HashMap<Integer, Visita>();
	}

	public void agregarVisita(Prestacion prestacion, Paciente paciente) throws PrestacionExistenteException, ParseException {
		if (this.prestaciones.put(prestacion.getId(), prestacion) != null) {
			throw new PrestacionExistenteException();
		}
		Visita visita = new Visita(prestacion, paciente);
		this.visitas.put(visita.getId(), visita);
	}

	public void agregarPaciente(Paciente p) {
		this.pacientes.put(p.getDni(), p);
	}

	public Paciente buscarPaciente(int id) {
		return pacientes.get(id);
	}

	public static Laboratorio getIntance() {
		return laboratorioInstance;
	}

	public String listarEstadisticas(Date inicio, Date fin) throws FechasInvalidasException {

		if (inicio.after(fin)) {
			throw new FechasInvalidasException(inicio, fin);
		}

		Estadistica estadistica = new Estadistica();

		for (Integer i : visitas.keySet()) {
			Visita visita = visitas.get(i);

			if (visita.getFecha().compareTo(inicio) >= 0 && visita.getFecha().compareTo(fin) <= 0) {
				estadistica.addPrestacion(visita.getPrestacion());
			}
		}
		return estadistica.mostrarEstadistica();
	}

	public HashMap<Integer, Prestacion> getPrestaciones() {
		return this.prestaciones;
	}

	public HashMap<Integer, Paciente> getPacientes() {
		return this.pacientes;
	}

	public HashMap<Integer, Visita> getVisitas() {
		return this.visitas;
	}
}

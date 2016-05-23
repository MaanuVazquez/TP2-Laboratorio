package laboratorio;

import java.util.Date;
import java.util.HashMap;

import excepciones.FechasInvalidasException;
import excepciones.PrestacionExistenteException;

public class Laboratorio {

	private static Laboratorio laboratorioInstance = new Laboratorio();
	private HashMap<Integer, Prestacion> prestaciones;
	private HashMap<Integer, Paciente> pacientes;
	private HashMap<Integer, PrestacionPaciente> prestacionPaciente;
	
	private Laboratorio(){
		this.prestaciones = new HashMap<Integer, Prestacion>();
		this.pacientes = new HashMap<Integer, Paciente>();
		this.prestacionPaciente = new HashMap<Integer, PrestacionPaciente>();
	}
	
	public void cargarResultado(Prestacion prestacion, Paciente paciente) throws PrestacionExistenteException{
		if(this.prestaciones.put(prestacion.getId(), prestacion) != null){
			throw new PrestacionExistenteException();
		}
		PrestacionPaciente pp = new PrestacionPaciente(prestacion, paciente);
		this.prestacionPaciente.put(pp.getId(), pp);
	}
	
	public void agregarPaciente(Paciente p){
		this.pacientes.put(p.getId(), p);
	}
	
	public Paciente buscarPaciente(int id){
		return pacientes.get(id);
	}
	
	public static Laboratorio getIntance(){
		return laboratorioInstance;
	}
	
	public String listarEstadisticas(Date inicio, Date fin) throws FechasInvalidasException{
		if(inicio.compareTo(fin) != -1){
			throw new FechasInvalidasException(inicio, fin);
		}
		String cadena = "";
		for(Integer i : prestacionPaciente.keySet()){
			PrestacionPaciente p = prestacionPaciente.get(i);
			if(p.getFecha().compareTo(inicio) > -1 &&
					p.getFecha().compareTo(fin) < 1){
				cadena += p.toString() + "\n";
			}
		}
		return cadena;
	}
	
}
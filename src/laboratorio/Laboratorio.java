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
	private HashMap<Integer, Estadistica> estadisticas;
	
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
		
		//Cada vez que las listamos limpiamos el map
		this.estadisticas = new HashMap<Integer, Estadistica>();
		
		//compare to de fechas con cero, si es el mismo dia entre inicio y fin, se pide la estadistica 
		//del dia
		if(inicio.compareTo(fin) > 0){
			throw new FechasInvalidasException(inicio, fin);
		}
		
		for(Integer i : prestacionPaciente.keySet()){
			PrestacionPaciente p = prestacionPaciente.get(i);
			
			//EL COMPARE TO DE FECHAS ES CON 0 
			if(p.getFecha().compareTo(inicio) >= 0 && p.getFecha().compareTo(fin) <= 0){
				if(estadisticas.get(p.getId()) == null){
					estadisticas.put(p.getId() , new Estadistica(p.getPrestacion()));
				}else{
					estadisticas.get( p.getId() ).addPrestacion(p.getPrestacion());					
				}
			}
		}
		
		return estadisticas.toString();
	}
	
}

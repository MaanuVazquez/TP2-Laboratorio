package laboratorio;

import java.util.Date;

public class PrestacionPaciente {
	
	private static Integer idMax = new Integer (1);
	private Prestacion prestacion;
	private Paciente paciente;
	private Integer id;
	private Date fecha;
	
	public PrestacionPaciente(Prestacion prestacion, Paciente paciente) {
		this.prestacion = prestacion;
		this.paciente = paciente;
		this.id = new Integer(idMax.intValue());
		this.fecha = new Date();
	}

	public Prestacion getPrestacion() {
		return prestacion;
	}

	public void setPrestacion(Prestacion prestacion) {
		this.prestacion = prestacion;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

}

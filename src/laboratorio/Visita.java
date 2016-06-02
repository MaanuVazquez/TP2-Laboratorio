package laboratorio;

import java.util.Date;

public class Visita {

	private static Integer idMax = new Integer(1);
	private Prestacion prestacion;
	private Paciente paciente;
	private Integer id;
	private Date fecha;

	public Visita(Prestacion prestacion, Paciente paciente) {
		this.prestacion = prestacion;
		this.paciente = paciente;
		this.id = new Integer(idMax.intValue());
		idMax++;
		this.fecha = new Date();
	}

	public Prestacion getPrestacion() {
		return prestacion;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public Integer getId() {
		return id;
	}

	public Date getFecha() {
		return fecha;
	}

}

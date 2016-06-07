package laboratorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.fecha = formatter.parse(formatter.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

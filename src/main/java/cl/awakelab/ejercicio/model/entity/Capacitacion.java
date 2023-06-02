package cl.awakelab.ejercicio.model.entity;

import java.time.LocalTime;

public class Capacitacion {

	private int identificador;
	private int rutCliente;
	private String dia;
	private LocalTime hora;
	private String lugar;
	private int duracion;
	private int cantidadAsistentes;
	
	public Capacitacion() {

	}

	public Capacitacion(int identificador, int rutCliente, String dia, LocalTime hora, String lugar, int duracion,
			int cantidadAsistentes) {
		super();
		this.identificador = identificador;
		this.rutCliente = rutCliente;
		this.dia = dia;
		this.hora = hora;
		this.lugar = lugar;
		this.duracion = duracion;
		this.cantidadAsistentes = cantidadAsistentes;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public int getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(int rutCliente) {
		this.rutCliente = rutCliente;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getCantidadAsistentes() {
		return cantidadAsistentes;
	}

	public void setCantidadAsistentes(int cantidadAsistentes) {
		this.cantidadAsistentes = cantidadAsistentes;
	}

	@Override
	public String toString() {
		return "Capacitacion " + "identificador: " + identificador + ", rutCliente: " + rutCliente + ", dia: " + dia
				+ ", hora: '" + hora + '\'' + ", lugar: '" + lugar + '\'' + ", duracion: " + duracion
				+ ", cantidadAsistentes: " + cantidadAsistentes;
	}
}

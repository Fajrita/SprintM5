package cl.awakelab.ejercicio.model.entity;

public class Capacitacion {

	private int id;
	private String rutCliente;
	private String dia;
	private String hora;
	private String lugar;
	private int duracion;
	private int cantidadAsistentes;

	public Capacitacion() {

	}

	public Capacitacion(int id, String rutCliente, String dia, String hora, String lugar, int duracion,
			int cantidadAsistentes) {
		super();
		this.id = id;
		this.rutCliente = rutCliente;
		this.dia = dia;
		this.hora = hora;
		this.lugar = lugar;
		this.duracion = duracion;
		this.cantidadAsistentes = cantidadAsistentes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
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
		return "Capacitacion " + "identificador: " + id + ", rutCliente: " + rutCliente + ", dia: " + dia + ", hora: '"
				+ hora + '\'' + ", lugar: '" + lugar + '\'' + ", duracion: " + duracion + ", cantidadAsistentes: "
				+ cantidadAsistentes;
	}
}

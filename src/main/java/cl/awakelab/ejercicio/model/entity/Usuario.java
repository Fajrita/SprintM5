package cl.awakelab.ejercicio.model.entity;

public class Usuario {
	

	/**
	 * Nombre del usuario, por ejemplo: "Luis"
	 */
	private String nombre;
	/**
	 * Fecha de nacimiento del usuario, por ejemplo: "02/04/1980"
	 */
	private String fecha;
	/**
	 * Run del usuario, por ejemplo: "13.567.833-6"
	 */
	private int run;

	/**
	 * Constructor sin parametros para crear una instancia de Usuario
	 */
	public Usuario() {
	}

	/**
	 * Constructor para crear una instancia de Usuario.
	 *
	 * @param nombre el nombre del usuario.
	 * @param fecha  la fecha de nacimiento del usuario en formato "dd/MM/yyyy".
	 * @param run    el RUN del usuario.
	 */
	public Usuario( String nombre, String fecha, int run) {
	
		this.nombre = nombre;
		this.fecha = fecha;
		this.run = run;
	}


	/**
	 * Obtiene el nombre del usuario.
	 *
	 * @return el nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del usuario.
	 *
	 * @param nombre el nuevo nombre del usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la fecha de nacimiento del usuario.
	 *
	 * @return la fecha de nacimiento del usuario
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Establece la fecha de nacimiento del usuario.
	 *
	 * @param fechaNacimiento la nueva fecha de nacimiento del usuario
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene el RUN (Rol Único Nacional) del usuario.
	 *
	 * @return el RUN del usuario
	 */
	public int getRun() {
		return run;
	}

	/**
	 * Establece el RUN (Rol Único Nacional) del usuario.
	 *
	 * @param run el nuevo RUN del usuario
	 */
	public void setRun(int run) {
		this.run = run;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", fecha=" + fecha + ", run=" + run + "]";
	}

}

package cl.awakelab.ejercicio.model.entity;

public class Cliente extends Usuario{
	
	/**
	 * Número de teléfono del cliente.
	 */
	private String telefono;
	/**
	 * AFP del cliente.
	 */
	private String afp;
	/**
	 * Sistema de salud del cliente.
	 */
	private int sistemaSalud;
	/**
	 * Dirección del cliente.
	 */
	private String direccion;
	/**
	 * Comuna del cliente.
	 */
	private String comuna;


	/**
	 * Constructor sin parámetros de la clase Cliente.
	 */
	public Cliente() {
		super();
	}

	/**
	 * /** Crea una instancia de Cliente con los valores proporcionados para las
	 * propiedades.
	 *
	 * @param nombre          El nombre del cliente.
	 * @param fechaNacimiento La fecha de nacimiento del cliente.
	 * @param run             El RUN del cliente.
	 * @param telefono        El número de teléfono del cliente.
	 * @param afp             La AFP del cliente.
	 * @param sistemaSalud    El sistema de salud del cliente.
	 * @param direccion       La dirección del cliente.
	 * @param comuna          La comuna del cliente.
	 */
	public Cliente(String nombre, String fechaNacimiento, int run, String telefono, String afp, int sistemaSalud,
			String direccion, String comuna) {
		super(nombre, fechaNacimiento, run);
		this.telefono = telefono;
		this.afp = afp;
		this.sistemaSalud = sistemaSalud;
		this.direccion = direccion;
		this.comuna = comuna;
	}

	/**
	 * Obtiene el número de teléfono del cliente.
	 * 
	 * @return Número de teléfono del cliente.
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Establece el número de teléfono del cliente.
	 * 
	 * @param telefono Número de teléfono del cliente.
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Obtiene la AFP del cliente.
	 * 
	 * @return AFP del cliente.
	 */
	public String getAfp() {
		return afp;
	}

	/**
	 * Establece la AFP del cliente.
	 * 
	 * @param afp AFP del cliente.
	 */
	public void setAfp(String afp) {
		this.afp = afp;
	}

	/**
	 * Obtiene el sistema de salud del cliente.
	 * 
	 * @return Sistema de salud del cliente.
	 */
	public int getSistemaSalud() {
		return sistemaSalud;
	}

	/**
	 * Establece el sistema de salud del cliente.
	 * 
	 * @param sistemaSalud Sistema de salud del cliente.
	 */
	public void setSistemaSalud(int sistemaSalud) {
		this.sistemaSalud = sistemaSalud;
	}

	/**
	 * Obtiene la dirección del cliente.
	 * 
	 * @return Dirección del cliente.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Establece la dirección del cliente.
	 * 
	 * @param direccion Dirección del cliente.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Obtiene la comuna del cliente.
	 * 
	 * @return Comuna del cliente.
	 */
	public String getComuna() {
		return comuna;
	}

	/**
	 * Establece la comuna del cliente.
	 * 
	 * @param comuna Comuna del cliente.
	 */
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

}

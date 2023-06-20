package cl.awakelab.ejercicio.model.entity;

public class Administrativo extends Usuario {

	/**
	 * Area en donde trabaja el administrativo.
	 */
	private String area;
	/**
	 * Experiencia previa de trabajo del administrativo.
	 */
	private String experienciaPrevia;

	/**
	 * Constructor sin parametros de administrativo.
	 */
	public Administrativo() {
		super();
	}

	/**
	 * Constructor con parametros para crear una instancia de Administrativo.
	 *
	 * @param nombre            El nombre del administrativo.
	 * @param fecha             La fecha de nacimiento del administrativo.
	 * @param run               El RUN del administrativo.
	 * @param area              El área de trabajo del administrativo.
	 * @param experienciaPrevia La experiencia previa del administrativo.
	 */
	public Administrativo(String nombre, String fecha, int run, String area, String experienciaPrevia) {
		super(nombre, fecha, run);
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}

	/**
	 * Obtiene el área de trabajo del administrativo.
	 *
	 * @return el área de trabajo del administrativo
	 */
	public String getArea() {
		return area;
	}

	/**
	 * Establece el área de trabajo del administrativo.
	 *
	 * @param area el nuevo área de trabajo del administrativo
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * Obtiene la experiencia previa del administrativo.
	 *
	 * @return la experiencia previa del administrativo
	 */
	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}

	/**
	 * Establece la experiencia previa del administrativo.
	 *
	 * @param experienciaPrevia la nueva experiencia previa del administrativo
	 */
	public void setExperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}

	@Override
	public String toString() {
		return "Administrativo [area=" + area + ", experienciaPrevia=" + experienciaPrevia + "]";
	}

}

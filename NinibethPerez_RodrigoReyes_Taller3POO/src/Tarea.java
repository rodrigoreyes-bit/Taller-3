/**
 * Clase que representa una Tarea en el sistema.
 * Implementa el método 'accept' para el patrón Visitor.
 */
public class Tarea {
	
	private Proyectos Proyecto;
	private String ID;
	private String Tipo;
	private String Descripcion;
	private String Estado;
	private Usuario responsable;
	private String Complejidad;
	private String Fecha;
	
	/**
     * Constructor para la clase Tarea.
     * @param proyecto El proyecto al que pertenece la tarea.
     * @param iD El identificador único de la tarea.
     * @param tipo El tipo de tarea (Bug, Feature, Documentacion, etc.).
     * @param descripcion La descripción de la tarea.
     * @param estado El estado actual de la tarea (Pendiente, En Progreso, Completada).
     * @param responsable El usuario responsable de la tarea.
     * @param complejidad La complejidad de la tarea (Alta, Media, Baja).
     * @param fecha La fecha límite de la tarea (formato YYYY-MM-DD).
     */
	public Tarea(Proyectos proyecto, String iD, String tipo, String descripcion, String estado, Usuario responsable,
			String complejidad, String fecha) {
		super();
		Proyecto = proyecto;
		ID = iD;
		Tipo = tipo;
		Descripcion = descripcion;
		Estado = estado;
		this.responsable = responsable;
		Complejidad = complejidad;
		Fecha = fecha;
	}
	/**
     * Permite que un objeto Visitor realice una operación en esta tarea (Patrón Visitor).
     * @param v El objeto Visitor que realizará la acción.
     */
	public void accept(Visitor v) {
		v.EvaluarTarea(this);
	}
	
	/** @return El proyecto al que pertenece la tarea. */
	public Proyectos getProyecto() {
		return Proyecto;
	}
	/** @return El ID de la tarea. */
	public String getID() {
		return ID;
	}
	/** @return El tipo de la tarea. */
	public String getTipo() {
		return Tipo;
	}
	/** @return La dscripcion de la tarea. */
	public String getDescripcion() {
		return Descripcion;
	}
	/** @return El estado de la tarea. */
	public String getEstado() {
		return Estado;
	}
	/** @return El usuario responsable de la tarea. */
	public Usuario getResponsable() {
		return responsable;
	}
	/** @return La complejidad de la tarea. */
	public String getComplejidad() {
		return Complejidad;
	}
	/** @return La fecha de la tarea. */
	public String getFecha() {
		return Fecha;
	}
	/** @param estado El nuevo estado de la tarea. */
	public void setEstado(String estado) {
		Estado = estado;
	}
	/**
     * Genera una representación en cadena de la tarea con todos sus detalles.
     * @return Una cadena con la información detallada de la tarea.
     */
	@Override
	public String toString() {
		return ID + "  |  " + Tipo + "  |  " + Descripcion + "  |  " + Estado + "  |  " + responsable.getUsername() + "  |  " + Complejidad + "  |  " + Fecha;
	}
	/**
     * Genera una representación en cadena de la información básica de la tarea (ID, Tipo, Descripción, Estado).
     * @return Una cadena con la información básica de la tarea.
     */
	public String printInfoBasica() {
		return "ID: " + ID + "  |  Tipo: " + Tipo + "  |  Descripción: " + Descripcion + "  |  Estado: " + Estado;
	}
}
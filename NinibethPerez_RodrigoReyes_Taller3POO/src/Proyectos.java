import java.util.ArrayList;
/**
 * Clase que representa un Proyecto en el sistema.
 */
public class Proyectos {

	private String ID;
	private String Nombre;
	private Usuario responsable;
	private ArrayList<Tarea> Tareas = new ArrayList<>();
	
	/**
     * Constructor para la clase Proyectos.
     * @param iD El identificador único del proyecto.
     * @param nombre El nombre del proyecto.
     * @param responsable El usuario responsable del proyecto.
     */
	public Proyectos(String iD, String nombre, Usuario responsable) {
		super();
		ID = iD;
		Nombre = nombre;
		this.responsable = responsable;
	}
	/** @return El ID del proyecto. */
	public String getID() {
		return ID;
	}
	
	/** @return El nombre del proyecto. */
	public String getNombre() {
		return Nombre;
	}
	/** @return El responsable del proyecto. */
	public Usuario getResponsable() {
		return responsable;
	}
	/** @return La lista de tareas asociadas a este proyecto. */
	public ArrayList<Tarea> getTareas() {
		return Tareas;
	}
	
	/** @param t La tarea a agregar al proyecto. */
	public void agregarTarea(Tarea t) {
		this.Tareas.add(t);
	}
	
	/**
     * Genera una representación en cadena del proyecto, incluyendo una lista detallada de sus tareas.
     * @return Una cadena con la información completa del proyecto y sus tareas.
     */
	@Override
	public String toString() {
		return "PROYECTO: " + Nombre + " - ID: " + ID + " - Responsable:  " + responsable.getUsername() + "\n" +
				listaTareas();
	}
	
	/**
     * Genera una representación en cadena de la lista de tareas del proyecto.
     * @return Una cadena con el encabezado de las tareas y cada tarea en una línea.
     */
	public String listaTareas() {
		String texto = "-- Tareas --\n";
		texto += "  ID  |    Tipo    |         Descripción         |  Estado  |  Responsable  | Complejidad |  Fecha   \n";
		for (Tarea t : Tareas) {
			texto += t + "\n";
		}
		return texto;
	}
	
	/**
     * Genera una representación en cadena de la información básica del proyecto (ID, Nombre, Responsable).
     * @return Una cadena con la información básica del proyecto.
     */
	public String informacionBasica() {
		return "PROYECTO: " + Nombre + " | ID: " + ID + " | Responsable:  " + responsable.getUsername();
	}
}
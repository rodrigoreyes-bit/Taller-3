import java.util.ArrayList;

/**
 * Define la interfaz común para las diferentes
 * estrategias de asignación de prioridad de tareas (Patrón Strategy).
 */
public interface Estrategia {
	/**
     * Asigna prioridad a una lista de tareas según la implementación concreta de la estrategia.
     * @param tareas La lista de tareas a ordenar.
     * @return Una nueva lista de tareas ordenadas por prioridad.
     */
	public ArrayList<Tarea> asignarPrioridad(ArrayList<Tarea> tareas);
	
	/**
     * Retorna el tipo de estrategia de prioridad.
     * @return Una cadena que describe el tipo de estrategia.
     */
	public String Tipo();
}

import java.util.ArrayList;
/**
 * Implementación concreta de la interfaz Estrategia que prioriza las tareas
 * según su complejidad (Alta, Media, Baja).
 */
public class Estrategia_PorComplejidad implements Estrategia {
	/*
	 * Constructor por defecto
	 */
	public Estrategia_PorComplejidad() {
	}
	
	/**
     * Ordena las tareas dando prioridad a las de complejidad "Alta", luego "Media" y finalmente "Baja".
     * @param tareas La lista de tareas a ordenar.
     * @return La lista de tareas ordenada por complejidad.
     */
	public ArrayList<Tarea> asignarPrioridad(ArrayList<Tarea> tareas) {
		ArrayList<Tarea> alta = new ArrayList<>();
		ArrayList<Tarea> media = new ArrayList<>();
		ArrayList<Tarea> baja = new ArrayList<>();
		for (Tarea t : tareas) {
			switch (t.getComplejidad().toLowerCase()) {
			case "alta":
				alta.add(t);
				break;
				
			case "media":
				media.add(t);
				break;
				
			case "baja":
				baja.add(t);
				break;
			}
		}
		alta.addAll(media);
		alta.addAll(baja);
		return alta;
	}
	
	/**
     * Retorna el tipo de estrategia.
     * @return La cadena "Basada en complejidad".
     */
	public String Tipo() {
		return "Basada en complejidad";
	}
}

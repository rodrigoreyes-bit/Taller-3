import java.util.ArrayList;
/**
 * Implementación concreta de la interfaz Estrategia que prioriza las tareas
 * según su tipo/impacto (Bug, Feature, Documentacion).
 */
public class Estrategia_PorImpacto implements Estrategia {
	/*
	 * Constructor por defecto.
	 */
	public Estrategia_PorImpacto() {
	}
	
	/**
     * Ordena las tareas dando prioridad a los "Bug", luego a las "Feature" y finalmente a la "Documentación".
     * @param tareas La lista de tareas a ordenar.
     * @return La lista de tareas ordenada por impacto.
     */
	public ArrayList<Tarea> asignarPrioridad(ArrayList<Tarea> tareas) {
		ArrayList<Tarea> bug = new ArrayList<>();
		ArrayList<Tarea> feature = new ArrayList<>();
		ArrayList<Tarea> documentacion = new ArrayList<>();
		for (Tarea t : tareas) {
			switch (t.getTipo().toLowerCase()) {
			case "alta":
				bug.add(t);
				break;
			case "feature":
				feature.add(t);
				break;
			case "documentacion":
				documentacion.add(t);
				break;

			}
		}
		bug.addAll(feature);
		bug.addAll(documentacion);
		return bug;
	}
	
	/**
     * Retorna el tipo de estrategia.
     * @return La cadena "Basada en impacto".
     */
	public String Tipo() {
		return "Basada en impacto";
	}
}

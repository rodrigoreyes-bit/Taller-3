import java.util.ArrayList;
/**
 * Implementación concreta de la interfaz Estrategia que prioriza las tareas
 * según su fecha de entrega (más cercanas primero).
 */
public class Estrategia_PorFecha implements Estrategia {
	/*
	 * Constructor por defecto.
	 */
	public Estrategia_PorFecha() {
	}
	
	/**
     * Ordena la lista de tareas según su fecha de entrega de forma ascendente
     * (las fechas más antiguas primero). Utiliza un algoritmo de ordenamiento burbuja..
     *
     * @param tareas Lista de tareas a ordenar..
     * @return La misma lista recibida como parámetro, pero ordenada por fecha.
     */
	@Override
	public ArrayList<Tarea> asignarPrioridad(ArrayList<Tarea> tareas) {
		for (int i = 0; i < tareas.size() - 1; i++) {
			for (int j = 0; j < tareas.size() - 1 - i; j++) {
				if (mayor(tareas.get(j).getFecha(), tareas.get(j + 1).getFecha())) {
					Tarea auxiliar = tareas.get(j);
					tareas.set(j, tareas.get(j + 1));
					tareas.set(j + 1, auxiliar);
				}
			}
		}
		return tareas;
	}
	
	/**
     * Compara dos fechas en formato "AAAA-MM-DD" y determina si la primera
     * es cronológicamente mayor (posterior) que la segunda.
     *
     * @param f1 Primera fecha a comparar.
     * @param f2 Segunda fecha a comparar.
     * @return true si la fecha 1 es mayor a la fecha 2,
     *         retorna false en caso contrario.
     */
	private static boolean mayor(String f1, String f2) {
		String[] p1 = f1.split("-");
		String[] p2 = f2.split("-");
	
		if (Integer.valueOf(p1[0]) > Integer.valueOf(p2[0]))
			return true;
		if (Integer.valueOf(p1[0]) < Integer.valueOf(p2[0]))
			return false;
		if (Integer.valueOf(p1[1]) > Integer.valueOf(p2[1]))
			return true;
		if (Integer.valueOf(p1[1]) < Integer.valueOf(p2[1]))
			return false;

		return Integer.valueOf(p1[2]) > Integer.valueOf(p2[2]);
	}
	
	/**
     * Retorna el tipo de estrategia.
     * @return La cadena "Basada en fechas".
     */
	public String Tipo() {
		return "Basada en fechas";
	}

}

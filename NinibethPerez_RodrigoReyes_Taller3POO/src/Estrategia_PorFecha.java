import java.util.ArrayList;

public class Estrategia_PorFecha implements Estrategia {
	public Estrategia_PorFecha() {
	}

	@Override
	public ArrayList<Tarea> asignarPrioridad(ArrayList<Tarea> tareas) {

		for (int i = 0; i < tareas.size() - 1; i++) {
			for (int j = 0; j < tareas.size() - 1 - i; j++) {

				if (Mayor(tareas.get(j).getFecha(), tareas.get(j + 1).getFecha())) {
					Tarea auxiliar = tareas.get(j);
					tareas.set(j, tareas.get(j + 1));
					tareas.set(j + 1, auxiliar);
				}
			}
		}

		return tareas;
	}

	private static boolean Mayor(String f1, String f2) {
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
	
	public String Tipo() {
		return "Basada en fechas";
	}

}

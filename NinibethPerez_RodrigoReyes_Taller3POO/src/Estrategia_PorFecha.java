import java.util.ArrayList;

public class Estrategia_PorFecha implements Estrategia {

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
		int año1 = Integer.valueOf(p1[0]);
		int mes1 = Integer.valueOf(p1[1]);
		int dia1 = Integer.valueOf(p1[2]);
		int año2 = Integer.valueOf(p2[0]);
		int mes2 = Integer.valueOf(p2[1]);
		int dia2 = Integer.valueOf(p2[2]);
		if (año1 > año2) return true;
		if (año1 < año2) return false;
		if (mes1 > mes2)return true;
		if (mes1 < mes2)return false;

		return dia1 > dia2;
	}
	
}

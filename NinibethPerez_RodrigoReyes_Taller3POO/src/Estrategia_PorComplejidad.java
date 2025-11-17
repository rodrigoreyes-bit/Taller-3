import java.util.ArrayList;

public class Estrategia_PorComplejidad implements Estrategia {

	public Estrategia_PorComplejidad() {
	}

	public ArrayList<Tarea> asignarPrioridad(ArrayList<Tarea> tareas) {
		ArrayList<Tarea> Bug = new ArrayList<>();
		ArrayList<Tarea> Feature = new ArrayList<>();
		ArrayList<Tarea> Documentacion = new ArrayList<>();
		for (Tarea t : tareas) {

			switch (t.getTipo()) {

			case "Bug":
				Bug.add(t);
				break;
			case "Feature":
				Feature.add(t);
				break;
			case "Documentacion":
				Documentacion.add(t);
				break;

			}
		}
		Bug.addAll(Feature);
		Bug.addAll(Documentacion);

		return Bug;
	}
	public String Tipo() {
		return "Basada en complejidad";
	}
}

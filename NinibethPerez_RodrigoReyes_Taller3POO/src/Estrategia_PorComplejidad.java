import java.util.ArrayList;

public class Estrategia_PorComplejidad implements Estrategia {

	public Estrategia_PorComplejidad() {
	}
	
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
	
	public String Tipo() {
		return "Basada en complejidad";
	}
}

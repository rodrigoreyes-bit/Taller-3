import java.util.ArrayList;

public class Estrategia_PorImpacto implements Estrategia {

	public Estrategia_PorImpacto() {
	}
	
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
	
	public String Tipo() {
		return "Basada en impacto";
	}

}

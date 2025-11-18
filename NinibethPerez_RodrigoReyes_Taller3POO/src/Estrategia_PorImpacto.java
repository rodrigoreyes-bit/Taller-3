import java.util.ArrayList;

public class Estrategia_PorImpacto implements Estrategia {

	public Estrategia_PorImpacto() {
	}

	public ArrayList<Tarea> asignarPrioridad(ArrayList<Tarea> tareas) {
		ArrayList<Tarea> Alta = new ArrayList<>();
		ArrayList<Tarea> Media = new ArrayList<>();
		ArrayList<Tarea> Baja = new ArrayList<>();
		for (Tarea t : tareas) {

			switch (t.getComplejidad().toLowerCase()) {

			case "alta":
				Alta.add(t);
				break;
			case "media":
				Media.add(t);
				break;
			case "baja":
				Baja.add(t);
				break;

			}
		}
		Alta.addAll(Media);
		Media.addAll(Baja);

		return Alta;

		
	}
	public String Tipo() {
		return "Basada en impacto";
	}

}

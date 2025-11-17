import java.util.ArrayList;

public class Estrategia_PorImpacto implements Estrategia {

	public Estrategia_PorImpacto() {
	}

	public ArrayList<Tarea> asignarPrioridad(ArrayList<Tarea> tareas) {
		return tareas;
		
	}
	public String Tipo() {
		return "Basada en impacto";
	}

}

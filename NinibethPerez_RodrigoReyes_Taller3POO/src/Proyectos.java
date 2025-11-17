import java.util.ArrayList;

public class Proyectos {

	private String ID;
	private String Nombre;
	private Usuario responsable;
	private ArrayList<Tarea> Tareas = new ArrayList<>();

	public Proyectos(String iD, String nombre, Usuario responsable) {
		super();
		ID = iD;
		Nombre = nombre;
		this.responsable = responsable;
	}

	public String getID() {
		return ID;
	}


	public String getNombre() {
		return Nombre;
	}

	public Usuario getResponsable() {
		return responsable;
	}

	public ArrayList<Tarea> getTareas() {
		return Tareas;
	}


	public void setTareas(ArrayList<Tarea> tareas) {
		Tareas = tareas;
	}

	public void agregarTarea(Tarea t) {
		this.Tareas.add(t);
	}
	
	@Override
	public String toString() {
		return "PROYECTO: " + Nombre + " - ID: " + ID + " - Responsable:  " + responsable.getUsername() + "\n" +
				listaTareas();
	}
	
	public String listaTareas() {
		String texto = "-- Tareas --\n";
		texto += "  ID  |    Tipo    |         Descripción         |  Estado  |  Responsable  | Complejidad |  Fecha   \n";
		for (Tarea t : Tareas) {
			texto += t + "\n";
		}
		return texto;
	}
	
	public String informacionBasica() {
		return "PROYECTO: " + Nombre + " | ID: " + ID + " | Responsable:  " + responsable.getUsername();
	}
}
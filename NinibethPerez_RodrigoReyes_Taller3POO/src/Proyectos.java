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

	public void setID(String iD) {
		ID = iD;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Usuario getResponsable() {
		return responsable;
	}

	public void setResponsable(Usuario responsable) {
		this.responsable = responsable;
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
		return "Proyectos [ID=" + ID + ", Nombre=" + Nombre + ", responsable=" + responsable + ", Tareas=" + Tareas
				+ "]";
	}
	
	


}

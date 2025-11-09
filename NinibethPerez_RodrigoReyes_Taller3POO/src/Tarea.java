
public class Tarea {

	private Proyectos Proyecto;
	private String ID;
	private String Tipo;
	private String Descripcion;
	private String Estado;
	private Usuario responsable;
	private String Complejidad;
	private String Fecha;
	
	public Tarea(Proyectos proyecto, String iD, String tipo, String descripcion, String estado, Usuario responsable,
			String complejidad, String fecha) {
		super();
		Proyecto = proyecto;
		ID = iD;
		Tipo = tipo;
		Descripcion = descripcion;
		Estado = estado;
		this.responsable = responsable;
		Complejidad = complejidad;
		Fecha = fecha;
	}

	

}

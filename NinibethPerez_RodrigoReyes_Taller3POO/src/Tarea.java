
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
	
	public Proyectos getProyecto() {
		return Proyecto;
	}

	public String getID() {
		return ID;
	}

	public String getTipo() {
		return Tipo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public String getEstado() {
		return Estado;
	}

	public Usuario getResponsable() {
		return responsable;
	}

	public String getComplejidad() {
		return Complejidad;
	}

	public String getFecha() {
		return Fecha;
	}
	
	public void setProyecto(Proyectos proyecto) {
		Proyecto = proyecto;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public void setResponsable(Usuario responsable) {
		this.responsable = responsable;
	}

	public void setComplejidad(String complejidad) {
		Complejidad = complejidad;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public void accept(Visitor v) {
		v.EvaluarTarea(this);
	}
	@Override
	public String toString() {
		return ID + "  |  " + Tipo + "  |  " + Descripcion + "  |  " + Estado + "  |  " + responsable.getUsername() + "  |  " + Complejidad + "  |  " + Fecha;
	}
	
	public String printInfoBasica() {
		return "ID: " + ID + "  |  Tipo: " + Tipo + "  |  Descripción: " + Descripcion + "  |  Estado: " + Estado;
	}
}
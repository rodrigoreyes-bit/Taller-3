
public interface Sistema {

	public void LecturaUsuarios(String[] info);

	public void LecturaProyectos(String[] info);

	public void LecturaTareas(String[] info);

	public void VerListaProyectosTareas_Admin();

	public void AgregarProyecto_Admin(String id, String nombre, String responsable);

	public void EliminarProyecto_Admin(String id);

	public void AgregarTarea_Admin(String proyectoId, String idTarea, String tipo, String descripcion, String estado,
			String userResponsable, String complejidad, String fecha);

	public void EliminarTarea_Admin(String id);

	public String AsignarPrioridades_Strategy_Admin(int opcion);

	public void GenerarReporte_Admin();

	public void MostrarListaDeProyectosBasica();

	public void VerTareasAsignadas_Usuario(Usuario usuario);

	public String ActualizarEstadoTarea_Usuario(String id, int opcion);

	public void AplicarVisitor_Usuario(Visitor v);
}
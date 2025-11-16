import java.io.FileNotFoundException;

public interface Sistema {
	
	public void LecturaUsuarios(String[] info); 
	public void LecturaProyectos(String[] info); 
	public void LecturaTareas(String[] info);
	
	public void VerListaProyectosTareas_Admin();
	public void AgregarProyecto_Admin();
	public void EliminarProyecto_Admin(Proyectos proyecto);
	public void AgregarTarea_Admin();
	public void EliminarTarea_Admin(Tarea tarea);
	public void AsignarPrioridades_Strategy_Admin(Proyectos proyecto);
	public void GenerarReporte_Admin(Proyectos proyecto);
	
	public void MostrarListaDeProyectos_Usuario();
	public void VerTareasAsignadas_Usuario(Usuario usuario);
	public void ActualizarEstadoTarea_Usuario();
	public void AplicarVisitor_Usuario(); //https://www.youtube.com/watch?v=kyquNfJ-rME
	

	
	

}

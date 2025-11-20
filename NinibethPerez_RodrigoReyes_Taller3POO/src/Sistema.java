/**
 * Interfaz principal del sistema de proyectos y tareas.
 * Define las operaciones fundamentales que se pueden realizar en el sistema implementando funcionalidades de lectura, manejo de datos como los Proyectos y las Tareas,
 * asignación de estrategias de trabajo (Strategy) y aplicación de funciones modificables de visita (Visitor).
 */
public interface Sistema {
	
	/**
	 * Procesa y carga la información de un nuevo usuario de la clase Usuario en el sistema.
	 * @param info Un array de cadenas con la información necesaria para crear un Usuario.
	 */
	public void LecturaUsuarios(String[] info);
	/**
	 * Procesa y carga la información de un nuevo proyecto de la clase Proyectos en el sistema.
	 * @param info Un array de cadenas con la información necesaria para crear un Proyectos.
	 */
	public void LecturaProyectos(String[] info);
	/**
	 * Procesa y carga la información de una nueva tarea de la clase Tarea en el sistema.
	 * @param info Un array de cadenas con la información necesaria para crear una Tarea.
	 */
	public void LecturaTareas(String[] info);
	/**
	 * Muestra por consola la lista completa de proyectos junto a sus tareas asociadas.
	 */
	public void VerListaProyectosTareas_Admin();
	/**
	 * Agrega un nuevo proyecto al sistema y lo asigna al usuario responsable.
	 * La función considera la posibilidad de errores de typeo y de logica mediante funciones especificas de checkeo.
	 * @param id El identificador único del proyecto.
	 * @param nombre El nombre del proyecto.
	 * @param responsable El nombre de usuario del responsable.
	 */
	public void AgregarProyecto_Admin(String id, String nombre, String responsable);
	/**
	 * Elimina un proyecto por su ID junto con las referencias a sus tareas y responsables.
	 * La función prioriza revisar si el proyecto existe antes de eliminarlo de la lista array.
	 * @param id El identificador único del proyecto a eliminar.
	 */
	public void EliminarProyecto_Admin(String id);
	/**
	 * Agrega una nueva tarea a un proyecto específico.
	 * Mediante funciones la función revisa que la información escrita por consola es valida para el contexto de las tareas.
	 * @param proyectoId El ID del proyecto al que se asignará la tarea.
	 * @param idTarea El ID único de la tarea.
	 * @param tipo El tipo de tarea (Bug, Feature, Documentacion).
	 * @param descripcion La descripción de la tarea.
	 * @param estado El estado de la tarea (Pendiente, En progreso, Completada).
	 * @param userResponsable El nombre de usuario del responsable.
	 * @param complejidad La complejidad de la tarea (Alta, Media, Baja).
	 * @param fecha La fecha de la tarea (formato YYYY-MM-DD).
	 */
	public void AgregarTarea_Admin(String proyectoId, String idTarea, String tipo, String descripcion, String estado, String userResponsable, String complejidad, String fecha);
	/**
	 * Elimina una tarea por su ID.
	 * La función prioriza revisar si la tarea existe antes de eliminarlo de la lista array.
	 * @param id El identificador único de la tarea a eliminar.
	 */
	public void EliminarTarea_Admin(String id);
	/**
	 * Cambia la estrategia utilizada para asignar prioridades a las tareas.
	 * @param opcion El código de la estrategia a aplicar (1: por Fecha, 2: por Impacto, 3: por Complejidad).
	 * @return Un mensaje indicando el resultado de la operación.
	 */
	public String AsignarPrioridades_Strategy_Admin(int opcion);
	/**
	 * Genera un reporte que incluye los proyectos y sus tareas priorizadas según la estrategia actual.
	 * El reporte se guarda en un archivo reportes.txt.
	 */
	public void GenerarReporte_Admin();
	/**
	 * Muestra en consola la información básica de todos los proyectos.
	 */
	public void MostrarListaDeProyectosBasica();
	/**
	 * Muestra las tareas asignadas al usuario especificado.
	 * @param usuario El objeto Usuario cuyas tareas asignadas se quieren ver.
	 */
	public void VerTareasAsignadas_Usuario(Usuario usuario);
	/**
	 * Actualiza el estado de una tarea específica por su ID.
	 * @param id El identificador único de la tarea.
	 * @param opcion El código del nuevo estado a aplicar (1: Pendiente, 2: En progreso, 3: Completada).
	 * @return Un mensaje indicando el resultado de la operación.
	 */
	public String ActualizarEstadoTarea_Usuario(String id, int opcion);
	/**
	 * Aplica el patrón Visitor a todas las tareas de los proyectos para realizar operaciones específicas según el tipo de tarea.
	 * @param v La implementación concreta de  Visitor a aplicar.
	 */
	public void AplicarVisitor_Usuario(Visitor v);
}

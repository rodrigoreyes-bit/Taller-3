import java.util.ArrayList;

/**
 * Interfaz Factory que define los métodos para la creación de los objetos del sistema.
 */
public class Factory {
	private static Factory Instancia_Unica;
	
	/** Constructor privado para el patrón Singleton. */
    private Factory() { }

    /**
     * Obtiene la instancia única de Factory (Patrón Singleton).
     * @return La instancia única de Factory.
     */
	public static Factory InstanciarFactory() {
		if (Instancia_Unica == null) {
			Instancia_Unica = new Factory();
		}
		return Instancia_Unica;
	}
	
	/**
     * Crea una nueva instancia de Usuario.
     * @param Info Un array de cadenas con la información del usuario (Username, Password, Rol).
     * @return Una nueva instancia de Usuario.
     */
	public Usuario Crear_Usuario(String[] Info) {
		Usuario u = new Usuario(Info[0], Info[1], Info[2]);
		return u;
	}

	/**
     * Crea una nueva instancia de Proyectos.
     * Asigna el responsable buscando en la lista de usuarios.
     * @param Info Un array de cadenas con la información del proyecto (ID, Nombre, Username del Responsable).
     * @param usuarios La lista de usuarios disponibles para buscar al responsable.
     * @return Una nueva instancia de Proyectos.
     */
	public Proyectos Crear_Proyecto(String[] Info, ArrayList<Usuario> usuarios) {
		Usuario usuario = null;
		for (Usuario u : usuarios) {
			if (u.getUsername().equals(Info[2])) {
				usuario = u;
				break;
			}
		}
		Proyectos p = new Proyectos(Info[0], Info[1], usuario);
		usuario.agregarProyecto(p);
		return p;
	}
	
	/**
     * Crea una nueva instancia de Tarea.
     * Asocia el proyecto y el responsable buscando en las listas.
     * @param Info Un array de cadenas con la información de la tarea.
     * @param usuarios La lista de usuarios disponibles.
     * @param proyectos La lista de proyectos disponibles.
     * @return Una nueva instancia de Tarea.
     */
	public Tarea Crear_Tarea(String[] Info, ArrayList<Usuario> usuarios, ArrayList<Proyectos> proyectos) {
		Proyectos proyecto = null;
		Usuario usuario = null;
		for (Proyectos p : proyectos) {
			if (p.getID().equals(Info[0])) {
				proyecto = p;
				break;
			}
		}
		for (Usuario u : usuarios) {
			if (u.getUsername().equals(Info[5])) {
				usuario = u;
				break;
			}
		}
		// Info[0]: Proyecto ID, Info[1]: Tarea ID, Info[2]: Tipo, Info[3]: Descripción, Info[4]: Estado, Info[5]: User Resp, Info[6]: Complejidad, Info[7]: Fecha
		Tarea t = new Tarea(proyecto, Info[1], Info[2], Info[3], Info[4], usuario, Info[6], Info[7]);
		usuario.agregarTarea(t);
		proyecto.agregarTarea(t);
		return t;
	}
}
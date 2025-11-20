import java.util.ArrayList;
/**
* Define los métodos de creación de usuarios, proyectos y tareas bajo el patrón Factory.
*
* PRE:
* - Los arreglos de información contienen los valores necesarios en el orden correcto.
* - Las listas de usuarios y proyectos contienen elementos válidos.
*
* POST:
* - Retorna instancias de Usuario, Proyectos o Tarea completamente inicializadas.
*
* Métodos:
* @param Info Arreglo con la información necesaria para construir el objeto.
* @param usuarios Lista de usuarios disponibles.
* @param proyectos Lista de proyectos disponibles.
*/
public class Factory {
	private static Factory Instancia_Unica;

	private Factory() { }

	public static Factory InstanciarFactory() {
		if (Instancia_Unica == null) {
			Instancia_Unica = new Factory();
		}
		return Instancia_Unica;
	}
	
	public Usuario Crear_Usuario(String[] Info) {
		Usuario u = new Usuario(Info[0], Info[1], Info[2]);
		return u;
	}

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

		Tarea t = new Tarea(proyecto, Info[1], Info[2], Info[3], Info[4], usuario, Info[6], Info[7]);
		usuario.agregarTarea(t);
		proyecto.agregarTarea(t);
		return t;
	}
}
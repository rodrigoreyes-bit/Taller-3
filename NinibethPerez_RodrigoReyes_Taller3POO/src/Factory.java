import java.util.ArrayList;

public class Factory {

	public Usuario Crear_Usuario(String[] Info) {
		Usuario u = new Usuario(Info[0], Info[1], Info[2]);
		return u;

	}

	public Proyectos Crear_Proyecto(String[] Info, ArrayList<Usuario> usuarios) {
		Usuario usuario = null;
		for (Usuario u : usuarios) {

			if (u.getUsername().equals(Info[2])) {
				usuario = u;
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
			}
		}
		for (Usuario u : usuarios) {

			if (u.getUsername().equals(Info[5])) {
				usuario = u;
			}
		}

		Tarea t = new Tarea(proyecto, Info[1], Info[2], Info[3], Info[4], usuario, Info[6], Info[7]);
		usuario.agregarTarea(t);
		proyecto.agregarTarea(t);
		return t;
	}
}
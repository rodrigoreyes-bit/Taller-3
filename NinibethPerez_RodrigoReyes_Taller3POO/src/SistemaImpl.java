import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class SistemaImpl implements Sistema {

	public Factory f = Factory.InstanciarFactory();
	public ArrayList<Usuario> usuarios = new ArrayList<>();
	public ArrayList<Proyectos> proyectos = new ArrayList<>();
	public ArrayList<Tarea> tareas = new ArrayList<>();
	public Estrategia estrategia = new Estrategia_PorComplejidad();

	private static SistemaImpl Instancia_Unica;

	private SistemaImpl() {
	}

	public static SistemaImpl InstanciarSistemaImpl() {
		if (Instancia_Unica == null) {
			Instancia_Unica = new SistemaImpl();
		}
		return Instancia_Unica;
	}

	@Override
	public void LecturaUsuarios(String[] info) {
		usuarios.add(f.Crear_Usuario(info));

	}

	@Override
	public void LecturaProyectos(String[] info) {
		proyectos.add(f.Crear_Proyecto(info, usuarios));

	}

	@Override
	public void LecturaTareas(String[] info) {
		tareas.add(f.Crear_Tarea(info, usuarios, proyectos));
	}

	@Override
	public void VerListaProyectosTareas_Admin() {
		System.out.println("=== PROYECTOS ===");

		for (Proyectos p : proyectos) {
			System.out.println(p);
		}
	}

	@Override
	public void AgregarProyecto_Admin(String id, String nombre, String resp) {
		Usuario responsable = null;
		for (Usuario u : usuarios) {
			if (u.getUsername().equals(resp)) {
				responsable = u;
				break;
			}
		}

		if (responsable == null) {
			System.out.println("Usuario no encontrado");
			return;
		}
		String[] info = { id, nombre, resp };
		Proyectos p = f.Crear_Proyecto(info, usuarios);
		proyectos.add(p);
		responsable.agregarProyecto(p);

		System.out.println("Proyecto agregado con éxito!!");
	}

	@Override
	public void EliminarProyecto_Admin(String id) {
		Proyectos proyecto = null;
		for (Proyectos p : proyectos) {
			if (p.getID().equals(id)) {
				proyecto = p;
				p.getResponsable().getProyectosResponsable().remove(p);
				proyectos.remove(p);
				break;
			}
		}

		if (proyecto == null) {
			System.out.println("Proyecto no encontrado.");
			return;
		}

		System.out.println("Proyecto eliminado con éxito junto a sus tareas.");

	}

	@Override
	public void AgregarTarea_Admin(String proyectoId, String idTarea, String tipo, String descripcion, String estado,
			String userResponsable, String complejidad, String fecha) {

		Proyectos proyecto = null;
		for (Proyectos p : proyectos) {
			if (p.getID().equals(proyectoId)) {
				proyecto = p;
				break;
			}
		}

		if (proyecto == null) {
			System.out.println("ID de proyecto no encontrado.");
			return;
		}

		Usuario responsable = null;
		for (Usuario u : usuarios) {
			if (u.getUsername().equals(userResponsable)) {
				responsable = u;
				break;
			}
		}

		if (responsable == null) {
			System.out.println("Responsable no encontrado.");
			return;
		}
		String c = complejidad.toLowerCase();
		if (!c.equals("alta") && !c.equals("media") && !c.equals("baja")) {
			System.out.println("Ingrese una complejidad válida.");
			return;
		}
		
		if (fecha.split("-").length != 3) {
			System.out.println("Ingrese una fecha válida.");
			return;
		}

		String[] info = { proyectoId, idTarea, tipo, descripcion, estado, userResponsable, complejidad, fecha };
		Tarea t = f.Crear_Tarea(info, usuarios, proyectos);
		System.out.println(t);
		this.tareas.add(t);

		System.out.println("Tarea agregada con éxito!!");

	}

	@Override
	public void EliminarTarea_Admin(String id) {
		Tarea tarea = null;
		for (Tarea t : tareas) {
			if (t.getID().equals(id)) {
				tarea = t;
			}
		}

		if (tarea == null) {
			System.out.println("La tarea no existe.");
			return;
		}

		tarea.getProyecto().getTareas().remove(tarea);
		tarea.getResponsable().getTareasResponsable().remove(tarea);
		tareas.remove(tarea);

		System.out.println("Tarea eliminada con éxito!");

	}

	@Override
	public void MostrarListaDeProyectosBasica() {
		for (Proyectos p : proyectos) {
			System.out.println(p.informacionBasica());
		}

	}

	public void MostrarInfoTareas() {
		for (Tarea t : tareas) {
			System.out.println(t);
		}
	}

	@Override
	public void VerTareasAsignadas_Usuario(Usuario usuario) {
		for(Tarea t: tareas) {
			if(t.getResponsable().equals(usuario)) {
				System.out.println(t);
			}
		}
	}

	@Override
	public String ActualizarEstadoTarea_Usuario(String id, int opcion) {
		Tarea tarea = null;
		for(Tarea t: tareas) {
			if(t.getID().contentEquals(id)) {
				tarea = t;
			}
		}
		
		switch(opcion) {
		case 1:
			if(tarea.getEstado() != "Pendiente") {
				tarea.setEstado("Pendiente");
				return "Estado de tarea cambiada a Pendiente";
			}
			break;
		case 2:
			if(tarea.getEstado() != "En progreso") {
				tarea.setEstado("En progreso");
				return "Estado de tarea cambiada a En progreso";
			}
			
			break;
		case 3:
			if(tarea.getEstado() != "Completada") {
				tarea.setEstado("Completada");
				return "Estado de tarea cambiada a Completada";
			}
			break;
		}
		return "Error | Estado sobrescrito, intente cambiar a un estado de progreso distinto";

	}

	@Override
	public void AplicarVisitor_Usuario(Visitor v) {
		for(Proyectos p: proyectos) {
			System.out.println(p.getID() + ":");
			for(Tarea t: tareas) {
				t.accept(v);
			}
		}
	}

	@Override
	public String AsignarPrioridades_Strategy_Admin(int opcion) {
		switch (opcion) {

		case 1:
			if (!(estrategia instanceof Estrategia_PorFecha)) {
				Estrategia estrategia_Nueva = new Estrategia_PorFecha();
				this.estrategia = estrategia_Nueva;
				return "Estrategia cambiada a por Fecha";
			}
			break;
		case 2:
			if (!(estrategia instanceof Estrategia_PorImpacto)) {
				Estrategia estrategia_Nueva = new Estrategia_PorImpacto();
				this.estrategia = estrategia_Nueva;
				return "Estrategia cambiada a por Impacto";
			}
			break;
		case 3:
			if (!(estrategia instanceof Estrategia_PorComplejidad)) {
				Estrategia estrategia_Nueva = new Estrategia_PorComplejidad();
				this.estrategia = estrategia_Nueva;
				return "Estrategia cambiada a por Complejidad";
			}
			break;

		}
		return "Error | Estrategia sobrescrita, intente cambiar a una estrategia distinta a la que posee";

	}

	public String getEstrategia() {
		return estrategia.Tipo();
	}

	@Override
	public void GenerarReporte_Admin() {
		try {
			FileWriter escribir = new FileWriter("reportes.txt", true);

			for (Proyectos p : proyectos) {
				escribir.write("------------------------------------------\n");
				estrategia.asignarPrioridad(p.getTareas());
				escribir.write(p.toString());
			}

			escribir.close();
			System.out.println("Reporte creado con éxito en el archivo reportes.txt.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Usuario CheckDeInformacion(String usuario, String contraseña) {
		for(Usuario u: usuarios) {
			if(u.getUsername().equals(usuario)) {
				if(u.getPassword().equals(contraseña)) {
					System.out.println("Bienvenido de vuelta " + u.getUsername());
					return u;
				}
			}
		}
		return null;
		
	}
}
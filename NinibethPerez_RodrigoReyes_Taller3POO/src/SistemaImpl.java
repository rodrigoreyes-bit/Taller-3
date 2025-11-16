import java.util.ArrayList;

public class SistemaImpl implements Sistema {
	
	public FactoryImpl f = FactoryImpl.InstanciarFactoryImpl();
	public ArrayList<Usuario> usuarios = new ArrayList<>();
	public ArrayList<Proyectos> proyectos = new ArrayList<>();
	public ArrayList<Tarea> tareas = new ArrayList<>();
	
	private static SistemaImpl Instancia_Unica;

	private SistemaImpl() {}

	public static SistemaImpl InstanciarSistemaImpl() {
		if (Instancia_Unica == null) {
			Instancia_Unica = new SistemaImpl();
			System.out.println("owo");
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
	
	public void lectura() {
		for(Usuario u: usuarios) {
			System.out.println(u);
		}
		for(Proyectos p: proyectos) {
			System.out.println(p);
		}
		for(Tarea t: tareas) {
			System.out.println(t);
		}
	}

	@Override
	public void VerListaProyectosTareas_Admin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void AgregarProyecto_Admin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void AgregarTarea_Admin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void EliminarTarea_Admin(Tarea tarea) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MostrarListaDeProyectos_Usuario() {
		// TODO Auto-generated method stub

	}

	@Override
	public void VerTareasAsignadas_Usuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ActualizarEstadoTarea_Usuario() {
		// TODO Auto-generated method stub

	}

	@Override
	public void AplicarVisitor_Usuario() {
		// TODO Auto-generated method stub

	}

	@Override
	public void EliminarProyecto_Admin(Proyectos proyecto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AsignarPrioridades_Strategy_Admin(Proyectos proyecto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void GenerarReporte_Admin(Proyectos proyecto) {
		// TODO Auto-generated method stub
		
	}

}

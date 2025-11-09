import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaImpl implements Sistema {
	
	public File file;
	public Scanner t;
	public Scanner s = new Scanner(System.in);
	public FactoryImpl f = FactoryImpl.InstanciarFactoryImpl();
	public ArrayList<Usuario> usuarios = new ArrayList<>();
	public ArrayList<Proyectos> proyectos = new ArrayList<>();
	public ArrayList<Tarea> tareas = new ArrayList<>();
	
	private static SistemaImpl Instancia_Unica;

	private SistemaImpl() {}

	public static SistemaImpl InstanciarSistemaImpl() {
		if (Instancia_Unica == null) {
			Instancia_Unica = new SistemaImpl();
			System.out.println("");
		}

		return Instancia_Unica;

	}

	@Override
	public void LecturaUsuarios() throws FileNotFoundException {
		file = new File("usuarios.txt");
		t = new Scanner(file);
		
		while (t.hasNextLine()) {
			usuarios.add(f.Crear_Usuario(t.nextLine().split("\\|")));
		}
	}

	@Override
	public void LecturaProyectos() throws FileNotFoundException {
		file = new File("proyectos.txt");
		t = new Scanner(file);

		while (t.hasNextLine()) {
			System.out.println("h");
			proyectos.add(f.Crear_Proyecto(t.nextLine().split("\\|"), usuarios));

		}
	}

	@Override
	public void LecturaTareas() throws FileNotFoundException {
		file = new File("tareas.txt");
		t = new Scanner(file);

		while (t.hasNextLine()) {
			tareas.add(f.Crear_Tarea(t.nextLine().split("\\|"), usuarios, proyectos));
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

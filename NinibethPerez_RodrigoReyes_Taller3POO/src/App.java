
/* Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
	public static File file;
	public static Scanner t;
	public Scanner s = new Scanner(System.in);
	public static SistemaImpl sistema = SistemaImpl.InstanciarSistemaImpl();

	public static void main(String[] args) throws FileNotFoundException {

		LecturaUsuarios();
		LecturaProyectos();
		LecturaTareas();
		sistema.lectura();
	}

	private static void LecturaTareas() throws FileNotFoundException {
		file = new File("tareas.txt");
		t = new Scanner(file);
		
		while (t.hasNextLine()) {
			sistema.LecturaTareas(t.nextLine().split("\\|"));
		}
	}

	private static void LecturaProyectos() throws FileNotFoundException {
		file = new File("proyectos.txt");
		t = new Scanner(file);
		
		while (t.hasNextLine()) {
			sistema.LecturaProyectos(t.nextLine().split("\\|"));
		}

	}

	private static void LecturaUsuarios() throws FileNotFoundException {
		file = new File("usuarios.txt");
		t = new Scanner(file);
		
		while (t.hasNextLine()) {
			sistema.LecturaUsuarios(t.nextLine().split("\\|"));
		}
	}

}

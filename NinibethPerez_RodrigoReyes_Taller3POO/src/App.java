
/* Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Clase principal que contiene el punto de entrada de la aplicación
 * y maneja la interacción del usuario a través de menús.
 * Implementa el patrón Singleton para el acceso al sistema.
 */

public class App {
	public static File file;
	public static Scanner scanArch;
	public static Scanner scan = new Scanner(System.in);
	public static SistemaImpl sistema = SistemaImpl.InstanciarSistemaImpl();
	public static Usuario usuario;
	public static Visitor visitor = new VisitorAcciones();

	/**
    * Punto de entrada principal de la aplicación.
    * Carga los datos iniciales y luego inicia el proceso de Login.
	* @param args Argumentos de la línea de comandos.
     */

	public static void main(String[] args) throws FileNotFoundException {

		LecturaUsuarios();
		LecturaProyectos();
		LecturaTareas();
		Login();
	}
	
	/**
     * Maneja el proceso de inicio de sesión del usuario.
     * Solicita nombre de usuario y contraseña hasta que el login sea exitoso o el usuario escriba 'exit'.
     * Redirige al menú de Administrador o Usuario/Colaborador.
     */
	private static void Login() {

		Usuario usuarioLog = null;
		do {
			System.out.println("Ingrese su nombre de usuario.");
			System.out.print(">> ");
			String usuario = scan.nextLine();
			System.out.println("Ingrese su contraseña.");
			System.out.print(">> ");
			String contraseña = scan.nextLine();

			usuarioLog = sistema.CheckDeInformacion(usuario, contraseña);

			if (usuarioLog == null) {
				System.out.println("Usuario o contraseña incorrectos. Intente de nuevo.\n");
			}
		} while (usuarioLog == null);
		
		switch (usuarioLog.getRol().toLowerCase()) {
		case "administrador":
			menuAdmin();
			break;
		case "colaborador":
			menuUsuario();
			break;
		}
	}
	
	/**
     * Lee las tareas desde el archivo "tareas.txt" y las carga en el sistema.
     * Se espera que el archivo use '|' como separador de campos.
     * @throws FileNotFoundException Si el archivo "tareas.txt" no se encuentra.
     */
	private static void LecturaTareas() throws FileNotFoundException {
		file = new File("tareas.txt");
		scanArch = new Scanner(file);
		while (scanArch.hasNextLine()) {
			sistema.LecturaTareas(scanArch.nextLine().split("\\|"));
		}
	}
	
	/**
     * Lee los proyectos desde el archivo "proyectos.txt" y los carga en el sistema.
     * Se espera que el archivo use '|' como separador de campos.
     * @throws FileNotFoundException Si el archivo "proyectos.txt" no se encuentra.
     */
	private static void LecturaProyectos() throws FileNotFoundException {
		file = new File("proyectos.txt");
		scanArch = new Scanner(file);
		while (scanArch.hasNextLine()) {
			sistema.LecturaProyectos(scanArch.nextLine().split("\\|"));
		}
	}
	
	/**
     * Lee los usuarios desde el archivo "usuarios.txt" y los carga en el sistema.
     * Se espera que el archivo use '|' como separador de campos.
     * @throws FileNotFoundException Si el archivo "usuarios.txt" no se encuentra.
     */
	private static void LecturaUsuarios() throws FileNotFoundException {
		file = new File("usuarios.txt");
		scanArch = new Scanner(file);
		while (scanArch.hasNextLine()) {
			sistema.LecturaUsuarios(scanArch.nextLine().split("\\|"));
		}
	}
	
	/**
     * Muestra y maneja el menú de opciones para el usuario con rol de Administrador.
     */
	private static void menuAdmin(){
		//En caso que el usuario ingresado tenga el rol Admin se abre este menú de opciones.
		scan = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.println("\n--- MENÚ ADMIN ---");
            System.out.println("1. Ver lista completa de proyectos y tareas");
            System.out.println("2. Agregar o eliminar un proyecto");
            System.out.println("3. Agregar o eliminar una tarea de un proyecto");
            System.out.println("4. Asignar prioridades");
            System.out.println("5. Generar reporte de proyectos");
            System.out.println("6. Cerrar sesión");
            System.out.println("7. Detener sistema\n");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.valueOf(scan.nextLine());

            switch (opcion) {
                case 1:
                	sistema.VerListaProyectosTareas_Admin();
                	break;
                	
                case 2:
                	System.out.println("\n¿Qué quiere hacer?");
                	System.out.println("1. Agregar un proyecto");
                	System.out.println("2. Eliminar un proyecto");
                	System.out.print(">> ");
                	int eleccion = Integer.valueOf(scan.nextLine());
                	
                	if (eleccion == 1) {
                		scan = new Scanner(System.in);
            		    System.out.print("Ingrese nombre del proyecto: ");
            		    String nombre = scan.nextLine();

            		    System.out.print("Ingrese username del responsable: ");
            		    String resp = scan.nextLine();
            		    
            		    System.out.print("Ingrese el ID del proyecto: ");
            		    String ID = scan.nextLine();
            		    
            		    sistema.AgregarProyecto_Admin(ID, nombre, resp);
            		    
                	} else {
                		sistema.MostrarListaDeProyectosBasica();
                		System.out.print("Ingrese el ID del proyecto que desea eliminar: ");
                	    String idBuscado = scan.nextLine();
                	    sistema.EliminarProyecto_Admin(idBuscado);
                	}
                	break;
                	
                case 3: 
                	System.out.println("\n¿Qué quiere hacer?");
                	System.out.println("1. Agregar una tarea");
                	System.out.println("2. Eliminar una tarea");
                	System.out.print(">> ");
                	eleccion = Integer.valueOf(scan.nextLine());
                	
                	if (eleccion == 1) {
                		sistema.MostrarListaDeProyectosBasica();
                		scan = new Scanner(System.in);
            		    System.out.print("\nIngrese el ID del proyecto al que desea agregar la tarea: ");
            		    String idProyecto = scan.nextLine();
            		    System.out.print("Ingrese el ID de la tarea: ");
            		    String ID = scan.nextLine();
            		    System.out.print("Ingrese el tipo (Bug | Feature | Documentacion): ");
            		    String tipo = scan.nextLine();
            		    System.out.print("Ingrese la descripción: ");
            		    String desc = scan.nextLine();
            		    System.out.print("Ingrese el estado (Pendiente | En Proceso | Completada): ");
            		    String estado = scan.nextLine();
            		    System.out.print("Ingrese el username del responsable: ");
            		    String userResp = scan.nextLine();
            		    System.out.print("Ingrese la complejidad (Alta | Media | Baja): ");
            		    String complejidad = scan.nextLine();
            		    System.out.print("Ingrese la fecha ([Año-Mes-Dia]. Ejemplo: 2025-08-01): ");
            		    String fecha = scan.nextLine();
            		    
            		    sistema.AgregarTarea_Admin(idProyecto, ID, tipo, desc, estado, userResp, complejidad, fecha);
            		    
            		    
                	} else {
                		sistema.MostrarInfoTareas();
                		System.out.print("Ingrese el ID de la tarea a eliminar: ");
            		    String idTarea = scan.nextLine();
            		    sistema.EliminarTarea_Admin(idTarea);
                	}
                	break;
                
                case 4:
                	System.out.println("== Cambio de estrategia en tiempo real ==");
                	System.out.println("Su estrategia de trabajo actual es de tipo: " + sistema.getEstrategia());
                	System.out.println("1) Por fecha de creación\n2) Por impacto\n3) Por complejidad\n");
                	System.out.print("> ");
            		int estrategia = Integer.valueOf(scan.nextLine());
            		System.out.println(sistema.AsignarPrioridades_Strategy_Admin(estrategia));
                	break;
                	
                case 5:
                	sistema.GenerarReporte_Admin();
                	break;
                	
                case 6: 
                	System.out.println("Sesión cerrada...");
                	System.out.println("Saliendo del menú admin...");
                	Login();
                	return;
                case 7:
                	System.out.println("Apagando el sistema...");
                	return;
                default: 
                	System.out.println("Opción inválida.");
                	break;
            }
        } while (opcion != 7);
    }
	
	/**
     * Muestra y maneja el menú de opciones para el usuario con rol de Usuario.
     */
	private static void menuUsuario() {
		//En caso que el usuario ingresado tenga el rol User se abre este menu de opciones.
		scan = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.println("\n--- MENÚ USUARIO ---");
            System.out.println("1. Ver proyectos disponibles");
            System.out.println("2. Ver tareas asignadas");
            System.out.println("3. Actualizar estado de una tarea");
            System.out.println("4. Checkeo de acciones requeridas sobre una tarea");
            System.out.println("5. Cerrar sesión");
            System.out.println("6. Detener sistema\n");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.valueOf(scan.nextLine());

            switch (opcion) {
                case 1:
                	sistema.MostrarListaDeProyectosBasica();
                	break;
                	
                case 2:
                	sistema.VerTareasAsignadas_Usuario(usuario);
                	break;
                	
                case 3:
                	sistema.MostrarInfoTareas();
                	System.out.println("Ingrese el ID de la tarea que desea modificar: \n");
                	String opcionMenu = scan.nextLine();
                	System.out.println("\nA que estado desea cambiar la tarea elegida?\n1) Pendiente\n2) En progreso\n3) Completada\n>");
                	int indice = Integer.valueOf(scan.nextLine());
                	System.out.println(sistema.ActualizarEstadoTarea_Usuario(opcionMenu,indice));
                	break;
                	
                case 4:
                	sistema.AplicarVisitor_Usuario(visitor);
                	break;
                	
                case 5:
                	System.out.println("Saliendo del menú usuario...");
                	Login();
                	return;
                case 6:
                	System.out.println("Apagando el sistema...");
                	return;
                	
                default:
                	System.out.println("Opción inválida.");
                	break;
            }
            
        } while (opcion != 6);
    }

}

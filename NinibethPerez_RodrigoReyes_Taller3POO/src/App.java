
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
	public static Scanner s = new Scanner(System.in);
	public static SistemaImpl sistema = SistemaImpl.InstanciarSistemaImpl();

	public static void main(String[] args) throws FileNotFoundException {

		LecturaUsuarios();
		LecturaProyectos();
		LecturaTareas();
		
		menuAdmin();
		
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
	
	//---------------------------------- MENU ADMIN -------------------------------------------
	private static void menuAdmin(){
		//En caso que el usuario ingresado tenga el rol Admin se abre este menú de opciones.
		s = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.println("\n--- MENÚ ADMIN ---");
            System.out.println("1. Ver lista completa de proyectos y tareas");
            System.out.println("2. Agregar o eliminar un proyecto");
            System.out.println("3. Agregar o eliminar una tarea de un proyecto");
            System.out.println("4. Asignar prioridades");
            System.out.println("5. Generar reporte de proyectos");
            System.out.println("6. Salir del sistema\n");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.valueOf(s.nextLine());

            switch (opcion) {
                case 1:
                	sistema.VerListaProyectosTareas_Admin();
                	break;
                	
                case 2:
                	System.out.println("\n¿Qué quiere hacer?");
                	System.out.println("1. Agregar un proyecto");
                	System.out.println("2. Eliminar un proyecto");
                	System.out.print(">> ");
                	int eleccion = Integer.valueOf(s.nextLine());
                	
                	if (eleccion == 1) {
                		s = new Scanner(System.in);

            		    System.out.print("Ingrese nombre del proyecto: ");
            		    String nombre = s.nextLine();

            		    System.out.print("Ingrese username del responsable: ");
            		    String resp = s.nextLine();
            		    
            		    System.out.print("Ingrese el ID del proyecto: ");
            		    String ID = s.nextLine();
            		    
            		    sistema.AgregarProyecto_Admin(ID, nombre, resp);
            		    
                	} else {
                		sistema.MostrarListaDeProyectosBasica();
                		System.out.print("Ingrese el ID del proyecto que desea eliminar: ");
                	    String idBuscado = s.nextLine();
                	    
                	    sistema.EliminarProyecto_Admin(idBuscado);
                	}
                	break;
                	
                case 3: 
                	System.out.println("\n¿Qué quiere hacer?");
                	System.out.println("1. Agregar una tarea");
                	System.out.println("2. Eliminar una tarea");
                	System.out.print(">> ");
                	eleccion = Integer.valueOf(s.nextLine());
                	
                	if (eleccion == 1) {
                		sistema.MostrarListaDeProyectosBasica();
                		s = new Scanner(System.in);

            		    System.out.print("\nIngrese el ID del proyecto al que desea agregar la tarea: ");
            		    String idProyecto = s.nextLine();

            		    System.out.print("Ingrese el ID de la tarea: ");
            		    String ID = s.nextLine();
            		    
            		    System.out.print("Ingrese el tipo: ");
            		    String tipo = s.nextLine();
            		    
            		    System.out.print("Ingrese la descripción: ");
            		    String desc = s.nextLine();
            		    
            		    System.out.print("Ingrese el estado: ");
            		    String estado = s.nextLine();
            		    
            		    System.out.print("Ingrese el username del responsable: ");
            		    String userResp = s.nextLine();
            		    
            		    System.out.print("Ingrese la complejidad: ");
            		    String complejidad = s.nextLine();
            		    
            		    System.out.print("Ingrese la fecha: ");
            		    String fecha = s.nextLine();
            		    
            		    sistema.AgregarTarea_Admin(idProyecto, ID, tipo, desc, estado, userResp, complejidad, fecha);
            		    
            		    
                	} else {
                		sistema.MostrarInfoTareas();
                		System.out.print("Ingrese el ID de la tarea a eliminar: ");
            		    String idTarea = s.nextLine();
            		    sistema.EliminarTarea_Admin(idTarea);
                	}
                	break;
                
                case 4:
                	System.out.println("*Cambio de estrategia en tiempo real*\r\n"
            				+ "\r\n"
            				+ "");
            		System.out.println("Su estrategia de trabajado actual es de tipo: " + sistema.getEstrategia());
            		System.out.println("1) Por fecha de creación → Las tareas se ordenan según la fecha en que fueron\r\n"
            				+ "creadas (más antiguas primero).\r\n"
            				+ "\r\n"
            				+ "2) Por impacto → Las tareas se ordenan según la criticidad del tipo de tarea:\r\n"
            				+ "▪ Bug → Alta prioridad.\r\n"
            				+ "▪ Feature → Media prioridad.\r\n"
            				+ "▪ Documentación → Baja prioridad.\r\n"
            				+ "\r\n"
            				+ "3) Por complejidad → Las tareas se ordenan según un valor asignado de complejidad\r\n"
            				+ "(ejemplo: Baja, Media, Alta)\r\n"
            				+ "\r\n"
            				+ "Por favor seleccione el indice de la estrategia de trabajo de desea adoptar (Si se encuentra conforme con su estrategia re introdúzcala dentro de este apartado). \r\n"
            				+ "\r\n"
            				+ "> ");
            		int estrategia = Integer.valueOf(t.nextLine());
            		
            		
                	break;
                	
                case 5:
                	sistema.GenerarReporte_Admin();
                	break;
                	
                	
                case 6: 
                	System.out.println("Sesión cerrada...");
                	System.out.println("Saliendo del menú admin...");
                	return;
                	
                default: 
                	System.out.println("Opción inválida.");
                	break;
            }
        } while (opcion != 0);
    }
	
	//---------------------------------- MENU USUARIO -------------------------------------------
		private static void menuUsuario() {
			//En caso que el usuario ingresado tenga el rol User se abre este menu de opciones.
			s = new Scanner(System.in);
	        int opcion = -1;
	        do {
	            System.out.println("\n--- MENÚ USUARIO ---");
	            System.out.println("1. Ver proyectos disponibles");
	            System.out.println("2. Ver tareas asignadas");
	            System.out.println("3. Actualizar estado de una tarea");
	            System.out.println("4. Checkeo de acciones requeridas sobre una tarea");
	            System.out.println("5. Salir del sistema\n");
	            System.out.print("Seleccione una opción: ");
	            opcion = Integer.valueOf(s.nextLine());

	            switch (opcion) {
	                case 1:
	                	sistema.MostrarListaDeProyectosBasica();
	                	break;
	                	
	                case 2:
	                	//
	                	break;
	                	
	                case 3:
	                	//
	                	break;
	                	
	                case 4:
	                	//
	                	break;
	                
	                case 5:
	                	System.out.println("Saliendo del menú usuario...");
	                	return;
	                	
	                default:
	                	System.out.println("Opción inválida.");
	                	break;
	            }
	            
	        } while (opcion != 0);
	    }
	
}
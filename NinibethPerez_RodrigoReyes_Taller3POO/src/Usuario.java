import java.util.ArrayList;
/**
 * Clase que representa un Usuario en el sistema.
 * Un usuario tiene un rol, y puede ser responsable de proyectos y tareas.
 */
public class Usuario {
	private String Username;
	private String Password;
	private String Rol;
	private ArrayList<Tarea> TareasResponsable = new ArrayList<>();
	private ArrayList<Proyectos> ProyectosResponsable = new ArrayList<>();
	
	/**
     * Constructor para la clase Usuario.
     * @param username El nombre de usuario.
     * @param password La contraseña del usuario.
     * @param rol El rol del usuario (Administrador, Colaborador, Usuario).
     */
	public Usuario(String username, String password, String rol) {
		super();
		Username = username;
		Password = password;
		Rol = rol;
	}
	/** @return El nombre del usuario. */
	public String getUsername() {
		return Username;
	}
	/** @return La contraseña del usuario. */
	public String getPassword() {
		return Password;
	}
	/** @return El rol del usuario. */
	public String getRol() {
		return Rol;
	}
	/** @return La lista de tareas de las que el usuario es responsable. */
	public ArrayList<Tarea> getTareasResponsable() {
		return TareasResponsable;
	}
	/** @return La lista de proyectos de los que el usuario es responsable. */
	public ArrayList<Proyectos> getProyectosResponsable() {
		return ProyectosResponsable;
	}
	/** @param p El proyecto a agregar como responsable. */
	public void agregarProyecto(Proyectos p) {
		this.ProyectosResponsable.add(p);
	}
	/** @param t La tarea a agregar como responsable. */
	public void agregarTarea(Tarea t) {
		this.TareasResponsable.add(t);
	}
	/**
     * Genera una representación en cadena del usuario (solo Username y Password).
     * @return Una cadena con el Username y Password.
     */
	@Override
	public String toString() {
		return "User: " + Username + ", Password: " + Password;
	}
}
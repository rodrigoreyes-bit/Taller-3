import java.util.ArrayList;

public class Usuario {
	private String Username;
	private String Password;
	private String Rol;
	private ArrayList<Tarea> TareasResponsable = new ArrayList<>();
	private ArrayList<Proyectos> ProyectosResponsable = new ArrayList<>();

	public Usuario(String username, String password, String rol) {
		super();
		Username = username;
		Password = password;
		Rol = rol;
	}

	public String getUsername() {
		return Username;
	}

	public String getPassword() {
		return Password;
	}

	public String getRol() {
		return Rol;
	}

	public ArrayList<Tarea> getTareasResponsable() {
		return TareasResponsable;
	}

	public ArrayList<Proyectos> getProyectosResponsable() {
		return ProyectosResponsable;
	}
	
	public void agregarProyecto(Proyectos p) {
		this.ProyectosResponsable.add(p);
	}
	public void agregarTarea(Tarea t) {
		this.TareasResponsable.add(t);
	}
	@Override
	public String toString() {
		return "Usuario [Username=" + Username + ", Password=" + Password + "]";
	}
}
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

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRol() {
		return Rol;
	}

	public void setRol(String rol) {
		Rol = rol;
	}

	public ArrayList<Tarea> getTareasResponsable() {
		return TareasResponsable;
	}

	public void setTareasResponsable(ArrayList<Tarea> tareasResponsable) {
		TareasResponsable = tareasResponsable;
	}

	public ArrayList<Proyectos> getProyectosResponsable() {
		return ProyectosResponsable;
	}

	public void setProyectosResponsable(ArrayList<Proyectos> proyectosResponsable) {
		ProyectosResponsable = proyectosResponsable;
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

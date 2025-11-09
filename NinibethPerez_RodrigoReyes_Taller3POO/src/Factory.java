import java.util.ArrayList;

public interface Factory {
	//https://www.youtube.com/watch?v=lLvYAzXO7Ek

	public Usuario Crear_Usuario(String[] Info);

	public Proyectos Crear_Proyecto(String[] Info, ArrayList<Usuario> usuarios);

	public Tarea Crear_Tarea(String[] Info, ArrayList<Usuario> usuarios, ArrayList<Proyectos> proyectos);

}


public class VisitorAcciones implements Visitor {
	public VisitorAcciones() {}
	@Override
	public void EvaluarTarea(Tarea t) {
		switch(t.getTipo()) {
		
		case "Bug":
			System.out.println("La tarea " + t.getID() + " afecta la criticidad del proyecto gravemente");
			break;

		case "Feature":
			System.out.println("La tarea " + t.getID() + " impacta en la estimación del tiempo de entrega original");
			break;

		case "Documentacion":
			System.out.println("La tarea " + t.getID() + " mejora la calidad total del proyecto");
			break;
			
		}
		
	}

}

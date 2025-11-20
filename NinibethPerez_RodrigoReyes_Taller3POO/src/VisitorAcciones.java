
public class VisitorAcciones implements Visitor {
	public VisitorAcciones() {}
	@Override
	public void EvaluarTarea(Tarea t) {
		switch(t.getTipo().toLowerCase()) {
		
		case "bug":
			System.out.println("La tarea " + t.getID() + " afecta la criticidad del proyecto gravemente!");
			break;

		case "feature":
			System.out.println("La tarea " + t.getID() + " impacta en la estimación del tiempo de entrega original!");
			break;

		case "documentacion":
			System.out.println("La tarea " + t.getID() + " mejora la calidad total del proyecto!");
			break;
			
		}
		
	}

}

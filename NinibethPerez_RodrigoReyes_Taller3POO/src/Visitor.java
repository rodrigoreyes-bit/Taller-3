/**
 * Interfaz Visitor. Define la operación a realizar sobre los elementos (Patrón Visitor).
 */
public interface Visitor {
    /**
     * Define la operación a realizar al visitar una Tarea.
     * @param t La tarea que está siendo visitada.
     */
    void EvaluarTarea(Tarea t);
}

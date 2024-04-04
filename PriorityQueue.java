public interface PriorityQueue<E extends Comparable<E>> {
    // Verifica si la cola está vacía
    boolean isEmpty();

    // Retorna el tamaño de la cola
    int size();

    // Agrega un elemento a la cola
    void add(E value);

    // Retorna y elimina el elemento con mayor prioridad
    E remove();
}
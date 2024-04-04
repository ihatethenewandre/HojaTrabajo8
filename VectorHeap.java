import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    // Vector para almacenar los datos
    private Vector<E> data;

    public VectorHeap() {
        data = new Vector<E>();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void add(E value) {
        // Agrega el valor al final del vector
        data.add(value);
        // Realiza el ordenamiento para mantener la propiedad de heap
        int child = data.size() - 1;
        int parent = (child - 1) / 2;
        while (parent >= 0 && data.get(parent).compareTo(data.get(child)) > 0) {
            E tmp = data.get(parent);
            data.set(parent, data.get(child));
            data.set(child, tmp);
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    @Override
    public E remove() {
        // Guarda el primer elemento
        E minVal = data.get(0);
        // Remueve el primer elemento y reordena el heap
        data.set(0, data.get(data.size() - 1));
        data.remove(data.size() - 1);
        heapify(0);
        return minVal;
    }

    private void heapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;
        if (left < data.size() && data.get(left).compareTo(data.get(smallest)) < 0) {
            smallest = left;
        }
        if (right < data.size() && data.get(right).compareTo(data.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != i) {
            E tmp = data.get(i);
            data.set(i, data.get(smallest));
            data.set(smallest, tmp);
            heapify(smallest);
        }
    }
}
import org.junit.Assert;
import org.junit.Test;

public class Tests {
    @Test
    public void testAddAndRemove() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        Paciente paciente1 = new Paciente("Juan Perez", "fractura de pierna", 'C');
        Paciente paciente2 = new Paciente("Maria Ramirez", "apendicitis", 'A');
        Paciente paciente3 = new Paciente("Lorenzo Toledo", "chikunguya", 'E');

        heap.add(paciente1);
        heap.add(paciente2);
        heap.add(paciente3);

        Assert.assertEquals(paciente2, heap.remove());
        Assert.assertEquals(paciente1, heap.remove());
        Assert.assertEquals(paciente3, heap.remove());
    }
}
package kidchai.algortithms.tasks.BinaryHeapUsingArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BinaryHeapArrayTest {

    private BinaryHeapArray heap;

    @BeforeEach
    void init() {
        heap = new BinaryHeapArray();
        heap.push(2);
        heap.push(3);
        heap.push(7);
    }

    @Test
    void min() {
        int expected = 2;
        assertEquals(expected, heap.min());
    }

    @Test
    void isSiftUpCorrect() {
        heap.push(1);
        int expectedMin = 1;
        assertEquals(expectedMin, heap.min());
    }

    @Test
    void popMin() {
        heap.push(5);
        int expectedMin = 3;
        heap.popMin();
        assertEquals(expectedMin, heap.min());
    }

    @Test
    void popMinFromEmpty() {
        heap = new BinaryHeapArray();
        assertThrows(IndexOutOfBoundsException.class, () -> heap.popMin());
    }
}
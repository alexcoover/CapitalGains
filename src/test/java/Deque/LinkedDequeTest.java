package Deque;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LinkedDequeTest {

    @org.junit.jupiter.api.Test
    void addToFront() throws EmptyQueueException {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToFront(1);
        d.addToFront(2);
        assertEquals(2, d.getFront());
    }

    @org.junit.jupiter.api.Test
    void addToBack() throws EmptyQueueException {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToBack(1);
        assertEquals(1, d.getBack());
    }

    @org.junit.jupiter.api.Test
    void removeFront() throws EmptyQueueException {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToBack(1);
        d.addToBack(2);
        d.addToBack(3);
        d.removeFront();
        assertEquals(2, d.getFront());
    }

    @org.junit.jupiter.api.Test
    void removeBack() throws EmptyQueueException {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToBack(1);
        d.addToBack(2);
        d.addToBack(3);
        d.removeBack();
        assertEquals(2, d.getBack());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        assertTrue(d.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void getFront() throws EmptyQueueException {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToFront(1);
        assertEquals(1, d.getFront());
    }

    @org.junit.jupiter.api.Test
    void getBack() throws EmptyQueueException {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToBack(1);
        assertEquals(1, d.getBack());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToBack(1);
        d.addToBack(2);
        d.addToBack(3);
        d.clear();
        assertTrue(d.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToBack(1);
        d.addToBack(2);
        Iterator<Integer> it = d.iterator();
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertTrue(it.hasNext());
        assertEquals(2, it.next());
        assertFalse(it.hasNext());
    }

    @org.junit.jupiter.api.Test
    void getIterator() {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToBack(1);
        Iterator<Integer> it = d.getIterator();
        assertTrue(it.hasNext());

    }
    @org.junit.jupiter.api.Test
    public void remove() {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToBack(1);
        Iterator<Integer> it = d.getIterator();
        assertThrows(UnsupportedOperationException.class, it::remove);
    }

}
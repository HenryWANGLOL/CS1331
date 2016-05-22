import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;


import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by Tino on 8/28/2015.
 */
public class SinglyLinkedListTest1 {

    private LinkedListInterface<String> list;

    @Rule
    public Timeout timeout = new Timeout(200000);

    @Before
    public void setUp() throws Exception {
        list = new SinglyLinkedList<>();
    }

    @Test
    public void testAddMethods() throws Exception {
        String[] test = {"0a", "0b", "0c", "0d", "0e"};
        list.addToFront("0a");
        list.addToBack("0e");
        list.addAtIndex(1, "0b");

        assertEquals("0e", list.get(2));

        list.addAtIndex(2, "0c");
        list.addAtIndex(3, "0d");

        assertArrayEquals(test, list.toArray());

    }

    @Test
    public void testGet() throws Exception {
        list.addToBack("ab");
        list.addToFront("cd");
        list.addAtIndex(1, "ef");
        list.addToFront("mm");
        assertEquals("ab", list.get(3));
        assertEquals("mm", list.get(0));
        assertEquals("ef", list.get(2));
        assertEquals("cd", list.get(1));
    }

    @Test
    public void testRemoveMethods() throws Exception {
        String[] test = {"b", "c"};
        String[] test1 = {"b"};
        list.addToFront("d");
        list.removeFromFront();
        assertEquals(0, list.size());
        list.addAtIndex(0, "b");
        list.addToBack("c");
        list.addToFront("a");
        list.removeAtIndex(0);
        assertArrayEquals(test, list.toArray());
        list.removeFromBack();
        assertArrayEquals(test1, list.toArray());
    }

    @Test
    public void testRemoveFirstOccurrence() throws Exception {
        String[] test = {"a", "d", "c", "e"};
        list.addToFront("e");
        list.addToFront("c");
        list.addToFront("d");
        list.addToFront("d");
        list.addToFront("a");
        list.removeFirstOccurrence("d");
        assertArrayEquals(test, list.toArray());
    }

    @Test
    public void testIsEmpty() throws Exception {
        list.addToFront("a");
        list.removeFirstOccurrence("a");
        assertEquals(true, list.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        list.addToFront("b");
        list.addAtIndex(0, "c");
        list.addToBack("d");
        list.removeAtIndex(1);
        list.removeFromBack();
        list.removeFromFront();
        assertEquals(0, list.size());
    }

    @Test
    public void testClear() throws Exception {
        list.addToFront("b");
        list.addAtIndex(0, "c");
        list.addToBack("d");
        list.clear();
        Object[] test = new Object[0];
        assertEquals(test, list.toArray());
        assertEquals(0, list.size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIllegalArgument() {
        list.addToBack(null);
        list.addToFront(null);
        list.removeFirstOccurrence(null);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBound() {
        list.addAtIndex(1, "a");
        list.addAtIndex(-1, "b");
        list.removeAtIndex(0);
        list.addToFront("a");
        list.removeAtIndex(1);
        assertEquals(0, list.size());
    }

    @Test (expected = NoSuchElementException.class)
    public void testNoSuchElementException() {
        String[] test = {"a"};
        list.addToFront("a");
        list.removeFirstOccurrence("c");
        assertEquals(1, list.size());
        assertArrayEquals(test, list.toArray());
    }

}
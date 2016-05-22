/**
 * Your implementation of a SinglyLinkedList
 */
public class SinglyLinkedList<T> implements LinkedListInterface<T> {

    // Do not add new instance variables.
    private LinkedListNode<T> head;
    private int size;

    @Override

    public void reverse() {
        LinkedListNode<T> cur = new LinkedListNode<T>(get(size-1), null);
        for (int i = size-2, i >= 0; i++) {
            LinkedListNode<T> precur = new LinkedListNode<T>(get(i), null);
            cur.setNext(precur);
            cur = precur;
        }
    }
    public void addAtIndex(int index, T data) {
        if (index < 0 || index > size) {
            throw new java.lang.IndexOutOfBoundsException("no such index");
        } else if (data == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        } else if (index == 0) {
            addToFront(data);
        } else {
            LinkedListNode<T> cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.getNext();
            }
            LinkedListNode<T> a = new LinkedListNode<>(data);
            a.setNext(cur.getNext());
            cur.setNext(a);
            size++;
        }

    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new java.lang.IndexOutOfBoundsException("no such index");
        } else if (index == 0) {
            return head.getData();
        } else {
            LinkedListNode<T> cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.getNext();
            }
            return cur.getData();
        }
    }

    @Override
    public T removeAtIndex(int index) {
        size--;
        if (index < 0 || index > size) {
            throw new java.lang.IndexOutOfBoundsException("no such index");
        } else if (index == 0) {
            T a = head.getData();
            head = head.getNext();
            return a;
        } else {
            LinkedListNode<T> cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.getNext();
            }
            LinkedListNode<T> a = cur.getNext();
            cur.setNext(a.getNext());
            return a.getData();
        }
    }

    @Override
    public void addToFront(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data"
                    + " cannot be null");
        }
        LinkedListNode<T> a = new LinkedListNode<>(data, head);
        head = a;
        size++;
    }

    @Override
    public void addToBack(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        }
        LinkedListNode<T> cur = head;
        LinkedListNode<T> a = new LinkedListNode<>(data, null);
        if (head == null) {
            head = a;
        } else {
            while (cur.getNext() != null) {
                cur = cur.getNext();
            }

            cur.setNext(a);
        }

        size++;
    }

    @Override
    public T removeFromFront() {
        if (head == null) {
            return null;
        }
        T a = head.getData();
        head = head.getNext();
        size--;
        return a;
    }

    @Override
    public T removeFromBack() {
        if (head == null) {
            return null;
        }
        size--;
        LinkedListNode<T> cur = head;
        for (int i = 0; i < size - 1; i++) {
            cur = cur.getNext();
        }
        if (size == 0) {
            head = null;
            return cur.getData();
        } else {
            T a = cur.getNext().getData();
            cur.setNext(null);
            return a;
        }

    }

    @Override
    public int removeFirstOccurrence(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        } else if (head == null) {
            throw new java.util.NoSuchElementException("no such element");
        } else {
            LinkedListNode<T> cur = head;
            LinkedListNode<T> pre = null;
            int a = 0;
            while (!cur.getData().equals(data) && cur.getNext() != null) {
                a++;
                pre = cur;
                cur = cur.getNext();
            }
            if (pre == null) {
                head = head.getNext();
                size--;
                return a;
            } else if (cur.getData().equals(data)) {
                pre.setNext(cur.getNext());
                size--;
                return a;
            }
            throw new java.util.NoSuchElementException("no such element");



        }
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        LinkedListNode<T> cur = head;
        int a = 0;
        while (a < size) {
            array[a] = cur.getData();
            cur = cur.getNext();
            a++;
        }
        return array;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public LinkedListNode<T> getHead() {
        // DO NOT MODIFY!
        return head;
    }
}

import java.util.Iterator;
import java.util.Set;
import java.util.Collection;
import java.util.Arrays;
import java.util.Exception;

/**
* This class implements the SimpleSet interface
*
* @param <T> Param Type
* @version 1.0
* @author _Yufeng_Wang
*/
public class MySet<T> implements Set<T> {

    private T[] backingArray;
    private int numElements;

    public MySet() {
        this.backingArray = (T[]) new Object[10];
        this.numElements = 0;
    }

    /**
     * @param c add c to the backingarray
     * @return boolean
     */
    public boolean addAll(Collection<? extends T> c) {
        for (T elem:c) {
            this.add(elem);
        }
        return true;
    }
    /**
     * @param a change the arraylist to array
     * @return T[] the array
     */
    public  <T> T[] toArray(T[] a) throws
        ArrayStoreException, NullPointerException {
        for (int i = 0; i < numElements; i++) {
            a[i] = (T) backingArray[i];
        }
        for (int j = numElements; j < a.length; j++) {
            a[j] = null;
        }
        return a;
    }
    /**
     * @return Object[] array
     */
    public Object[] toArray() {
        Object[] newArray = new Object[numElements];
        for (int i = 0; i < numElements; i++) {
            newArray[i] = backingArray[i];
        }
        return newArray;
    }

    /**
     * @param c check if c is contained in the arraylist
     * @return boolean
     */
    public boolean containsAll(Collection<?> c) {
        for (T elem : (Set<T>) c) {
            if (!(this.contains(elem))) {
                return false;
            }
        }
        return true;
    }
    //create a temporary array to add elements
    /**
     * @param e add e to the backingarray
     * @return boolean
     */
    public boolean add(T e) {

        if (numElements == backingArray.length) {
            T[] newArray = Arrays.copyOf(backingArray,
                backingArray.length * 2);
            newArray[numElements] = e;
            numElements = numElements + 1;
            backingArray = newArray;
            return true;
        } else {
            if (!this.contains(e)) {
                backingArray[numElements] = e;
                numElements++;
            }
        }
        return true;
    }

    /**
     * @param item check item in the backingarray
     * @return boolean
     */
    public boolean contains(Object item) {
        return this.indexOf(item) != -1;

    }

    /**
     * @param item which is in the arraylist
     * @return int the index of item
     */
    public int indexOf(Object item) {
        for (int i = 0; i < numElements; i++) {
            if (backingArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        T[] newArray = (T[]) new Object[backingArray.length];
        numElements = 0;
        backingArray = newArray;
    }

    /**
     * @param c remove all c in the backingarray
     * @return boolean
     */
    public boolean removeAll(Collection<?> c) {
        for (Object item: c) {
            this.remove(item);
        }
        return true;

    }

    /**
     * @return int the size fo the arraylist
     */
    public int size() {
        return numElements;
    }

    /**
     * @param o remove the object from the array
     * @return boolean
     */
    public boolean remove(Object o) {
        int i = 0;
        for (Object item : backingArray) {
            if (o != null && o.equals(item)) {
                System.arraycopy(backingArray, i + 1, backingArray,
                    i, numElements - i - 1);
                numElements = numElements - 1;
                return true;
            }
            i++;
        }
        return false;
    }

    /**
     * @param c basic retain all elements of c in arraylist
     * @return boolean
     */
    public boolean retainAll(Collection<?> c) {
        int index = 0;
        boolean results = false;
        if (this.containsAll(c)) {
            results = true;
        }
        while (index < numElements) {
            T item = backingArray[index];
            if (item != null && !(c.contains(item))) {
                this.remove(item);
            } else {
                index++;
            }
        }
        return results;

    }
    /**
     * @return boolean
     */
    public boolean isEmpty() {
        return numElements == 0
    }


    /*
    ----------------------------------------------
    These methods are provided to help you, DO NOT MODIFY!
    Refer to the slides on Iterators if you want to learn more
    http://cs1331.org/slides/iterators.pdf
    */

    /**
    * Returns an iterator if you wish to use it
    * @return An iterator for the SimpleSet
    */
    public Iterator<T> iterator() {
        return new MySetIterator();
    }

    private class MySetIterator implements Iterator {

        private int index = 0;
        public boolean hasNext() {
            return index < numElements;
        }

        public T next() {
            return backingArray[index++];
        }

    }

}

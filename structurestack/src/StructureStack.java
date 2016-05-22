import java.util.Stack;

/**
 * A Structure implemented like a stack.
 */
public class StructureStack<T> implements Structure<T> {
    private Stack<T> s = new Stack<T>();

    @Override
    public boolean isEmpty() {
        return s.empty();
    }

    @Override
    public void clear() {
        s.clear();
    }

    @Override
    public void add(T node) {
        s.push(node);
    }

    @Override
    public T remove() {
        return s.pop();
    }

    @Override
    public String toString() {
        return "Stack of size " + s.size();
    }
}

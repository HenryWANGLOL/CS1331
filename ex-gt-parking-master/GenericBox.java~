public class GenericBox<E> {
    private E data;

    public GenericBox(E e) {
        this.data = e;
    }

    public E get() {
        return data;
    }

    public static void main(String[] args) {
        GenericBox<String> objects = new GenericBox<>("Anything");
        GenericBox<Integer> n = new GenericBox<>(1);
        Object m = new GenericBox<String>("A");
        String data = objects.get();
        Integer notAllowed = n.get();
    }
}

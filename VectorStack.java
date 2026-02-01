@SuppressWarnings("unchecked")
public class VectorStack<T> implements IStack<T> {

    private T[] data;
    private int size;

    // Constructor
    public VectorStack() {
        data = (T[]) new Object[10]; // tamaño inicial
        size = 0;
    }

    @Override
    public void push(T item) {
        if (size == data.length) {
            grow();
        }
        data[size] = item;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        T item = data[size - 1];
        data[size - 1] = null; // evitar memory leak
        size--;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        return data[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    // Método privado para crecer el arreglo
    private void grow() {
        T[] newData = (T[]) new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}

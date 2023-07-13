package ss10_dsa_danh_sach.arraylist;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }


    /**
     * ensureCapacity dùng bảo đảm độ dài của mảng
     */
    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }
    public void addElements(int index, E element) {
        for (int i = elements.length - 1; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        System.out.println(element);
        size++;
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    public E remove(int index) {
        for (int i = 0; i < elements.length ; i++) {
            if (elements[i].equals(index)){

            }
        }

        return null;
    }

    public int size() {

        return 0;
    }


    public E clone() {

        return null;
    }

    public boolean contains(E o) {

        return false;
    }

    public int indexOf(E o) {

        return 0;
    }

    public void ensureCapacity(int minCapacity) {

    }

    public void clear() {
        Arrays.fill(elements, null);
        size--;
    }
}

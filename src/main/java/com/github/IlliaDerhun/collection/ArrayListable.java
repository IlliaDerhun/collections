package com.github.IlliaDerhun.collection;

public class ArrayListable<T> implements Listable<T> {

    private int size = 0;

    private int capacity = 10;

    private Object[] array;

    public ArrayListable() {
        this.array = new Object[capacity];
    }

    @Override
    public boolean add(T element) {
        if (size >= array.length) {
            stretchArray();
        }
        array[size] = element;
        size++;
        return true;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(T element) {
        if (element == null && size == 0) {
            return false;
        }
        if (element == null) {
            return indexOfNullElement() >= 0;
        }
        return indexOfElement(element) >= 0;
    }

    @Override
    public int indexOfElement(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    private int indexOfNullElement() {
        for (int i = 0; i < size; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private void stretchArray() {
        capacity = (capacity << 1) + 1; // the same as (capacity * 2) + 1
        Object[] newArray = new Object[capacity];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}

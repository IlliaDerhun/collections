package com.github.IlliaDerhun.collection;

public interface Listable<T> {

    boolean add(T element);

    T get(int index);

    int size();

    boolean isEmpty();

    boolean contains(T element);

    int indexOfElement(T element);
}

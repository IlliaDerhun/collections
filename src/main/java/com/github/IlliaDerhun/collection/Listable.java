package com.github.IlliaDerhun.collection;

public interface Listable<T> {

    boolean add(T element);

    T get(int index);

    T getOrDefault(int index, T defaultElement);

    int size();

    boolean isEmpty();

    boolean contains(T element);

    int indexOfElement(T element);
}

package com.github.IlliaDerhun.collection;

public class LinkedListable<T> implements Listable<T> {

    private int size = 0;

    private Node<T> head;

    private Node<T> tail;

    public LinkedListable() {
    }

    @Override
    public boolean add(T element) {
        size++;
        if (head == null) {
            head = new Node<>(null, null, element);
        } else if (head.getNext() == null) {
            tail = new Node<>(head, null, element);
            head.setNext(tail);
        } else {
            Node<T> node = new Node<>(tail, null, element);
            tail.setNext(node);
            tail = node;
        }
        return true;
    }

    @Override
    public T get(int index) {
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }

    @Override
    public T getOrDefault(int index, T defaultElement) {
        if (index > size || index < 0) {
            return defaultElement;
        }
        return get(index);
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
        if (element == null) {
            return indexOfNullElement() >= 0;
        }
        return indexOfElement(element) >= 0;
    }

    @Override
    public int indexOfElement(T element) {
        if (size == 0) {
            return -1;
        }
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (element.equals(node.getValue())) {
                return i;
            }
            node = node.getNext();
        }
        return -1;
    }

    private int indexOfNullElement() {
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.getValue() == null) {
                return i;
            }
        }
        return -1;
    }

    private static final class Node<T> {

        private Node<T> previous;

        private Node<T> next;

        private T value;

        public Node(Node<T> previous, Node<T> next, T value) {
            this.previous = previous;
            this.next = next;
            this.value = value;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}

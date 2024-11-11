package util;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    public Stack() {
        this.head = null;
        this.size = 0;
    }

    public void push(T value) {
        head = new Node<>(value, head);
        ++size;
    }

    public T pop() {
        if (head == null) throw new EmptyStackException();

        T value = head.getValue();
        head = head.getNext();
        --size;

        return value;
    }

    public Object[] getValues() {
        Object[] values = new Object[size];
        int i = 0;

        T value;
        while ((value = iterator().next()) != null) {
            values[i++] = value;
        }

        return values;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Iterator<T> iterator() {
        return new NodeIterator<>(head);
    }

    private static class Node<T> {
        private final T value;
        private final Node<T> next;

        public Node(T value) {
            this(value, null);
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        protected T getValue() {
            return value;
        }

        protected Node<T> getNext() {
            return next;
        }
    }

    private static class NodeIterator<T> implements Iterator<T> {
        private Node<T> value;

        public NodeIterator(Node<T> value) {
            this.value = value;
        }

        @Override
        public boolean hasNext() {
            return value != null && value.next == null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();

            value = value.next;

            return value.getValue();
        }
    }
}

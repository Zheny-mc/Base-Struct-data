package Task13;
/*
* LinkedListStack<T> — класс с реализацией базовых операций стека.
* Внутри себя использует Task9.LinkedList<T> для манипуляции данными.
* Node<T> — внутренний класс, который представляет собой элемент списка
* */

import java.util.List;

public class LinkedList<T> {

    // внутренний класс, который представляет элемент списка
    private static class Node<T> {

        // данные
        private T data;
        // указатель на следующий элемент
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Integer size = 0;
    private Node<T> first = null;

    public LinkedList() {}

    public LinkedList(List<Double> list) {
        for (int i = list.size()-1; i >=0; i--) {
            addFirst((T) list.get(i));
        }
    }

    public LinkedList(LinkedList<Double> list) {
        for (int i = list.getSize()-1; i >=0; i--) {
            addFirst((T) list.get(i));
        }
    }

    // используется для push операции
    public void addFirst(T data) {
        Node<T> newFirst = new Node<T>(data);
        newFirst.next = first;
        first = newFirst;
        ++size;
    }

    // используется для pop операции
    public T removeFirst() {
        Node<T> oldFirst = first;
        first = first.next;
        --size;
        return oldFirst.data;
    }

    public T get(int i) {
        int n = indexOf(first); // count-1 actually
        Node<T> current = first;
        while (n > i) {
            --n;
            current = current.next;
        }
        return current.data;
    }

    public void set(int i, T data) {
        int n = indexOf(first); // count-1 actually
        Node<T> current = first;
        while (n > i) {
            --n;
            current = current.next;
        }
        current.data = data;
    }

    private int indexOf(Node<T> link) {
        if (link == null) {
            return -1;
        }
        return 1 + indexOf(link.next);
    }

    @Override
    public String toString() {
        StringBuilder listBuilder = new StringBuilder();
        Node currentNode = first;
        while (currentNode != null) {
            listBuilder.append(currentNode).append(",");
            currentNode = currentNode.next;
        }
        return listBuilder.toString();
    }

    public Integer getSize() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

}
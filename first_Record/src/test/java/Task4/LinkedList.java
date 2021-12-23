package Task4;
/*
* Task9.LinkedListStack<T> — класс с реализацией базовых операций стека.
* Внутри себя использует Task9.LinkedList<T> для манипуляции данными.
* Node<T> — внутренний класс, который представляет собой элемент списка
* */

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

    private Node<T> first = null;

    // используется для push операции
    public void addFirst(T data) {
        Node<T> newFirst = new Node<T>(data);
        newFirst.next = first;
        first = newFirst;
    }

    // используется для pop операции
    public T removeFirst() {
        Node<T> oldFirst = first;
        first = first.next;
        return oldFirst.data;
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

    public boolean isEmpty() {
        return first == null;
    }

}
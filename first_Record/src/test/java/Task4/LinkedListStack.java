package Task4;
/*
* Task9.LinkedList<T> — реализация связанного списка
* */

public class LinkedListStack<T> {

    private final LinkedList<T> linkedList = new LinkedList<>();

    public void push(T data) {
        linkedList.addFirst(data);
    }

    public T pop() {
        return linkedList.removeFirst();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
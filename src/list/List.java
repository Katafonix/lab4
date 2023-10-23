package list;

public class List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private static class Node<T> {
        Node<T> next;
        T data;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data, null);

        if (tail == null) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    int getSize() {
        return size;
    }

    public <U> void remove(U data) {
        if (isEmpty()) throw new RuntimeException("Список пуст, нельзя удалить элемент");
        Node<T> previous = null;
        Node<T> current = head;

        for (int i = 0; i < size; i++) {
            if (current.data.equals(data)) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else if (current == head) {
                    head = current.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = previous;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                    current = previous;
                }
                size--;
            }
            previous = current;
            current = current.next;
        }
    }

    public void print() {
        if (isEmpty()) System.out.println("Список пуст");
        else {
            Node<T> current = head;
            do {
                System.out.println(current.data);
                current = current.next;
            } while (current != head);
        }
    }

    boolean isEmpty() {
        return getSize() == 0;
    }
}
package domein;

import java.io.Serializable;

public class Node <T extends Serializable> implements Serializable{

	private static final long serialVersionUID = 1L;
    private final T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }
}

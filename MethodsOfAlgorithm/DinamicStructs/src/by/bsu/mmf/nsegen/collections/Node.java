package by.bsu.mmf.nsegen.collections;

/**
 * Created by root on 18.9.16.
 */
class Node<T> {

    private T data;
    private Node<T> next;
    private Node<T> prev;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}

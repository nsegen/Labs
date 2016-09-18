package by.bsu.mmf.nsegen.collections;

/**
 * Created by root on 18.9.16.
 */
public class MyLinkedList<T> implements IList<T> {

    protected Node<T> head;
    protected int length;

    public int getLength() {
        return length;
    }

    public MyLinkedList()
    {
        head = new Node<>();
    }

    @Override
    public IList<T> add(T data, int index) {
        if(index > length || index < 0)
        {
            throw new IllegalArgumentException("Index more than length");
        } else if (isEmpty())
        {
            length++;
            head.setData(data);
            return this;
        } else if (length == index)
        {
            return addToEnd(data);
        } else if (index == 0)
        {
            return addToStart(data);
        }

        Node<T> tmpNode = head;

        while(index > 0)
        {
            tmpNode = tmpNode.getNext();
            index--;
        }

        Node<T> newNode = new Node<>();
        newNode.setPrev(tmpNode.getPrev());
        newNode.setNext(tmpNode);
        newNode.setData(data);

        newNode.getPrev().setNext(newNode);

        newNode.getNext().setPrev(newNode);

        length++;

        return this;
    }

    @Override
    public IList<T> remove(int index) {
        Node<T> node = head;

        if(index >= length){
            throw new IllegalArgumentException("Index more than length");
        }

        if(length == 1){
            length = 0;
            head.setNext(null);
            return this;
        }

        while (index > 0)
        {
            node = node.getNext();
            index--;
        }

        if(node.getPrev() != null) {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        if(node.getNext() != null) {
            node.getNext().setPrev(node.getPrev());
        } else {
            node.getPrev().setNext(null);
        }
        length--;
        return this;
    }

    @Override
    public T get(int index) {
        if (index >= length)
        {
            throw new IllegalArgumentException("Index more or equals than length");
        }
        Node<T> node = head;
        while(index > 0)
        {
            node = node.getNext();
            index--;
        }
        return node.getData();
    }

    @Override
    public IList<T> addToEnd(T data) {
        if(isEmpty()){
            head.setData(data);
            length++;
            return this;
        }
        Node<T> node = head;
        while(node.getNext() != null)
        {
            node = node.getNext();
        }
        Node<T> newNode = new Node<>();
        newNode.setPrev(node);
        newNode.setData(data);
        node.setNext(newNode);
        length++;
        return this;
    }

    @Override
    public IList<T> addToStart(T data) {
        if(isEmpty()){
            head.setData(data);
            length++;
            return this;
        }
        Node<T> newNode = new Node<>();
        newNode.setData(data);
        newNode.setNext(head);
        head.setPrev(newNode);
        length++;
        head = head.getPrev();
        return this;
    }

    @Override
    public Boolean isEmpty(){
        return length == 0;
    }


}

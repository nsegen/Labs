package by.bsu.mmf.nsegen.collections;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by root on 18.9.16.
 */
public class MyStack<T> extends MyLinkedList<T> implements IStack<T> {

    @Override
    public IStack<T> push(T data) {
        super.addToStart(data);
        return this;
    }

    @Override
    public T pop() {
        T data = peek();
        super.remove(0);
        return data;
    }

    @Override
    public T peek() {
        return super.get(0);
    }

    @Override
    public int getLength() {
        return super.getLength();
    }

    public MyStack() {
        super();
    }

    @Override
    public IList<T> add(T data, int index) {
        throw new NotImplementedException();
    }

    @Override
    public IList<T> remove(int index) {
        throw new NotImplementedException();
    }

    @Override
    public T get(int index) {
        throw new NotImplementedException();
    }

    @Override
    public IList<T> addToEnd(T data) {
        throw new NotImplementedException();
    }

    @Override
    public IList<T> addToStart(T data) {
        throw new NotImplementedException();
    }

    @Override
    public Boolean isEmpty() {
        return super.isEmpty();
    }
}

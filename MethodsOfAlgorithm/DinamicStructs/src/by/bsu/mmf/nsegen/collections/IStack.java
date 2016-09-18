package by.bsu.mmf.nsegen.collections;

/**
 * Created by root on 18.9.16.
 */
public interface IStack<T> extends IList<T>{

    IStack<T> push(T data);
    T pop();
    T peek();

}

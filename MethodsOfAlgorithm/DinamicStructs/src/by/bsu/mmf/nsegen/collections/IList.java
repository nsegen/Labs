package by.bsu.mmf.nsegen.collections;

/**
 * Created by root on 18.9.16.
 */
public interface IList<T> {
    IList<T> add(T data, int index);
    IList<T> remove(int index);
    T get(int index);
    IList<T> addToEnd(T data);
    IList<T> addToStart(T data);
    Boolean isEmpty();
    int getLength();
}

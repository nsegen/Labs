package by.bsu.mmf.nsegen;

import java.util.Arrays;

/**
 * Created by nsegen on 29.03.16.
 */
public class Array {
    protected int arr[];

    public Array(){

    }

    public Array(int[] a){
        arr = a;
    }

    public Array(Array a){
        arr = new int[a.getArr().length];
        arr = Arrays.copyOf(a.getArr(), a.getArr().length);
    }

    public Array(final int n){
        arr = new int[n];
    }

    public int[] getArr() {
        return arr;
    }

    public int length(){
        return arr.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Array array = (Array) o;

        return Arrays.equals(arr, array.arr);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }
}

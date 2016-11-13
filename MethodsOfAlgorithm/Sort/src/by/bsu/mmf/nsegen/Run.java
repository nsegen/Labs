package by.bsu.mmf.nsegen;

/**
 * Created by nsegen on 29.03.16.
 */
public class Run {
    public static void main(String[] args){
        int n=15;

        System.out.println("Bubble sort:");
        Array arr = ArrayBuilder.getRandomArray(n);
        System.out.print(arr + " -> ");
        arr = ArrayBuilder.bubbleSort(arr);
        System.out.println(arr);

        System.out.println("Quick sort:");
        arr = ArrayBuilder.getRandomArray(n);
        System.out.print(arr + " -> ");
        ArrayBuilder.qSort(arr, 0, arr.length()-1);
        System.out.println(arr);

        System.out.println("Merging sort:");
        arr = ArrayBuilder.getRandomArray(n);
        System.out.print(arr + " -> ");
        arr = ArrayBuilder.mergingSort(arr);
        System.out.println(arr);

        System.out.println("Radix sort:");
        arr = ArrayBuilder.getRandomArray(n);
        System.out.print(arr + " -> ");
        arr = ArrayBuilder.radixSort(arr);
        System.out.println(arr);

        //System.out.println(ArrayBuilder.digit(123, 4));
        /*System.out.println("Selection sort:");
        arr = ArrayBuilder.getRandomArray(n);
        System.out.print(arr + " -> ");
        arr = ArrayBuilder.selectionSort(arr);
        System.out.println(arr);
        System.out.println("Insertion simple sort:");
        arr = ArrayBuilder.getRandomArray(n);
        System.out.print(arr + " -> ");
        arr = ArrayBuilder.insertionSimpleSort(arr);
        System.out.println(arr);
        System.out.println("Insertion hash sort:");
        arr = ArrayBuilder.getRandomArray(n);
        System.out.print(arr + " -> ");
        arr = ArrayBuilder.insertionHashSort(arr);
        System.out.println(arr);

        System.out.println("Shell sort:");
        arr = ArrayBuilder.getRandomArray(n);
        System.out.print(arr + " -> ");
        arr = ArrayBuilder.shellSort(arr);
        System.out.println(arr);*/
    }
}

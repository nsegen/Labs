package by.bsu.mmf.nsegen;

import java.util.*;
//import java.util.function.UnaryOperator;

/**
 * Created by nsegen on 29.03.16.
 */
public class ArrayBuilder {

    public static Array getRandomArray(final int n){
        int arr[] = new int[n];
        Random rand = new Random();
        for(int i=0; i<n; i++){
            arr[i] = rand.nextInt(n);
        }
        return new Array(arr);
    }

    public static Array bubbleSort(Array arr){
        int[] res = Arrays.copyOf(arr.getArr(), arr.length());
        for(int i=0; i<res.length-1; i++){
            for(int j=0; j<res.length-i-1; j++){
                if(res[j]>res[j+1]){
                    int tmp = res[j];
                    res[j] = res[j+1];
                    res[j+1] = tmp;
                }
            }
            System.out.println(Arrays.toString(res));
        }
        return new Array(res);
    }

    public static Array radixSort(Array arr) {

        int[] a = arr.getArr();
        int n = a.length;
        int[] b = new int[n];
        int k = 10;
        int m = 0;
        for(int i:a){
            if(countDigits(i)>m) {
                m = countDigits(i);
            }
        }

        for(int i = 1; i <= m; i++) {
            int[] c = new int[k];

            for(int j = 0; j<n; j++) {
                int d = digit(a[j], i);
                c[d]++;
            }
            int count = 0;
            for(int j = 0; j<k; j++) {
                int tmp = c[j];
                c[j] = count;
                count += tmp;
            }

            //System.out.println(Arrays.toString(c));

            for(int j = 0; j < n; j++) {
                int d = digit(a[j], i);
                b[c[d]] = a[j];
                c[d]++;
            }
            a = Arrays.copyOf(b, n);
        }
        return new Array(a);
    }

    static int countDigits(int number){
        int result = 0;
        for(long match = 0L; number > match; ++result)
            match = (match << 3) + (match << 1) + 9L;
        return result;
    }

    //эта функция возвращает p-ую цифру числа n
    public static int digit(int n, int p) {
        return (int)(n/Math.pow(10, p-1))%10;
    }

    private static int partition(int[] arr, int p, int r) {
        System.out.println(Arrays.toString(arr));
        int x = arr[r];
        int i = p - 1;
        for(int j = p; j<r; j++) {
            if (arr[j]<=x) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        i++;
        int tmp = arr[i];
        arr[i] = arr[r];
        arr[r] = tmp;
        return i;
    }

    public static void qSort(Array a, int p, int r) {
        if(p<r) {
            int q = partition(a.getArr(), p, r);
            qSort(a, p, q-1);
            qSort(a, q+1, r);
        }
    }

    public static Array cocktailSort(Array arr){
        int[] res = Arrays.copyOf(arr.getArr(), arr.length());
        int left = 0;
        int right = res.length - 1;

        do
        {
            for (int i = left; i < right; i++)
            {
                if(res[i] > res[i+1])
                {
                    res[i] ^= res[i+1];
                    res[i+1] ^= res[i];
                    res[i] ^= res[i+1];
                }
            }
            right--;
            for (int i = right; i > left ; i--)
            {
                if(res[i] < res[i-1])
                {
                    res[i] ^= res[i-1];
                    res[i-1] ^= res[i];
                    res[i] ^= res[i-1];
                }
            }
            left++;
        } while (left <= right);

        return new Array(res);
    }

    public static Array selectionSort(Array arr){
        int[] res = Arrays.copyOf(arr.getArr(), arr.length());
        for (int min=0;min<res.length;min++) {
            int least = min;
            for (int j=min+1;j<res.length;j++) {
                if(res[j] < res[least]) {
                    least = j;
                }
            }
            int tmp = res[min];
            res[min] = res[least];
            res[least] = tmp;
        }
        return new Array(res);
    }

    public static Array insertionSimpleSort(Array arr){
        int[] res = Arrays.copyOf(arr.getArr(), arr.length());
        for(int i=1; i<=res.length; i++){
            for(int j=i-1; j>0 && res[j-1]>res[j]; j--){
                int tmp=res[j-1];
                res[j-1]=res[j];
                res[j]=tmp;
            }
        }
        return new Array(res);
    }

    public static Array insertionHashSort(Array arr){
        int[] res = Arrays.copyOf(arr.getArr(), arr.length());
        for(int i=1; i<=res.length; i++){
            int index = 0;
            for(int j=i-1; j>0 && res[j-1]>res[j]; j--){
                int tmp=res[j-1];
                res[j-1]=res[j];
                res[j]=tmp;
            }
        }
        return new Array(res);
    }

    private static Array merge(Array a_1, Array a_2) {
        int[] arr_1 = Arrays.copyOf(a_1.getArr(), a_1.length());
        int[] arr_2 = Arrays.copyOf(a_2.getArr(), a_2.length());
        int len_1 = arr_1.length, len_2 = arr_2.length;
        int a = 0, b = 0, len = len_1 + len_2; // a, b - счетчики в массивах
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (b < len_2 && a < len_1) {
                if (arr_1[a] > arr_2[b]) result[i] = arr_2[b++];
                else result[i] = arr_1[a++];
            } else if (b < len_2) {
                result[i] = arr_2[b++];
            } else {
                result[i] = arr_1[a++];
            }
        }
        return new Array(result);
    }

    public static Array mergingSort(Array arr) {
        int[] res = Arrays.copyOf(arr.getArr(), arr.length());
        int len = res.length;
        if (len < 2) return arr;
        int middle = len / 2;
        return merge(mergingSort(new Array(Arrays.copyOfRange(res, 0, middle))),
                mergingSort(new Array(Arrays.copyOfRange(res, middle, len))));
    }

    public static Array shellSort(Array arr){
        int[] res = Arrays.copyOf(arr.getArr(), arr.length());
        int step = res.length / 2;//инициализируем шаг.
        while (step > 0)//пока шаг не 0
        {
            for (int i = 0; i < (res.length - step); i++)
            {
                int j = i;
                //будем идти начиная с i-го элемента
                while (j >= 0 && res[j] > res[j + step])
                //пока не пришли к началу массива
                //и пока рассматриваемый элемент больше
                //чем элемент находящийся на расстоянии шага
                {
                    //меняем их местами
                    int temp = res[j];
                    res[j] = res[j + step];
                    res[j + step] = temp;
                    j--;
                }
            }
            step = step / 2;//уменьшаем шаг
        }
        return new Array(res);
    }


}

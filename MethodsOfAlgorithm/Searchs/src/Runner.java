import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nsegen on 12.11.16.
 */
public class Runner {

    public static int interpolationalSearch(int[] arr, int n, int e){
        int l=0, r=n-1;
        int pos = (e-arr[l])*n/(arr[r]-arr[l]);
        while(l<r && e != arr[pos]) {
            if(arr[pos]<e) {
                l = pos + 1;
            } else {
                r = pos - 1;
            }
            pos = l + (e-arr[l])*(r-l+1)/(arr[r]-arr[l]);
        }
        return pos;
    }

    public static int kth(int[] array, int l, int r, int k) {
        int i = l;
        int j = r;
        int x = array[(l + r)/2];
        while (i <= j) {
            while (array[i] < x) {
                i++;
            }
            while (array[j] > x) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (l <= k && k <= j) {
            return kth(array, l, j, k);
        }
        if (i <= k && k <= r) {
            return kth(array, i, r, k);
        }
        return array[k];
    }

    public static void main(String[] args) {
        int n = 15;
        Scanner sc = new Scanner(System.in);
        System.out.println("input array: ");
        int[] arr = new int[n];
        /*for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("input element: ");
        int e = sc.nextInt();
        int pos = interpolationalSearch(arr, n, e);
        System.out.println("arr["+pos+"] = "+arr[pos]);*/

        System.out.println("input array: ");
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("input k: ");
        int k = sc.nextInt();
        int p = kth(arr, 0, n-1, k-1);
        System.out.println("k-min = " + p);

    }

}

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nsegen on 10.10.16.
 */
public class Runner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[] str = sc.nextLine().toCharArray();
        char[] subStr = sc.nextLine().toCharArray();
        KPMMatcher(str, subStr);

    }

    private static void KPMMatcher(char[] t, char[] p) {
        int n = t.length;
        int m = p.length;
        int[] pi = computePrefixFunction(p);
        System.out.println(Arrays.toString(pi));
        int q = 0;
        for (int i = 0; i < n; i++) {
            while(q>0 && p[q] != t[i]) {
                q = pi[q-1];
            }
            if(p[q] == t[i]) {
                q += 1;
            }
            if(q == m-1) {
                System.out.println(i-m+2);
                q = pi[q];
            }
        }
    }

    private static int[] computePrefixFunction(char[] p) {
        int m = p.length;
        int[] pi = new int[m];
        pi[0] = 0;
        int k = 0;
        for(int q=1; q<m; q++) {
            while(k>0 && p[k] != p[q]) {
                k = pi[k-1];
            }
            if(p[k] == p[q]) {
                k += 1;
            }
            pi[q] = k;
        }
        return pi;
    }
}

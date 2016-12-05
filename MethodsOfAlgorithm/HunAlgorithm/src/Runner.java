import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nsegen on 4.12.16.
 */
public class Runner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        float matr[][] = new float[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matr[i][j] = sc.nextInt();
            }
        }

        int[][] res = new Hungarian(matr).execute();

        for(int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }

    }

}

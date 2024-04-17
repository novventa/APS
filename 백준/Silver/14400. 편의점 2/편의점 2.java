import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        Arrays.sort(x);
        Arrays.sort(y);

        long medianX = x[n / 2];
        long medianY = y[n / 2];

        long distanceSum = 0;
        for (int i = 0; i < n; i++) {
            distanceSum += Math.abs(x[i] - medianX) + Math.abs(y[i] - medianY);
        }

        System.out.println(distanceSum);
    }
}
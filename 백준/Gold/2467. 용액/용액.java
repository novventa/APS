import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int x = 0;
        int y = 0;

        Arrays.sort(arr);

        int s = 0;
        int e = n - 1;

        while (s < e) {
            int sum = arr[s] + arr[e];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                x = arr[s];
                y = arr[e];
            }

            if (sum < 0) {
                s++;
            } else {
                e--;
            }
        }

        System.out.println(x + " " + y);
    }
}
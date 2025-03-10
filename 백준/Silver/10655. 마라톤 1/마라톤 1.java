import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        long dist = 0;
        for (int i = 0; i < n - 1; i++) {
            dist += Math.abs(x[i] - x[i + 1]) + Math.abs(y[i] - y[i + 1]);
        }

        long max = 0;
        for (int i = 1; i <= n - 2; i++) {
            long d1 = Math.abs(x[i - 1] - x[i]) + Math.abs(y[i - 1] - y[i]);
            long d2 = Math.abs(x[i] - x[i + 1]) + Math.abs(y[i] - y[i + 1]);
            long directDist = Math.abs(x[i - 1] - x[i + 1]) + Math.abs(y[i - 1] - y[i + 1]);
            long cal = d1 + d2 - directDist;
            max = Math.max(max, cal);
        }

        System.out.println(dist - max);

    }
}

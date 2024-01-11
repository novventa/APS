import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] deg = new int[n + 1];
        int[] prefix_sum = new int[n + 1];
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            deg[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n - k + 1; i++) {
            for (int j = i; j < i + k; j++) {
                prefix_sum[i] += deg[j];
            }
            if(prefix_sum[i]>=max)
                max = prefix_sum[i];
        }

        System.out.println(max);

    }
}
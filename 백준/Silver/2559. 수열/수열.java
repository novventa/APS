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

        // 초기 부분합 계산
        for (int i = 1; i <= k; i++) {
            prefix_sum[1] += deg[i];
        }

        // 이전 부분합을 사용하여 현재 부분합 계산
        for (int i = 2; i <= n - k + 1; i++) {
            prefix_sum[i] = prefix_sum[i - 1] - deg[i - 1] + deg[i + k - 1];
        }

        // 최대값 찾기
        for (int i = 1; i <= n - k + 1; i++) {
            if (prefix_sum[i] >= max)
                max = prefix_sum[i];
        }

        System.out.println(max);
    }
}
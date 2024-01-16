import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];

        // 누적합 계산
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int maxSum = arr[0];
        int minPrefixSum = Math.min(0, prefixSum[0]);

        // 최대 부분합 계산
        for (int i = 1; i < n; i++) {
            maxSum = Math.max(maxSum, prefixSum[i] - minPrefixSum);
            minPrefixSum = Math.min(minPrefixSum, prefixSum[i]);
        }

        System.out.println(maxSum);
    }
}
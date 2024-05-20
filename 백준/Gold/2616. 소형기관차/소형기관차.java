import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] train = new int[N + 1];
        int[] trainSum = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            train[i] = Integer.parseInt(st.nextToken());
            trainSum[i] = trainSum[i - 1] + train[i];
        }
        
        int[][] dp = new int[4][N + 1];

        int max = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 3; i++) {
            for (int j = i * max; j <= N ; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - max] + trainSum[j] - trainSum[j - max]);
            }
        }

        System.out.println(dp[3][N]);
    }
}
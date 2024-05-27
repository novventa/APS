import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            System.out.println(countAdjacentBitsBottomUp(n, k));
        }
    }

    private static int countAdjacentBitsBottomUp(int n, int k) {
        int[][][] dp = new int[n + 1][k + 1][2];

        dp[1][0][0] = 1;
        dp[1][0][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
                if (j > 0) {
                    dp[i][j][1] = dp[i - 1][j][0] + dp[i - 1][j - 1][1];
                } else {
                    dp[i][j][1] = dp[i - 1][j][0];
                }
            }
        }

        return dp[n][k][0] + dp[n][k][1];
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] list_a;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list_a = new int[n][2];
        dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list_a[i][0] = Integer.parseInt(st.nextToken());
            list_a[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        recur(0);
        System.out.println(dp[0]);
    }

    static int recur(int day) {
        if (day > n) {
            return Integer.MIN_VALUE;
        }
        if (day == n) {
            return 0;
        }

        if (dp[day] != -1) {
            return dp[day];
        }

        dp[day] = Math.max(recur(day + list_a[day][0]) + list_a[day][1], recur(day + 1));
        return dp[day];
    }
}
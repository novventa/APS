import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        Arrays.fill(dp, -1);
        dp[0] = 0;

        System.out.println(recur(n));
    }

    static int recur(int n) {
        if(dp[n] != -1) return dp[n];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i++) {
            min = Math.min(min, recur(n - i * i) + 1);
        }
        dp[n] = min;
        return dp[n];
    }
}
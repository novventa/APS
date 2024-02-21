import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dp;
    static int[] arr = {1, 3, 4};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        Arrays.fill(dp, -1);

        if (recur(n)) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }

    public static boolean recur(int cur) {
        if (dp[cur] != -1) {
            return dp[cur] > 0;
        }
        if (cur == 0) {
            return true;
        }
        int cnt = 0;
        for (int i : arr) {
            if (cur - i >= 0 && recur(cur - i)) {
                cnt += 1;
            }
        }
        dp[cur] = cnt == 0 ? 1 : 0;
        return dp[cur] > 0;
    }
}
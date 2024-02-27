import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int t, n;
    static long[][] dp = new long[32][32];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                dp[i][j] = -1;
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0)
                break;

            System.out.println(recur(n, 0));
        }
    }

    static long recur(int cur, int cnt) {
        if (cur == 0 && cnt == 0) {
            return 1;
        }

        long ret = 0;

        if (dp[cur][cnt] != -1) {
            return dp[cur][cnt];
        }

        if (cur > 0) {
            if (cnt > 0)
                ret += recur(cur, cnt - 1);
            ret += recur(cur - 1, cnt + 1);
        } else if (cur == 0 && cnt > 0) {
            ret += recur(cur, cnt - 1);
        }

        dp[cur][cnt] = ret;

        return ret;
    }

}
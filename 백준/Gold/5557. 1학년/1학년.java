import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static long[][] dp;
    static List<Integer> a;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            a.add(Integer.parseInt(st.nextToken()));
        }

        dp = new long[n+1][21];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);

        System.out.println(recur(0, a.get(0)));
    }

    private static long recur(int i, int j) {
        if(j < 0 || j > 20)
            return 0;
        if(i == n-2) {
            if(a.get(a.size()-1) == j)
                return 1;
            else
                return 0;
        }
        if(dp[i][j] != -1)
            return dp[i][j];

        long ans = 0;
        ans += recur(i+1, j + a.get(i+1)) + recur(i+1, j - a.get(i+1));
        dp[i][j] = ans;
        return ans;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp;
    static Job[] arr;

    static class Job {
        int days;
        int cost;

        public Job(int days, int cost) {
            this.days = days;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        arr = new Job[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int days = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[i] = new Job(days, cost);
        }

        pro();

        br.close();
    }

    static void pro() {
        dp[N] = 0;
        for (int i = N - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], i + arr[i].days <= N ? dp[i + arr[i].days] + arr[i].cost : 0);
        }
        System.out.println(dp[0]);
    }
}
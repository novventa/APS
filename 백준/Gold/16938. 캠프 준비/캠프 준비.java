import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, l, r, x;
    static int[] dif;
    static int[] sel;
    static int ans;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        dif = new int[n];
        ans = 0;
        sel = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dif[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);

        System.out.println(ans);

    }

    private static void dfs(int idx, int depth, int sum) {
        if (idx == n) {
            if (sum >= l && sum <= r) {
                int max = 0;
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < depth; i++) {
                    max = Math.max(max, sel[i]);
                    min = Math.min(min, sel[i]);
                }
                if (max - min >= x)
                    ans++;
            }
            return;
        }

        sel[depth] = dif[idx];
        dfs(idx + 1, depth + 1, sum + dif[idx]);
        dfs(idx + 1, depth, sum);

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] sour;
    static int[] bitter;
    static int ans = Integer.MAX_VALUE;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        sour = new int[n];
        bitter = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        recur(0, 0, 1, 0);

        System.out.println(ans);

    }

    private static void recur(int cnt, int idx, int sourCnt, int bitterCnt) {
        if (idx == n) {
            if (cnt != 0)
                ans = Math.min(ans, Math.abs(sourCnt - bitterCnt));
            return;
        }

        recur(cnt, idx + 1, sourCnt, bitterCnt);
        recur(cnt + 1, idx + 1, sourCnt * sour[idx], bitterCnt + bitter[idx]);
    }

}
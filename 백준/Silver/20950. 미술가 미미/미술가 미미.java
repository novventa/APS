import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int R, G, B;
    static int newR, newG, newB;
    static int ans = Integer.MAX_VALUE;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        newR = 0;
        newG = 0;
        newB = 0;

        dfs(-1, 0);

        System.out.println(ans);

    }

    private static void dfs(int x, int num) {
        if (num >= 2)
            ans = Math.min(ans, Math.abs(newR / num - R) + Math.abs(newG / num - G) + Math.abs(newB / num - B));

        for (int i = x + 1; i < arr.length; i++) {
            newR += arr[i][0];
            newG += arr[i][1];
            newB += arr[i][2];
            if(num < 7)
                dfs(i, num + 1);

            newR -= arr[i][0];
            newG -= arr[i][1];
            newB -= arr[i][2];
        }
    }
}
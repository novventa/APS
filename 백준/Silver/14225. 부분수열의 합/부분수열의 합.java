import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int ans = 1;
    static int[] arr;
    static boolean[] visited = new boolean[2000010];
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recur(0, 0);

        while (visited[ans]) {
            ans++;
        }

        System.out.println(ans);

    }

    private static void recur(int idx, int sum) {
        if (idx == n)
            visited[sum] = true;
        else {
            recur(idx + 1, sum + arr[idx]);
            recur(idx + 1, sum);
        }
    }
}
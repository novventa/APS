import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[] ans;
    static boolean[] visited;
    static int max;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        ans = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recur(0);

        System.out.println(max);

    }

    private static void recur(int cnt) {
        if(cnt == n){
            int sum = 0;
            for(int i = 0; i < n-1; i++) {
                sum += Math.abs(ans[i] - ans[i+1]);
            }
            max = Math.max(max,sum);
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                ans[cnt] = arr[i];
                visited[i] = true;
                recur(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
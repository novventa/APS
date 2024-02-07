import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static int[] arr;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recur(0, 0);
        // If the target sum is 0, include the empty subset
        if (s == 0) {
            cnt--;
        }
        System.out.println(cnt);
    }

    static void recur(int index, int sum) {
        if (index == n) {
            if (sum == s) {
                cnt++;
            }
            return;
        }

        recur(index + 1, sum + arr[index]);
        recur(index + 1, sum);
    }
}
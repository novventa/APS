import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터 사용
        int cnt = 0;
        int s = 0, e = 0, sum = 0;

        while (true) {
            if (sum >= m) {
                sum -= arr[s++];
            } else if (e == n) {
                break;
            } else {
                sum += arr[e++];
            }

            if (sum == m) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
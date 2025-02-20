import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] nums;
    static int[] operators = new int[4];
    static long min = Long.MAX_VALUE;
    static long max = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, nums[0]);

        System.out.println(max);
        System.out.println(min);

    }

    static void dfs(int idx, int cur) {
        if (idx == n) {
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            return;
        }

        if (operators[0] > 0) {
            operators[0]--;
            dfs(idx + 1, cur + nums[idx]);
            operators[0]++;
        }

        if (operators[1] > 0) {
            operators[1]--;
            dfs(idx + 1, cur - nums[idx]);
            operators[1]++;
        }

        if (operators[2] > 0) {
            operators[2]--;
            dfs(idx + 1, cur * nums[idx]);
            operators[2]++;
        }

        if (operators[3] > 0) {
            operators[3]--;
            if (cur < 0) {
                dfs(idx + 1, - (Math.abs(cur) / nums[idx]));
            } else {
                dfs(idx + 1, cur / nums[idx]);
            }
            operators[3]++;
        }
    }
}
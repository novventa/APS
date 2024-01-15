import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int len = S.length();
        int[] prefix_sum = new int[len + 1];
        int[] idx = new int[300001];
        Arrays.fill(idx, Integer.MAX_VALUE);
        int[] kCnt = new int[len + 1];
        int[] sCnt = new int[len + 1];

        for (int i = 1; i <= len; i++) {
            prefix_sum[i] = prefix_sum[i - 1];
            kCnt[i] = kCnt[i - 1];
            sCnt[i] = sCnt[i - 1];
            if (S.charAt(i - 1) == 'S') {
                prefix_sum[i] += 2;
                sCnt[i] += 1;
            } else if (S.charAt(i - 1) == 'K') {
                prefix_sum[i] -= 1;
                kCnt[i] += 1;
            }
        }

        int ans = -1;

        for (int i = 0; i <= len; i++) {
            idx[prefix_sum[i] + 100000] = Math.min(idx[prefix_sum[i] + 100000], i);
        }

        for (int i = 1; i <= len; i++) {
            int left = idx[prefix_sum[i] + 100000];
            int skk_len = i - left;
            int k_cnt = kCnt[i] - kCnt[left];
            int s_cnt = sCnt[i] - sCnt[left];

            if (k_cnt != 0 && s_cnt != 0) {
                ans = Math.max(ans, skk_len);
            }
        }

        System.out.println(ans);
    }
}
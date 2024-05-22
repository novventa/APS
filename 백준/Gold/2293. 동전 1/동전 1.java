import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n+1];
        int[] cnt = new int[k+1];
        cnt[0] = 1;

        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = coins[0]; j <= k; j++) {
                if(j<coins[i])
                    continue;
                cnt[j] += cnt[j-coins[i]];
            }
        }

        System.out.println(cnt[k]);
        
    }
}
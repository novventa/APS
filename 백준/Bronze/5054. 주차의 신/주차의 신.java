import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int T = 0; T < t; T++) {
            int n = Integer.parseInt(br.readLine());

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                int pos = Integer.parseInt(st.nextToken());
                min = Math.min(min, pos);
                max = Math.max(max, pos);
            }

            int ans = 2 * (max - min);

            System.out.println(ans);

        }
    }
}
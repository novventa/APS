import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] genres = new ArrayList[11];
        for(int i = 1; i <= 10; i++){
            genres[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int genre = Integer.parseInt(st.nextToken());
            genres[genre].add(price);
        }

        int[][] genreDP = new int[11][];
        for(int g =1; g <= 10; g++) {
            ArrayList<Integer> list = genres[g];

            int size = list.size();

            Collections.sort(list, Collections.reverseOrder());

            int maxT = Math.min(size, k);

            genreDP[g] = new int[maxT + 1];
            genreDP[g][maxT] = 0;

            for (int t = 1; t <= maxT; t++) {
                genreDP[g][t] = genreDP[g][t - 1] + list.get(t - 1);
            }
        }

        int[] dp = new int[k + 1];

        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for(int g = 1; g <= 10;g++) {
            int[] newDP = new int[k + 1];
            Arrays.fill(newDP, Integer.MIN_VALUE);

            int maxT = genreDP[g].length - 1;
            for (int x = 0; x <= k; x++) {
                if(dp[x] == Integer.MIN_VALUE) continue;

                for (int t = 0; t <= maxT && x + t <= k; t++) {
                    int contribution = genreDP[g][t] + t * (t - 1);
                    newDP[x + t] = Math.max(newDP[x + t], dp[x] + contribution);
                }
            }
            dp = newDP;
        }

        System.out.println(dp[k]);
    }
}
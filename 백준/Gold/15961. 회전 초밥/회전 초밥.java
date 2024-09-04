import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] sushiCnt = new int[d + 1];
        int total = 0;

        for (int i = 0; i < k; i++) {
            if (sushiCnt[sushi[i]] == 0) total++;
            sushiCnt[sushi[i]]++;
        }

        int max = total;
        if (sushiCnt[c] == 0) max++;

        for (int i = 1; i < n; i++) {
            int removeIdx = sushi[i - 1];
            sushiCnt[removeIdx]--;
            if (sushiCnt[removeIdx] == 0) total--;

            int addIdx = sushi[(i + k - 1) % n];
            if (sushiCnt[addIdx] == 0) total++;
            sushiCnt[addIdx]++;

            int currentKinds = total;
            if (sushiCnt[c] == 0) currentKinds++;

            max = Math.max(max, currentKinds);
        }

        System.out.println(max);

    }
}
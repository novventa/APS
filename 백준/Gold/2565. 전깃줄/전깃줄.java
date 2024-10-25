import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static class Pair {
        int a,b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    static int n;
    static Pair[] wires;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        wires = new Pair[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int aPosition = Integer.parseInt(st.nextToken());
            int bPosition = Integer.parseInt(st.nextToken());
            wires[i] = new Pair(aPosition, bPosition);
        }

        Arrays.sort(wires, Comparator.comparingInt(o -> o.a));

        int[] dp = new int[n];
        int length = 0;

        for (int i = 0; i < n; i++) {
            int b = wires[i].b;
            int idx = Arrays.binarySearch(dp, 0, length, b);
            if(idx < 0)
                idx = -(idx + 1);
            dp[idx] = b;
            if(idx==length) length++;
        }

        int minRemoval = n - length;

        System.out.println(minRemoval);

    }
}
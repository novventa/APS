import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        int[] cnt = new int[1001];
        cnt[0] = 0;

        int ans = 0;
        for (int x = 1; x <= 1000; x++) {
            for (int y = 1; y < x; y++) {
                if (gcd(x, y) == 1)
                    ans++;
            }
            cnt[x] = ans;
        }

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(cnt[n] * 2 + 3);
        }
    }

    // 최대공약수를 구하는 함수
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
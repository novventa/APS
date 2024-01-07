import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long ans = 0;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            int k = n / i;
            ans += (long) i * (k - i + 1) + (long) (k - i) * (k + i + 1) / 2;
            ans %= 1000000;
        }

        System.out.println(ans);

    }
}
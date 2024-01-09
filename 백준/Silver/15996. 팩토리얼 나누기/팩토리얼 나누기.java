import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());

        int result = maxPowerOfPrime(N, A);
        System.out.println(result);
    }

    // 소수의 최대 거듭제곱 찾기
    private static int maxPowerOfPrime(int N, int prime) {
        int power = 0;
        int divisor = prime;

        while (N / divisor > 0) {
            power += N / divisor;
            divisor *= prime;
        }

        return power;
    }
}
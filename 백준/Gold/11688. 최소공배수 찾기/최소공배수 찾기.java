import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long l = Long.parseLong(st.nextToken());

        if (lcm(a, b) == l) {
            System.out.println(1);
        } else if (l % lcm(a, b) != 0) {
            System.out.println(-1);
        } else {
            long ab = lcm(a, b);
            List<Long> divisors = divisor(l);

            for (long c : divisors) {
                if (lcm(ab, c) == l) {
                    System.out.println(c);
                    return;
                }
            }
        }
    }

    public static long gcd(long a, long b) {
        while (b > 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static List<Long> divisor(long n) {
        List<Long> can = new ArrayList<>();
        for (long i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                can.add(i);
                can.add(n / i);
            }
        }
        Collections.sort(can);
        return can;
    }
}
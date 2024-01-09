import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = A; i <= B; i++) {
            if (isPrime(i) && containsDigit(i, D)) {
                count++;
            }
        }

        System.out.println(count);
    }
    
    // 소수를 판별하는 함수
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 숫자 D가 소수에 포함되어 있는지 확인하는 함수
    public static boolean containsDigit(int num, int d) {
        while (num > 0) {
            if (num % 10 == d) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
}
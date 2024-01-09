import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int countZeroes = countTrailingZeroesInBinomialCoefficient(n, m);
        System.out.println(countZeroes);
    }

    // 이항 계수의 끝자리 0의 개수 계산
    private static int countTrailingZeroesInBinomialCoefficient(int n, int m) {
        int countOfTwos = countFactors(n, 2) - countFactors(m, 2) - countFactors(n - m, 2);
        int countOfFives = countFactors(n, 5) - countFactors(m, 5) - countFactors(n - m, 5);

        return Math.min(countOfTwos, countOfFives);
    }

    // 숫자에서 특정 인수의 개수 찾기
    private static int countFactors(int num, int factor) {
        int count = 0;
        while (num >= factor) {
            count += num / factor;
            num /= factor;
        }
        return count;
    }
}
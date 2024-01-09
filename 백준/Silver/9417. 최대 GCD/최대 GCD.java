import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int maxGCD = 0;

            // 입력으로 주어진 숫자 배열로 저장
            int[] numbers = new int[100]; // 문제 조건에 따라 최대 100개의 숫자 입력
            int idx = 0;

            while (st.hasMoreTokens()) {
                numbers[idx++] = Integer.parseInt(st.nextToken());
            }

            // 모든 두 수의 쌍의 최대공약수 중 가장 큰 값 찾기
            for (int i = 0; i < idx - 1; i++) {
                for (int j = i + 1; j < idx; j++) {
                    int currentGCD = gcd(numbers[i], numbers[j]);
                    maxGCD = Math.max(maxGCD, currentGCD);
                }
            }

            System.out.println(maxGCD);
        }
    }

    // 최대공약수를 구하는 함수 (유클리드 호제법)
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
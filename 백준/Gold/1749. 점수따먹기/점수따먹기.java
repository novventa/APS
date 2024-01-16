import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        long[][] m = new long[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= cols; j++) {
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                m[i][j] = m[i - 1][j] + m[i][j - 1] - m[i - 1][j - 1] + m[i][j];
            }
        }

        long mx = Long.MIN_VALUE;
        for (int c1 = 1; c1 <= cols; c1++) {
            for (int c2 = c1; c2 <= cols; c2++) {
                long last = 0; // dp[r - 1]과 동일한 역할
                for (int r = 1; r <= rows; r++) {
                    // [c1, c2]열 내에서 [r]행의 원소의 합
                    long sum = m[r][c2] - m[r][c1 - 1] - m[r - 1][c2] + m[r - 1][c1 - 1];

                    // 이전 행까지의 합을 포함할 것인지, 이번 행부터 새로 시작할 것인지 선택
                    last = max(last + sum, sum);

                    // mx 갱신
                    mx = max(mx, last);
                }
            }
        }

        System.out.println(mx);
    }

    static long max(long a, long b) {
        return a > b ? a : b;
    }
}
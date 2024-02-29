import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = 0;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                for (int k = 0; k <= N; k++) {
                    for (int l = 0; l <= M; l++) {
                        if (i == k && j == l) continue;

                        int cnt = 0;

                        if (i == k) cnt = Math.abs(j - l) + 1;
                        else if (j == l) cnt = Math.abs(i - k) + 1;
                        else if (Math.abs(i - k) == Math.abs(j - l)) cnt = Math.abs(i - k) + 1;
                        else {
                            int a = Math.abs(i - k);
                            int b = Math.abs(j - l);

                            int gcd = gcd(a, b);
                            cnt = gcd == 1 ? 2 : (b / (b / gcd)) + 1;
                        }

                        if (cnt == K) answer++;
                    }
                }
            }
        }

        System.out.println(answer / 2);
    }
}
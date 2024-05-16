import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int cnt = 0;
            int sqrtN = (int) Math.sqrt(N);
            for (int i = 1; i <= sqrtN; i++) {
                if (i * i == N) {
                    cnt++;
                    continue;
                }
                for (int j = i; j <= sqrtN; j++) {
                    if (i * i + j * j == N) {
                        cnt++;
                        break;
                    }
                    for (int k = j; k <= sqrtN; k++) {
                        if (i * i + j * j + k * k == N) {
                            cnt++;
                            break;
                        }
                        for (int l = k; l <= sqrtN; l++) {
                            if (i * i + j * j + k * k + l * l == N) {
                                cnt++;
                                break;
                            }
                            if (i * i + j * j + k * k + l * l > N) break;
                        }
                    }
                }
            }

            System.out.println(cnt);
            
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = countFlippedFlags(N);
        System.out.println(result);
    }

    public static int countFlippedFlags(int n) {
        int count = 0;

        for (int i = 1; i * i <= n; i++) {
            count++;
        }

        return count;
    }
}
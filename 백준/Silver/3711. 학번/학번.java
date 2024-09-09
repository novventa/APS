import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    static int[] arr, visit;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read(), g, m;
        while (n-- > 0) {
            arr = new int[g = read()];
            visit = new int[1000000];
            while (g-- > 0) arr[g] = read();

            m = 0;
            while (++m < Integer.MAX_VALUE) if (isDistinct(m)) break;

            sb.append(m).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isDistinct(int m) {
        for (int i : arr) {
            if (visit[i % m] == m) return false;
            visit[i % m] = m;
        }

        return true;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }
}
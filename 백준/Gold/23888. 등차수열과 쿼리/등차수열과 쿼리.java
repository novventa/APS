import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long a;
    static long d;
    static long ans_2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        a = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        long a1 = Math.max(a, d);
        long d1 = Math.min(a, d);

        ans_2 = gcd(a1, d1);

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            long l = Integer.parseInt(st.nextToken());
            long r = Integer.parseInt(st.nextToken());
            if (type == 1) {
                String s = String.valueOf(((a + (l - 1) * d) + (a + (r - 1) * d)) * (r - l + 1) / 2);
                bw.write(s);
                bw.newLine();
            } else {
                if (l == r) {
                    String s = String.valueOf((a + (l - 1) * d));
                    bw.write(s);
                    bw.newLine();
                } else {
                    String s = String.valueOf(ans_2);
                    bw.write(s);
                    bw.newLine();
                }
            }
        }
        bw.close();
    }

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        while (true) {
            if (a % b == 0)
                break;
            long tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }
}
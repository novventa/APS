import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs("");
    }

    static void dfs(String s) {
        if (found) {
            return;
        }

        if(s.length() == n){
            System.out.println(s);
            found = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            String next = s + i;
            if(isGood(next))
                dfs(next);
        }
    }

    static boolean isGood(String s) {
        int len = s.length();
        for (int i = 1; i * 2 <= len; i++) {
            String part1 = s.substring(len - i, len);
            String part2 = s.substring(len - 2 * i, len - i);
            if (part1.equals(part2))
                return false;
        }
        return true;
    }

}
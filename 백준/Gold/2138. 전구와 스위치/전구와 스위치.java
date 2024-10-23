import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static char[] initState;
    static char[] targetState;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        initState = br.readLine().toCharArray();
        targetState = br.readLine().toCharArray();

        int result1 = simulate(false);
        int result2 = simulate(true);

        int answer = -1;

        if(result1 != -1 &&  result2 != -1){
            answer = Math.min(result1, result2);
        } else if (result1 != -1) {
            answer = result1;
        } else if (result2 != -1) {
            answer = result2;
        }

        System.out.println(answer);
    }

    static int simulate(boolean pressFirst) {
        int count = 0;
        char[] bulbs = initState.clone();

        if (pressFirst) {
            pressSwitch(bulbs, 0);
            count++;
        }

        for (int i = 1; i < n; i++) {
            if (bulbs[i - 1] != targetState[i - 1]) {
                pressSwitch(bulbs, i);
                count++;
            }
        }

        if (isSame(bulbs, targetState)) {
            return count;
        } else {
            return -1;
        }
    }

    static void pressSwitch(char[] bulbs, int idx) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i >= 0 && i < n) {
                bulbs[i] = bulbs[i] == '0' ? '1' : '0';
            }
        }
    }

    static boolean isSame(char[] a, char[] b) {
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
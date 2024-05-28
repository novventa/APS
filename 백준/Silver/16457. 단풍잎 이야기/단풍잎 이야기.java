import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int n, m, k;
    static int[][] skills;
    static int[] batch;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] firstLine = br.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        m = Integer.parseInt(firstLine[1]);
        k = Integer.parseInt(firstLine[2]);

        skills = new int[m][k];
        for (int i = 0; i < m; i++) {
            String[] skillLine = br.readLine().split(" ");
            for (int j = 0; j < k; j++) {
                skills[i][j] = Integer.parseInt(skillLine[j]);
            }
        }

        batch = new int[n];
        answer = 0;

        pick(0, 0);

        System.out.println(answer);
    }

    public static void pick(int prev, int idx) {
        if (idx == n) {
            Set<Integer> tmp = new HashSet<>();
            for (int i = 0; i < n; i++) {
                tmp.add(batch[i]);
            }
            int cnt = 0;
            for (int[] sk : skills) {
                boolean canComplete = true;
                for (int s : sk) {
                    if (!tmp.contains(s)) {
                        canComplete = false;
                        break;
                    }
                }
                if (canComplete) {
                    cnt += 1;
                }
            }
            if (cnt > answer) {
                answer = cnt;
            }
            return;
        }
        for (int i = prev + 1; i <= 2 * n; i++) {
            batch[idx] = i;
            pick(i, idx + 1);
        }
    }
}
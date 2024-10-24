import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m;
    static boolean[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        adj = new boolean[n+1][n+1];

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int heavy = Integer.parseInt(s[0]);
            int light = Integer.parseInt(s[1]);
            adj[heavy][light] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (adj[i][k]) {
                    for (int j = 1; j <= n; j++) {
                        if (adj[k][j]) {
                            adj[i][j] = true;
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int count = 0;

            for (int j = 1; j <= n; j++) {
                if (i == j) continue;

                if (!adj[i][j] && !adj[j][i]) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
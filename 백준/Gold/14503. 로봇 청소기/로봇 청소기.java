import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, r, c, d, ans;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);
        System.out.println(ans);
    }

    static void clean(int x, int y, int dir) {
        if (!visited[x][y]) {
            visited[x][y] = true;
            ans++;
        }

        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    clean(nx, ny, dir);
                    return;
                }
            }
        }

        int nx = x - dx[dir];
        int ny = y - dy[dir];
        if (map[nx][ny] == 0) {
            clean(nx, ny, dir);
        }
    }
}
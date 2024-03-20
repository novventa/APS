import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Knight {
        int x;
        int y;
        int cnt;

        public Knight(int x, int y) {
            this.x = x;
            this.y = y;
            cnt = 0;
        }

        public Knight(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int n;
    static int ans;
    static int[][] map;
    static int gx, gy;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            map = new int[n][n];

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Knight knight = new Knight(x, y);

            st = new StringTokenizer(br.readLine());

            gx = Integer.parseInt(st.nextToken());
            gy = Integer.parseInt(st.nextToken());

            bfs(knight);

            System.out.println(ans);
        }
    }

    private static void bfs(Knight knight) {
        Queue<Knight> q = new LinkedList<>();
        q.add(knight);

        boolean[][] visited = new boolean[n][n];

        while (!q.isEmpty()) {
            Knight cur = q.poll();

            if (cur.x == gx && cur.y == gy) {
                ans = cur.cnt;
                return;
            }

            for (int d = 0; d < 8; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Knight(nx, ny, cur.cnt + 1));
                }
            }
        }
    }
}
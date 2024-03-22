import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int cheese;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringTokenizer st;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int cnt;
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cheese = 0;

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    cheese++;
            }
        }

        cnt = 0;
        time = 0;

        bfs();

        System.out.println(time);
        System.out.println(cnt);
    }

    private static void bfs() {
        while (cheese != 0) {
            cnt = cheese;
            time++;
            visited = new boolean[n][m];

            Queue<Point> q = new LinkedList<>();

            q.add(new Point(0, 0));
            visited[0][0] = true;

            while (!q.isEmpty()) {
                Point cur = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        if (map[nx][ny] == 0)
                            q.add(new Point(nx, ny));
                        else {
                            cheese--;
                            map[nx][ny] = 0;
                        }
                    }
                }
            }
        }
    }
}
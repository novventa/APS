import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int tc;
    static int[][] map;
    static int[][] cost;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringTokenizer st;

    static class Link implements Comparable<Link> {
        int x, y;
        int rupee;

        public Link(int x, int y, int rupee) {
            this.x = x;
            this.y = y;
            this.rupee = rupee;
        }

        @Override
        public int compareTo(Link o) {
            return Integer.compare(this.rupee, o.rupee);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = 1;

        while (true) {
            n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            map = new int[n][n];
            cost = new int[n][n];
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs();

            System.out.printf("Problem %d: %d", tc, cost[n - 1][n - 1]);
            System.out.println();

            tc++;
        }
    }

    private static void bfs() {
        PriorityQueue<Link> pq = new PriorityQueue<>();

        pq.add(new Link(0, 0, map[0][0]));
        cost[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Link link = pq.poll();

            int x = link.x;
            int y = link.y;

            if (visited[x][y])
                continue;

            visited[x][y] = true;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;

                if (!visited[nx][ny] && cost[nx][ny] > cost[x][y] + map[nx][ny]) {
                    cost[nx][ny] = cost[x][y] + map[nx][ny];
                    pq.offer(new Link(nx, ny, cost[nx][ny]));
                }
            }
        }
    }
}
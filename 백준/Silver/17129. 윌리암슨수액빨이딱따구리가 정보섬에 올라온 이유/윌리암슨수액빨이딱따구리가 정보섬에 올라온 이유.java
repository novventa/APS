import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 }; // directions: up, down, left, right
    static int[] dy = { 0, 0, -1, 1 };

    static class Position {
        int x, y, dist;

        public Position(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        // Use BufferedReader and StringTokenizer for input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new boolean[n][m];
        int startX = -1, startY = -1;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = s.charAt(j);
                grid[i][j] = ch - '0';
                if (grid[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(startX, startY, 0));
        visited[startX][startY] = true;

        boolean found = false;
        int minDistance = -1;

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int x = pos.x;
            int y = pos.y;
            int dist = pos.dist;

            if (grid[x][y] == 3 || grid[x][y] == 4 || grid[x][y] == 5) {
                found = true;
                minDistance = dist;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && grid[nx][ny] != 1) {
                        visited[nx][ny] = true;
                        queue.offer(new Position(nx, ny, dist + 1));
                    }
                }
            }
        }

        if (found) {
            System.out.println("TAK");
            System.out.println(minDistance);
        } else {
            System.out.println("NIE");
        }
    }
}
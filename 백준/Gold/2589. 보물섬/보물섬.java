import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c, max;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x;
        int y;
        int l;

        public Node(int x, int y, int l) {
            this.x = x;
            this.y = y;
            this.l = l;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'L') {
                    visited = new boolean[r][c];
                    bfs(new Node(i, j, 0));
                }
            }
        }

        System.out.println(max);
    }

    private static void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited[node.x][node.y] = true;

        while (!q.isEmpty()) {
            Node next = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = next.x + dx[d];
                int ny = next.y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c && !visited[nx][ny] && map[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, next.l + 1));
                    max = Math.max(max, next.l + 1);
                }
            }
        }
    }
}
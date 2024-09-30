import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r,c;
    static char[][] map;
    static boolean[][] visited;
    static int totalShip = 0, totalWolves = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};; // 위 아래 왼쪽 오른쪽

    static class AreaResult {
        int sheep;
        int wolves;
        boolean canEscape;

        public AreaResult(int sheep, int wolves, boolean canEscape) {
            this.sheep = sheep;
            this.wolves = wolves;
            this.canEscape = canEscape;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            String s = br.readLine();
            map[i] = s.toCharArray();
        }

        for(int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(!visited[i][j] && map[i][j] != '#') {
                    AreaResult result = bfs(i,j);
                    if(!result.canEscape) {
                        if(result.sheep > result.wolves)
                            totalShip += result.sheep;
                        else
                            totalWolves += result.wolves;
                    }
                }
            }
        }

        System.out.println(totalShip + " " + totalWolves);

    }

    static AreaResult bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });
        visited[x][y] = true;

        int sheep = 0;
        int wolves = 0;
        boolean canEscape = false;

        if (map[x][y] == 'o') sheep++;
        if (map[x][y] == 'v') wolves++;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int cx = pos[0];
            int cy = pos[1];

            if (cx == 0 || cx == r - 1 || cy == 0 || cy == c - 1) {
                canEscape = true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (!visited[nx][ny] && map[nx][ny] != '#') {
                        visited[nx][ny] = true;
                        queue.offer(new int[] { nx, ny });

                        if (map[nx][ny] == 'o') sheep++;
                        if (map[nx][ny] == 'v') wolves++;
                    }
                }
            }
        }

        return new AreaResult(sheep, wolves, canEscape);
    }
}
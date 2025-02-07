import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map = new int[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());

        int[][] pos = new int[7][2];
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                int num = map[i][j];
                if(num >= 1 && num <= 6){
                    pos[num][0] = i;
                    pos[num][1] = j;
                }
            }
        }

        int totalDist = 0;
        int curR = startR;
        int curC = startC;

        for(int g = 1; g<=6; g++){
            int dist = bfs(curR, curC, pos[g][0], pos[g][1]);
            if(dist == -1) {
                System.out.println(-1);
                return;
            }
            totalDist += dist;
            curR = pos[g][0];
            curC = pos[g][1];
        }

        System.out.println(totalDist);
    }

    static int bfs(int sr, int sc, int tr, int tc) {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], d = cur[2];
            if (r == tr && c == tc) {
                return d;
            }

            for (int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] == -1) continue;
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc, d + 1});
            }
        }
        return -1;
    }
}
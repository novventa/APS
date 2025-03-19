import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, min = Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<CCTV> cctvs = new ArrayList<>();
    static class CCTV {
        int type, x, y;

        public CCTV(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int[][][] directions = {
            {},
            { {0}, {1}, {2}, {3} },
            { {0,2}, {1,3} },
            { {0,1}, {1,2}, {2,3}, {3,0} },
            { {0,1,2}, {1,2,3}, {2,3,0}, {3,0,1} },
            { {0,1,2,3} }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5)
                    cctvs.add(new CCTV(map[i][j], i, j));
            }
        }

        dfs(0, map);
        System.out.println(min);

    }

    static void dfs(int idx, int[][] office) {
        if (idx == cctvs.size()) {
            int cnt = 0;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if (office[i][j] == 0) cnt++;
                }
            }
            min = Math.min(min, cnt);
            return;
        }
        CCTV cur = cctvs.get(idx);
        int type = cur.type;

        for (int d = 0; d < directions[type].length; d++){
            int[][] newMap = copy(office);
            int[] dirs = directions[type][d];
            for (int dir : dirs) {
                monitor(newMap, cur.x, cur.y, dir);
            }
            dfs(idx + 1, newMap);
        }
    }

    static void monitor(int[][] map, int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        while (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 6) {
            if (map[nx][ny] == 0) {
                map[nx][ny] = -1;
            }
            nx += dx[dir];
            ny += dy[dir];
        }
    }

    static int[][] copy(int[][] map) {
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++){
            copyMap[i] = map[i].clone();
        }
        return copyMap;
    }
}
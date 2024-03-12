import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static char[][] map;
    static int cnt;
    static StringTokenizer st;
    static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}}; // 오른쪽 대각선 위, 오른쪽, 오른쪽 대각선 아래
    static boolean[][] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];
        cnt = 0;

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            flag = false;
            dfs(i, 0);
        }
        System.out.println(cnt);
    }

    private static void dfs(int x, int y) {
        if (y == c - 1) {
            cnt++;
            flag = true; // 파이프라인 완성했을 경우
            visited[x][y] = true;
            return;
        }

        for (int d = 0; d < 3; d++) {
            int dr = x + dir[d][0];
            int dc = y + dir[d][1];
            if (isOkay(dr, dc) && visited[dr][dc] == false && map[dr][dc] == '.') {
                dfs(dr, dc);
                if (flag) {
                    // 하나 완성했을때, 방문했던 곳 표시, 다른곳 탐색할 필요x
                    visited[x][y] = true;
                    return;
                } else {
                    // 완성하지 못했을 경우, 안되는 경로 표시
                    visited[x][y] = true;
                }
            }
        }
    }

    // 범위 확인
    private static boolean isOkay(int x, int y) {
        return x >= 0 && y >= 0 && x < r && y < c;
    }
}
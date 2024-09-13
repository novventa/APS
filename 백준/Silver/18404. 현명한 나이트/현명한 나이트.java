import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 체스판 크기 N
        int m = Integer.parseInt(st.nextToken());  // 상대편 말의 수 M

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1;  // 나이트의 X 좌표 (1-based -> 0-based)
        int y = Integer.parseInt(st.nextToken()) - 1;  // 나이트의 Y 좌표 (1-based -> 0-based)

        // 상대편 말들의 위치 저장 (1-based -> 0-based)
        int[] A = new int[m];
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken()) - 1;
            B[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        // 나이트의 이동 방향 8가지
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        // 거리 배열 (-1로 초기화, 아직 방문하지 않은 위치)
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        dist[x][y] = 0;  // 나이트의 시작 위치는 0

        // BFS를 위한 큐
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        // BFS를 사용한 탐색
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            // 나이트가 이동할 수 있는 8방향 탐색
            for (int i = 0; i < 8; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                // 체스판 범위 안에 있고, 아직 방문하지 않은 위치
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[curX][curY] + 1;  // 이동 거리 기록
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        // 각 상대편 말까지의 최단 거리를 출력
        for (int i = 0; i < m; i++) {
            System.out.print(dist[A[i]][B[i]]);
            if (i != m - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
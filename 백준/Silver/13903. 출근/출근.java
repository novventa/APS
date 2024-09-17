import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, N;
    static boolean[][] board;
    static int[][] rule;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // R: 행, C: 열 입력 받기
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 보드 상태 입력
        board = new boolean[R + 1][C + 1];
        visited = new boolean[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        // 규칙 입력 받기
        N = Integer.parseInt(br.readLine());
        rule = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            rule[i][0] = r;
            rule[i][1] = c;
        }

        // BFS 탐색을 통해 결과 얻기
        int result = bfs();
        System.out.println(result);
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();

        // 1행에서 이동 가능한 모든 위치를 큐에 넣음
        for (int i = 1; i <= C; i++) {
            if (board[1][i]) {
                q.offer(new int[]{1, i});
                visited[1][i] = true;
            }
        }

        int moveCnt = 0;
        int moveCntTemp = q.size();
        boolean isMoved = false;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int X = cur[0];
            int Y = cur[1];

            // 도착 행 (마지막 행) 에 도달하면 종료
            if (X == R) {
                isMoved = true;
                break;
            }

            // 규칙을 사용하여 이동
            for (int i = 1; i <= N; i++) {
                int r = rule[i][0];
                int c = rule[i][1];
                int newX = X + r;
                int newY = Y + c;

                // 범위 안에 있고, 아직 방문하지 않은 위치만 처리
                if (newX >= 1 && newX <= R && newY >= 1 && newY <= C) {
                    if (visited[newX][newY] || !board[newX][newY]) continue;
                    visited[newX][newY] = true;
                    q.offer(new int[]{newX, newY});
                }
            }

            moveCntTemp--;
            if (moveCntTemp == 0) {
                moveCnt++;
                moveCntTemp = q.size();
            }
        }

        // 마지막 행에 도달했는지 확인
        return isMoved ? moveCnt : -1;
    }
}
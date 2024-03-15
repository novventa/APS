import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] box;
    static boolean[][] isVisited;
    static int[] dRow = {0, 0, -1, 1};
    static int[] dCol = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // 상자의 가로 길이
        N = sc.nextInt(); // 상자의 세로 길이

        // 상자 정보 입력 받기
        box = new int[N][M];
        isVisited = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                box[r][c] = sc.nextInt();
            }
        }

        // BFS 수행
        int days = bfs();
        
        // 결과 출력
        if (isRipe()) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }

    public static int bfs() {
        int days = 0;
        Queue<int[]> q = new LinkedList<>();

        // 익은 토마토들을 큐에 넣기
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (box[r][c] == 1) {
                    q.offer(new int[]{r, c});
                    isVisited[r][c] = true;
                }
            }
        }

        // BFS 수행
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                // 인접한 안 익은 토마토를 큐에 추가
                for (int j = 0; j < 4; j++) {
                    int nRow = r + dRow[j];
                    int nCol = c + dCol[j];

                    if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= M) continue;

                    if (box[nRow][nCol] == 0 && !isVisited[nRow][nCol]) {
                        box[nRow][nCol] = 1;
                        isVisited[nRow][nCol] = true;
                        q.offer(new int[]{nRow, nCol});
                    }
                }
            }
            if (!q.isEmpty()) days++; // 익은 토마토가 없으면 days 증가하지 않음
        }

        return days;
    }

    // 토마토가 모두 익었는지 확인하는 함수
    public static boolean isRipe() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (box[r][c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

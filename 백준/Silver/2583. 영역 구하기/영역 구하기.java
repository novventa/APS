import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N, K;
    static int[][] grid;
    static List<Integer> areas = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1}; // 좌, 우
    static int[] dy = {-1, 1, 0, 0}; // 상, 하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // M, N, K 입력
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 행 수 (Y 좌표)
        N = Integer.parseInt(st.nextToken()); // 열 수 (X 좌표)
        K = Integer.parseInt(st.nextToken());

        grid = new int[M][N];

        // 직사각형 영역 표시
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()); // 왼쪽 아래 x좌표
            int y1 = Integer.parseInt(st.nextToken()); // 왼쪽 아래 y좌표
            int x2 = Integer.parseInt(st.nextToken()); // 오른쪽 위 x좌표
            int y2 = Integer.parseInt(st.nextToken()); // 오른쪽 위 y좌표

            // 직사각형 내부를 1로 표시 (막힌 영역)
            for (int y = y1; y < y2; y++) { // y는 y1부터 y2-1까지
                for (int x = x1; x < x2; x++) { // x는 x1부터 x2-1까지
                    grid[y][x] = 1; // 막힌 영역 표시
                }
            }
        }

        // BFS를 통해 각 영역의 넓이 계산
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (grid[y][x] == 0) { // 방문하지 않은 영역인 경우
                    int area = bfs(y, x);
                    areas.add(area);
                }
            }
        }

        // 결과 출력
        Collections.sort(areas); // 넓이를 오름차순으로 정렬
        System.out.println(areas.size()); // 분리된 영역의 개수 출력
        for (int i = 0; i < areas.size(); i++) {
            System.out.print(areas.get(i));
            if (i != areas.size() -1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    // BFS 알고리즘 구현
    static int bfs(int startY, int startX) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startY, startX));
        grid[startY][startX] = 1; // 방문 표시
        int area = 1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int y = p.y;
            int x = p.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                // 범위 내에 있고, 방문하지 않은 경우
                if (ny >= 0 && ny < M && nx >= 0 && nx < N && grid[ny][nx] == 0) {
                    grid[ny][nx] = 1; // 방문 표시
                    queue.offer(new Point(ny, nx));
                    area++;
                }
            }
        }
        return area;
    }

    // 좌표를 나타내는 클래스
    static class Point {
        int y, x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
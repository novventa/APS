import java.util.Scanner;

public class Main {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point[] p = new Point[4];
    static double[][] dist = new double[4][4];
    static boolean[] visit = new boolean[4];
    static int ans = (int) 1e5;

    static double dfs(int idx, double sum, int cnt) {
        if (cnt == 4) {
            ans = Math.min(ans, (int) sum);
            return 0;
        }
        if (visit[idx]) return 0;
        visit[idx] = true;
        for (int i = 0; i < 4; i++) {
            dfs(i, sum + dist[idx][i], cnt + 1);
        }
        visit[idx] = false;

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            p[i] = new Point(x, y);
        }

        for (int i = 0; i < 4; i++) {
            int x = p[i].x;
            int y = p[i].y;
            for (int j = i + 1; j < 4; j++) {
                int tx = p[j].x;
                int ty = p[j].y;
                double d = Math.sqrt((x - tx) * (x - tx) + (y - ty) * (y - ty));
                dist[i][j] = dist[j][i] = d;
            }
        }

        dfs(0, 0.0, 0);

        System.out.println(ans);
    }
}
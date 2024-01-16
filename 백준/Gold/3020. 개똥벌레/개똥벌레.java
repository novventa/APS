import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] obstaclesUp = new int[H + 1]; // 석순의 높이별 개수
        int[] obstaclesDown = new int[H + 1]; // 종유석의 높이별 개수

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                obstaclesUp[height]++;
            } else {
                obstaclesDown[height]++;
            }
        }

        // 누적합 계산
        for (int i = H - 1; i >= 1; i--) {
            obstaclesUp[i] += obstaclesUp[i + 1];
            obstaclesDown[i] += obstaclesDown[i + 1];
        }

        int minDestroyed = Integer.MAX_VALUE;
        int countMinDestroyed = 0;

        // 각 높이마다 파괴해야 하는 장애물 수 계산
        for (int i = 1; i <= H; i++) {
            int destroyed = obstaclesUp[i] + obstaclesDown[H - i + 1];

            if (destroyed < minDestroyed) {
                minDestroyed = destroyed;
                countMinDestroyed = 1;
            } else if (destroyed == minDestroyed) {
                countMinDestroyed++;
            }
        }

        System.out.println(minDestroyed + " " + countMinDestroyed);

    }
}
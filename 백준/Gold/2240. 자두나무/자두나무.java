import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] firstLine = br.readLine().split(" ");
            int T = Integer.parseInt(firstLine[0]);
            int W = Integer.parseInt(firstLine[1]);
            int[] treeArr = new int[T + 1];
            int[][][] dp = new int[T + 1][W + 1][3];

            for (int i = 1; i <= T; i++) {
                treeArr[i] = Integer.parseInt(br.readLine());
            }

            // 초기 값 설정
            if (treeArr[1] == 1) { // 1초일 때, 첫 번째 자두가 1번 나무에서 떨어질 경우
                dp[1][0][1] = 1; // 1초일 때, 0번 이동해서 현재 위치 그대로(1번 나무) -> 자두 1개
                dp[1][1][2] = 0; // 1초일 때, 1번 이동해서 현재 위치 바뀌고(2번 나무) -> 자두 0개
            } else { // 1초일 때, 첫 번째 자두가 2번 나무에서 떨어질 경우
                dp[1][0][1] = 0; // 1초일 때, 0번 이동해서 현재 위치 그대로(1번 나무) -> 자두 0개
                dp[1][1][2] = 1; // 1초일 때, 1번 이동해서 현재 위치 바뀌고(2번 나무) -> 자두 1개
            }

            for (int t = 2; t <= T; t++) {
                if (treeArr[t] == 1) { // 1번 자두나무에서 자두가 떨어질 때
                    dp[t][0][1] = dp[t - 1][0][1] + 1; // 0번 이동, 현재 위치 그대로 (1번 나무) -> 자두 1개 추가
                    dp[t][0][2] = dp[t - 1][0][2]; // 0번 이동, 현재 위치 그대로 (2번 나무) -> 자두 개수 유지

                    for (int w = 1; w <= W; w++) {
                        dp[t][w][1] = Math.max(dp[t - 1][w][1], dp[t - 1][w - 1][2]) + 1; // 1번 나무에 있을 때 (자두 1개 추가)
                        dp[t][w][2] = Math.max(dp[t - 1][w - 1][1], dp[t - 1][w][2]); // 2번 나무에 있을 때 (자두 개수 유지)
                    }
                } else { // 2번 자두나무에서 자두가 떨어질 때
                    dp[t][0][1] = dp[t - 1][0][1]; // 0번 이동, 현재 위치 그대로 (1번 나무) -> 자두 개수 유지
                    dp[t][0][2] = dp[t - 1][0][2] + 1; // 0번 이동, 현재 위치 그대로 (2번 나무) -> 자두 1개 추가

                    for (int w = 1; w <= W; w++) {
                        dp[t][w][1] = Math.max(dp[t - 1][w][1], dp[t - 1][w - 1][2]); // 1번 나무에 있을 때 (자두 개수 유지)
                        dp[t][w][2] = Math.max(dp[t - 1][w - 1][1], dp[t - 1][w][2]) + 1; // 2번 나무에 있을 때 (자두 1개 추가)
                    }
                }
            }

            int ans = 0; // 최대 자두 개수
            for (int w = 0; w <= W; w++) {
                ans = Math.max(ans, Math.max(dp[T][w][1], dp[T][w][2]));
            }
            System.out.println(ans);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
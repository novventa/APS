import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[N + 1];
        Arrays.fill(ans, 1 << 30);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int mid_x = arr[i][0];
                int mid_y = arr[j][1];

                int[] distance = new int[N];
                for (int h = 0; h < N; h++) {
                    distance[h] = Math.abs(mid_x - arr[h][0]) + Math.abs(mid_y - arr[h][1]);
                }
                Arrays.sort(distance);
                int sum = 0;
                for (int dist = 0; dist < N; dist++) {
                    sum += distance[dist];
                    if (ans[dist + 1] > sum) {
                        ans[dist + 1] = sum;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

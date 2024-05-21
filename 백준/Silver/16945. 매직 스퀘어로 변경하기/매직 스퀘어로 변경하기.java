import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[3][3];
    static boolean[] visited = new boolean[10];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        System.out.println(min);
    }
    
    static boolean isSquare(int diagonal) {
        for (int i = 0; i < 3; i++) {
            int horizontal = 0, vertical = 0;
            for (int j = 0; j < 3; j++) {
                horizontal += arr[i][j];
                vertical += arr[j][i];
            }
            if (horizontal != diagonal || vertical != diagonal) return false;
        }
        return true;
    }
    
    static void dfs(int depth, int idx, int sum) {
        if (idx == 3) {
            dfs(depth + 1, 0, sum);
            return;
        }
        if (depth == 3) {
            int diagonal = 0;
            for (int i = 0; i < 3; i++) {
                diagonal += arr[i][i];
            }
            if (diagonal == arr[2][0] + arr[1][1] + arr[0][2]) {
                if (isSquare(diagonal)) {
                    min = Math.min(min, sum);
                }
            }
            return;
        }
        int tmp = arr[depth][idx];
        for (int i = 1; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth][idx] = i;
                dfs(depth, idx + 1, sum + Math.abs(tmp - i));
                arr[depth][idx] = tmp;
                visited[i] = false;
            }
        }
    }
}
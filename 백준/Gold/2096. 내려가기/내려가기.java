import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] dpMax;
    static int[][] dpMin;
    static int[][] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dpMax = new int[n][3];
        dpMin = new int[n][3];

        arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            Arrays.fill(dpMax[i], -1);
            Arrays.fill(dpMin[i], 987654321);
        }
        int max = Math.max(Math.max(recurMax(0, 0), recurMax(0, 1)), recurMax(0, 2));
        int min = Math.min(Math.min(recurMin(0, 0), recurMin(0, 1)), recurMin(0, 2));

        System.out.println(max + " " + min);

    }

    static int recurMax(int i, int j) {
        if (dpMax[i][j] != -1)
            return dpMax[i][j];
        if (i == n - 1)
            return arr[i][j];
        dpMax[i][j] = 0;
        if (j == 0)
            dpMax[i][j] = arr[i][j] + Math.max(recurMax(i + 1, 0), recurMax(i + 1, 1));
        else if (j == 1)
            dpMax[i][j] = arr[i][j] + Math.max(recurMax(i + 1, 0), Math.max(recurMax(i + 1, 1), recurMax(i + 1, 2)));
        else if (j == 2)
            dpMax[i][j] = arr[i][j] + Math.max(recurMax(i + 1, 1), recurMax(i + 1, 2));
        return dpMax[i][j];
    }

    static int recurMin(int i, int j) {
        if (dpMin[i][j] != 987654321)
            return dpMin[i][j];
        if (i == n - 1)
            return arr[i][j];
        dpMin[i][j] = 0;
        if (j == 0)
            dpMin[i][j] = arr[i][j] + Math.min(recurMin(i + 1, 0), recurMin(i + 1, 1));
        else if (j == 1)
            dpMin[i][j] = arr[i][j] + Math.min(recurMin(i + 1, 0), Math.min(recurMin(i + 1, 1), recurMin(i + 1, 2)));
        else if (j == 2)
            dpMin[i][j] = arr[i][j] + Math.min(recurMin(i + 1, 1), recurMin(i + 1, 2));
        return dpMin[i][j];
    }

}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 행렬 크기 입력 받기
        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);
        
        int[][] matrix = new int[N][M];
        
        // 행렬 데이터 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = line.charAt(j) - '0';
            }
        }
        
        int maxArea = 0;
        int[][] dp = new int[N][M]; // dp[i][j]는 (i, j)에서 끝나는 최대 정사각형의 한 변의 길이
        
        // DP 테이블 채우기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1; // 첫 행이나 첫 열은 자기 자신이 최대 정사각형
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    maxArea = Math.max(maxArea, dp[i][j]);
                }
            }
        }
        
        // 최대 정사각형의 크기를 정사각형이 아닌 부분 행렬로 확장
        int[][] maxRow = new int[N][M]; // maxRow[i][j]는 (i, j)에서 끝나는 최대 0으로 이루어진 연속 행의 길이
        int[][] maxCol = new int[N][M]; // maxCol[i][j]는 (i, j)에서 끝나는 최대 0으로 이루어진 연속 열의 길이
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 0) {
                    maxRow[i][j] = (j == 0) ? 1 : maxRow[i][j-1] + 1;
                    maxCol[i][j] = (i == 0) ? 1 : maxCol[i-1][j] + 1;
                } else {
                    maxRow[i][j] = 0;
                    maxCol[i][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int minWidth = maxRow[i][j];
                for (int k = i; k >= 0 && maxCol[k][j] > 0; k--) {
                    minWidth = Math.min(minWidth, maxRow[k][j]);
                    int height = i - k + 1;
                    int area = minWidth * height;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        // 결과 출력
        System.out.println(maxArea);
    }
}
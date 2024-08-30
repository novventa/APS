import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // N을 입력 받음
        int[] A = new int[N]; // A 배열 선언
        
        // A 배열에 값을 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int k = 0; k < N; k++) {
            A[k] = Integer.parseInt(st.nextToken());
        }
        
        int i = 0; // 찾아야 하는 숫자 위치
        StringBuilder result = new StringBuilder(); // 결과를 저장할 StringBuilder
        
        for (int j = 1; j < N; j++) {
            if (A[i] != A[j]) {
                for (int k = 0; k < (j - i); k++) {
                    result.append((j + 1) + " ");
                }
                i = j;
            }
        }
        
        // 마지막 부분 처리
        for (int k = 0; k < (N - i); k++) {
            result.append("-1 ");
        }
        
        System.out.print(result.toString());
    }
}
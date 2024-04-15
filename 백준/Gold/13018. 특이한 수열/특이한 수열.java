import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        StringBuilder sb = new StringBuilder();
        //n == k일 때는 만들 수 없는 수열
        if (N == K) {
            sb.append("Impossible");
        } else {        //n != k일 때
            //순차적인 수열 초기화
            for (int i = 0; i < N; i++) {
                arr[i] = i + 1;
            }
            //교환해야 하는 개수, 점화식 : n - k - 1
            int dif = N - K - 1;
            //현재 인덱스
            int idx = 1;
            //교환 진행
            while (dif > 1) {
                swap(arr, idx, idx + 1);
                idx += 2;
                dif -= 2;    //2개수의 수가 바뀌므로 2개씩 감소
            }
            //홀수일 때 1과 마지막 수 변경
            if (dif == 1) {
                swap(arr, 0, N - 1);
            }
            sb = new StringBuilder();
            //탐색한 수열 StringBuilder 저장
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
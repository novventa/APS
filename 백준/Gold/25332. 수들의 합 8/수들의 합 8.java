import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 부분합을 저장할 HashMap
        HashMap<Long, Long> map = new HashMap<>();

        long sumA = 0, sumB = 0;
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            sumA += A[i];
            sumB += B[i];

            if (sumA == sumB) {
                cnt++;
            }

            // 현재까지의 부분합을 HashMap에 저장
            map.put(sumA - sumB, map.getOrDefault(sumA - sumB, Long.valueOf(0)) + 1);
        }

        // HashMap을 순회하며 부분합이 같은 경우를 찾아 개수를 더함
        for (Long value : map.values()) {
            cnt += (value * (value - 1)) / 2; // 조합 계산
        }

        System.out.println(cnt);

    }
}
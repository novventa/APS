import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 초기값 설정

        int sum = 0;
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i]; // 누적합 계산
            if (map.containsKey(sum - k)) {
                cnt += map.get(sum - k); // 이전 누적합에서 K를 뺀 값이 나온 경우 count에 더함
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1); // 현재 누적합을 저장
        }

        System.out.println(cnt);
    }
}
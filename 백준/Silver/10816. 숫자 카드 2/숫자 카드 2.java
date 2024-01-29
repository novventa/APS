import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 입력된 카드 정렬
        Arrays.sort(cards);

        // 검사할 수의 개수
        int m = Integer.parseInt(br.readLine());

        // 검사할 수들 배열 생성
        int[] targets = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int start = lowerBound(cards, targets[i]);
            int end = upperBound(cards, targets[i]);
            sb.append((end - start) + " ");
        }

        System.out.println(sb.toString());
    }

    // 이분 탐색을 사용하여 배열에서 특정 값의 시작 인덱스(lower bound)와 끝 인덱스(upper bound) 찾기
    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
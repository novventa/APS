import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열 A의 크기 N, 배열 B의 크기 M 입력
        StringTokenizer sizes = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(sizes.nextToken());
        int m = Integer.parseInt(sizes.nextToken());

        // 배열 A 입력
        int[] arrA = new int[n];
        StringTokenizer arrATokens = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(arrATokens.nextToken());
        }

        // 배열 B 입력
        int[] arrB = new int[m];
        StringTokenizer arrBTokens = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(arrBTokens.nextToken());
        }

        // 두 배열을 합치고 정렬
        int[] mergedArray = mergeAndSortArrays(arrA, arrB);

        // 결과 출력
        StringBuilder result = new StringBuilder();
        for (int num : mergedArray) {
            result.append(num).append(" ");
        }

        System.out.println(result.toString());
    }

    private static int[] mergeAndSortArrays(int[] arrA, int[] arrB) {
        int n = arrA.length;
        int m = arrB.length;
        int[] mergedArray = new int[n + m];

        // 두 배열을 합치고 정렬
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (arrA[i] <= arrB[j]) {
                mergedArray[k++] = arrA[i++];
            } else {
                mergedArray[k++] = arrB[j++];
            }
        }

        // 남은 요소들 처리
        while (i < n) {
            mergedArray[k++] = arrA[i++];
        }

        while (j < m) {
            mergedArray[k++] = arrB[j++];
        }

        return mergedArray;
    }
}
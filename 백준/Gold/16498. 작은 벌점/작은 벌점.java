import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 빠른 입출력을 위한 BufferedReader 및 StringTokenizer 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int[] arrA = new int[A];
        int[] arrB = new int[B];
        int[] arrC = new int[C];
        
        // 첫 번째 플레이어의 카드
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        // 두 번째 플레이어의 카드
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        // 세 번째 플레이어의 카드
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arrC[i] = Integer.parseInt(st.nextToken());
        }
        
        // 각 배열 정렬 (오름차순)
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        Arrays.sort(arrC);
        
        // 전체 범위: 각 배열의 최소, 최대 값
        int overallMin = Math.min(arrA[0], Math.min(arrB[0], arrC[0]));
        int overallMax = Math.max(arrA[A - 1], Math.max(arrB[B - 1], arrC[C - 1]));
        
        // 이분 탐색을 위한 후보 범위: [0, overallMax - overallMin]
        long low = 0;
        long high = overallMax - overallMin;
        long ans = high;
        
        while (low <= high) {
            long mid = (low + high) / 2;
            if (isPossible(arrA, arrB, arrC, mid)) {
                ans = mid;      // mid 이하로 가능한 조합이 있으므로 후보 갱신
                high = mid - 1; // 더 작은 벌점이 가능한지 탐색
            } else {
                low = mid + 1;  // mid 이하로는 불가능하므로 벌점 범위를 늘림
            }
        }
        
        System.out.println(ans);
    }
    
    // isPossible: 세 배열에서 한 장씩 골라 (max - min) <= d가 되는 조합이 있는지 확인
    static boolean isPossible(int[] A, int[] B, int[] C, long d) {
        int i = 0, j = 0, k = 0;
        int lenA = A.length, lenB = B.length, lenC = C.length;
        
        // 세 배열 모두에서 인덱스가 범위 내인 동안 반복
        while (i < lenA && j < lenB && k < lenC) {
            int a = A[i], b = B[j], c = C[k];
            int currentMin = Math.min(a, Math.min(b, c));
            int currentMax = Math.max(a, Math.max(b, c));
            
            if (currentMax - currentMin <= d) {
                return true;  // 조건을 만족하는 조합 발견
            }
            
            // 현재 값들 중 최소값을 가진 배열의 포인터 증가
            if (currentMin == a) {
                i++;
            } else if (currentMin == b) {
                j++;
            } else {
                k++;
            }
        }
        
        return false;  // 조건에 맞는 조합을 찾지 못함
    }
}
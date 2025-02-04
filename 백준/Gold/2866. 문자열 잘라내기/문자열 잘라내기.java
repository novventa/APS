import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static String[] table;
    static long[][] colHash; // 각 열별 누적 해시: colHash[j][i] = 해시, 열 j의 처음 i문자
    static long[] pow;       // pow[i] = base^i
    static long base = 131L;
    
    public static void main(String[] args) throws Exception {
        // 빠른 입출력을 위한 BufferedReader 및 StringTokenizer 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        table = new String[R];
        for (int i = 0; i < R; i++) {
            table[i] = br.readLine();
        }
        
        // 1. 각 열에 대해 rolling hash (prefix 방식) 계산
        // colHash[j][i]: 열 j에서 처음 i개의 문자에 대한 해시 (i = 0..R)
        colHash = new long[C][R + 1];
        for (int j = 0; j < C; j++) {
            colHash[j][0] = 0;
            for (int i = 0; i < R; i++) {
                // table[i].charAt(j)는 열 j의 i번째 문자
                colHash[j][i + 1] = colHash[j][i] * base + (table[i].charAt(j) - 'a' + 1);
            }
        }
        
        // 2. 미리 거듭제곱 배열 pow[0..R] 계산
        pow = new long[R + 1];
        pow[0] = 1;
        for (int i = 1; i <= R; i++) {
            pow[i] = pow[i - 1] * base;
        }
        
        // 3. 이분 탐색: 삭제할 행의 수 r (0 ≤ r ≤ R-1) 중에서 f(r)가 true인 최대 r 찾기
        int lo = 0, hi = R - 1, ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (check(mid)) {  // mid행 삭제 후 모두 distinct하면
                ans = mid;     // 후보 갱신
                lo = mid + 1;  // 더 많이 지울 수 있는지 오른쪽 탐색
            } else {
                hi = mid - 1;  // mid행 삭제로 duplicate가 생겼으므로 줄여봄
            }
        }
        
        System.out.println(ans);
    }
    
    // check(r): r행(즉, 0~r-1행 삭제) 삭제 후 남은 테이블의 각 열 문자열이 모두 distinct하면 true
    static boolean check(int r) {
        HashSet<Long> set = new HashSet<>(C * 2);
        // 남은 행은 r부터 R-1, 길이 = R - r
        for (int j = 0; j < C; j++) {
            long h = colHash[j][R] - colHash[j][r] * pow[R - r];
            if (!set.add(h)) {
                return false; // duplicate 발견
            }
        }
        return true;
    }
}
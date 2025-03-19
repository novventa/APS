import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        String K = br.readLine().trim();
        
        // 숫자를 제거하여 알파벳만 남긴 문자열 생성 (O(|S|))
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = S.length(); i < len; i++){
            char c = S.charAt(i);
            if (c < '0' || c > '9') {
                sb.append(c);
            }
        }
        String filtered = sb.toString();
        
        // 만약 filtered의 길이가 K보다 작으면 존재할 수 없음
        if (filtered.length() < K.length()){
            System.out.println(0);
            return;
        }
        
        // KMP를 사용해 filtered에서 K가 부분 문자열로 존재하는지 검색 (O(|filtered| + |K|))
        System.out.println(kmpSearch(filtered, K) ? 1 : 0);
    }
    
    // KMP 알고리즘으로 텍스트 T에서 패턴 P가 존재하는지 판단
    static boolean kmpSearch(String T, String P) {
        int n = T.length(), m = P.length();
        int[] lps = buildLPS(P);
        int j = 0;  // 패턴 P의 index
        
        for (int i = 0; i < n; i++) {
            // P[j]와 T[i]가 불일치하면, 이전 lps 정보를 사용하여 j를 줄인다.
            while (j > 0 && T.charAt(i) != P.charAt(j)) {
                j = lps[j - 1];
            }
            if (T.charAt(i) == P.charAt(j)) {
                j++;
                if (j == m) {
                    return true;  // 패턴 전체 매칭
                }
            }
        }
        return false;
    }
    
    // 패턴 P에 대한 LPS(Longest Prefix Suffix) 배열을 계산
    static int[] buildLPS(String P) {
        int m = P.length();
        int[] lps = new int[m];
        int len = 0;  // 현재까지의 최대 접두사 길이
        lps[0] = 0;   // 첫번째 문자는 0
        int i = 1;
        while (i < m) {
            if (P.charAt(i) == P.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
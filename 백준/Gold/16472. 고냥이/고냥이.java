import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 알파벳 종류의 최대 개수 N 입력
        int n = Integer.parseInt(br.readLine());

        // 문자열 입력
        String input = br.readLine();

        // 번역기가 인식할 수 있는 문자열의 최대 길이 계산
        int ans = findMax(n, input);

        // 결과 출력
        System.out.println(ans);
    }

    private static int findMax(int n, String input) {
        int max = 0;
        int left = 0;
        Map<Character, Integer> cntMap = new HashMap<>();

        for (int right = 0; right < input.length(); right++) {
            char currentChar = input.charAt(right);

            // 현재 문자의 등장 횟수를 증가시킴
            cntMap.put(currentChar, cntMap.getOrDefault(currentChar, 0) + 1);

            // 등장한 알파벳 종류의 수가 N을 초과할 경우, 왼쪽 포인터 이동
            while (cntMap.size() > n) {
                char leftChar = input.charAt(left);
                cntMap.put(leftChar, cntMap.get(leftChar) - 1);
                if (cntMap.get(leftChar) == 0) {
                    cntMap.remove(leftChar);
                }
                left++;
            }

            // 최대 길이 갱신
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
import java.util.Arrays;
import java.util.Scanner;

public class Main {

        static int L, C;
        static char[] alpha;
        static StringBuilder sb = new StringBuilder();

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            L = sc.nextInt();
            C = sc.nextInt();

            alpha = new char[C];

            for (int i = 0; i < C; i++) {
                alpha[i] = sc.next().charAt(0);
            }

            Arrays.sort(alpha);

            combination(0, 0, 0, 0, new StringBuilder());

            System.out.println(sb);
        }

        public static void combination(int idx, int vowel, int cons, int count, StringBuilder password) {
            if (count == L) {
                if (vowel >= 1 && cons >= 2) {
                    sb.append(password.toString()).append('\n');
                }
                return;
            }
            if (idx == C)
                return;

            StringBuilder updatedPassword = new StringBuilder(password);

            updatedPassword.append(alpha[idx]);
 
            combination(idx + 1, vowel + (isVowel(alpha[idx]) ? 1 : 0), cons + (isVowel(alpha[idx]) ? 0 : 1), count + 1, updatedPassword);
            combination(idx + 1, vowel, cons, count, password);
        }

        public static boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }
}
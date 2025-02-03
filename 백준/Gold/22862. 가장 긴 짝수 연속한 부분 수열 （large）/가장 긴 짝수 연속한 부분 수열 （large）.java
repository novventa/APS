import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] S = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> evenNumbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (S[i] % 2 == 0) {
                evenNumbers.add(i);
            }
        }

        if (evenNumbers.isEmpty()) {
            System.out.println(0);
            return;
        }

        int maxLength = 1;
        int i = 0;
        for(int j=0;j<evenNumbers.size();j++){
            while (i <= j && evenNumbers.get(j) - evenNumbers.get(i) - (j - i)> K) {
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }

        System.out.println(maxLength);

    }
}
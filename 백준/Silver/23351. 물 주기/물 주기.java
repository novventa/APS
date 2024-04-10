import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] vases = new int[n];

        Arrays.fill(vases,k);

        int ans = 1;
        int idx = 0;

        while (true) {
            for(int i=idx;i<idx+a;i++) {
                vases[i%n] += b;
            }

            for(int i=0;i<n;i++){
                if(--vases[i]==0) {
                    System.out.println(ans);
                    return;
                }
            }
            ans+=1;
            idx = (idx+a)%n;
        }
    }
}
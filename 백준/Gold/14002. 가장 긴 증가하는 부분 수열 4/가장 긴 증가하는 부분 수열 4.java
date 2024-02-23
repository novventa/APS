import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static Integer[] dp;
    static int[] idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new Integer[n];

        idx = new int[n];

        for(int i=0;i<n;i++){
            recur(i);
        }

        int max = dp[0];
        int index = 0;
        for(int i=1; i<n; i++){
            if(max < dp[i]){
                max = dp[i];
                index = i;
            }
        }

        List<Integer> lis = new ArrayList<>();
        while(index != -1) {
            lis.add(0, arr[index]);
            index = idx[index];
        }

        System.out.println(max);
        for(int i: lis){
            System.out.print(i + " ");
        }

    }

    private static int recur(int n) {
        if(dp[n] == null) {
            dp[n] = 1;
            idx[n] = -1;

            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] < arr[n]) {
                    if (dp[n] < recur(i) + 1) {
                        dp[n] = recur(i) + 1;
                        idx[n] = i;
                    }
                }
            }
        }
        return dp[n];
    }
}
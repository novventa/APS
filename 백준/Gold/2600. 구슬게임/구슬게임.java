import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[3];
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<3;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[501][501];

        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine());
            int k1 = Integer.parseInt(st.nextToken());
            int k2 = Integer.parseInt(st.nextToken());
            System.out.println(recur(k1,k2) ? "A" : "B");
        }
    }

    static boolean recur(int k1, int k2){
        if(k1 < 0 || k2 < 0)
            return true;
        if(dp[k1][k2] != 0)
            return dp[k1][k2] == 1;
        for(int i=0;i<3;i++){
            if(!recur(k1-arr[i],k2) || !recur(k1,k2-arr[i])){
                dp[k1][k2] = 1;
                return true;
            }
        }
        dp[k1][k2] = -1;
        return false;
    }
}
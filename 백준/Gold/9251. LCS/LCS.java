import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static char[] str1;
	static char[] str2;
	static Integer[][] dp;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		
		dp = new Integer[str1.length][str2.length];

		System.out.println(recur(str1.length-1, str2.length-1));
}
	public static int recur(int a, int b) {
		if(a<0||b<0)
			return 0;
		
		if(dp[a][b]==null) {
			dp[a][b]=0;
			if(str1[a] == str2[b]){
				dp[a][b] = recur(a-1, b-1)+1;
            } else {
				dp[a][b] = Math.max(recur(a-1,b), recur(a,b-1));
            }
		}
		
		return dp[a][b];
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n,k,ans,sum;
	static int[][] ingredients;
	static int[] selected;
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		ans = Integer.MIN_VALUE;
		
		ingredients = new int[n][n];
		selected = new int[k];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				ingredients[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(k==0)
			System.out.println(0);
		
		dfs(0,0);
		
		System.out.println(ans);
		
	}

	private static void dfs(int idx, int depth) {
		if(depth == k) {
			int[] tmp = new int[2];
			sum = 0;
			check(0,0,tmp);
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int i=idx;i<n;i++) {
			selected[depth] = i;
			dfs(i+1,depth+1);
		}
		
	}

	private static void check(int idx, int depth, int[] tmp) {
		if(depth==2) {
			sum+= ingredients[tmp[0]][tmp[1]];
			return;
		}
		
		for(int i=idx;i<k;i++) {
			tmp[depth] = selected[i];
			check(i+1,depth+1,tmp);
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int K,S,cnt=0;
	static int[] num;
	static boolean[] check;
    static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
            st = new StringTokenizer(br.readLine());
			K=Integer.parseInt(st.nextToken());
			
			if(K==0)
				break;
			num= new int[K];
			check= new boolean[K];
			
			for(int i=0;i<K;i++)
				num[i]=Integer.parseInt(st.nextToken());
			
			dfs(0,0);
			System.out.println();
		}
	}
	
	static void dfs(int dp,int start) {
		if(dp==6) {
			for(int i=0;i<K;i++){
				if(check[i]){
                    System.out.print(num[i]+" ");
                }
			}
			System.out.println();
		}
		
		for(int i=start;i<K;i++) {
			check[i]=true;
			dfs(dp+1,i+1);
			check[i]=false;
		}
	}
}
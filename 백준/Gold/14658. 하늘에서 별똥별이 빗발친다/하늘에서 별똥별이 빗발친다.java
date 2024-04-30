import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m,l,k;
	static int[][] stars;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int cnt;
        int answer = 0;
        stars = new int[k][2];
        for (int i = 0; i < k; i++) {
        	st = new StringTokenizer(br.readLine());
            stars[i][0] = Integer.parseInt(st.nextToken());
            stars[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                int x = stars[i][0];
                int y = stars[j][1];
                cnt = 0;
                for (int[] dot : stars) {
                    if (x <= dot[0] && x + l >= dot[0] && y <= dot[1] && y + l >= dot[1])
                        cnt++;
                }
                answer = Math.max(answer, cnt);

            }
        }
        System.out.println(k - answer);
    }
}
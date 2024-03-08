import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph = new int[1001][1001];
    static int n,m;
    static boolean[] visited;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1;
        }

        int cnt = 0;
        
        visited = new boolean[1001];

        for(int i=1;i<=n;i++){
            if(!visited[i]){
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int idx) {
        if(visited[idx])
            return;
        else {
            visited[idx] = true;
            for(int i=1;i<=n;i++) {
                if(graph[idx][i] == 1)
                    dfs(i);
            }
        }
    }

}
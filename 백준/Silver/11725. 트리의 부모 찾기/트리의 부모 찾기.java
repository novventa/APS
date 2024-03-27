import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static ArrayList<Integer>[] graph;
    static int[] parent;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        parent = new int[n+1];

        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1,0);

        for(int i=2;i<=n;i++){
            System.out.println(parent[i]);
        }

    }

    static void dfs(int cur, int prev) {
        parent[cur] = prev;
        for (int nxt : graph[cur]) {
            if (nxt == prev) continue;
            dfs(nxt, cur);
        }
    }
}
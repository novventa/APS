import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] size;
    static ArrayList<Integer>[] tree;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        size = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(root, -1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int query = Integer.parseInt(br.readLine());
            sb.append(size[query]).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void dfs(int node, int parent) {
        size[node] = 1;
        for (int child : tree[node]) {
            if (child != parent) {
                dfs(child, node);
                size[node] += size[child];
            }
        }
    }
}
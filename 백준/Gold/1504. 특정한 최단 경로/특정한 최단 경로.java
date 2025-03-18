import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int N,E;
    static ArrayList<Node>[] graph;
    static final int INF =  Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new  StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E;  i++) {
            st = new  StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new  StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] distFrom1 = dijkstra(1);
        int[] distFromV1 = dijkstra(v1);
        int[] distFromV2 = dijkstra(v2);

        long path1 = (long) distFrom1[v1] + distFromV1[v2] + distFromV2[N];
        long path2 = (long) distFrom1[v2] + distFromV2[v1] + distFromV1[N];
        long ans = Math.min(path1, path2);

        System.out.println(ans >= INF ? -1 : ans);
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.to;
            int cost = cur.cost;
            if (cost > dist[now]) continue;
            for (Node e : graph[now]) {
                int next = e.to;
                if (dist[next] > cost + e.cost) {
                    dist[next] = cost + e.cost;
                    pq.add(new Node(next, dist[next]));
                }
            }
        }
        return dist;
    }
}
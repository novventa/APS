import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    static  int v,e,k;
    static boolean[] visited;
    static ArrayList<Node>[] graph;
    static int[] min;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        visited = new boolean[v+1];
        graph = new ArrayList[v+1];
        min = new int[v+1];

        for(int i=1;i<=v;i++){
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(min,Integer.MAX_VALUE);

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            graph[U].add(new Node(V,W));
        }

        bfs(k);

        for(int i=1;i<=v;i++){
            System.out.println(min[i] == Integer.MAX_VALUE ? "INF" : min[i]);
        }
    }

    private static void bfs(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        pq.add(new Node(start,0));
        min[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(!visited[cur.v])
                visited[cur.v] = true;

            for (Node next : graph[cur.v]){
                if(!visited[next.v] && min[next.v] > cur.cost + next.cost){
                    min[next.v] = cur.cost + next.cost;
                    pq.add(new Node(next.v, min[next.v]));
                }
            }
        }
    }
}
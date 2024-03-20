import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int des;
        int time;

        public Node(int des, int time) {
            this.des = des;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    static ArrayList<ArrayList<Node>> list;
    static ArrayList<ArrayList<Node>> reverseList;
    static int n, x;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        reverseList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, time));
            reverseList.get(end).add(new Node(start, time));
        }

        int[] xToS = bfs(list);
        int[] sToX = bfs(reverseList);

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, xToS[i] + sToX[i]);
        }

        System.out.println(ans);
    }

    private static int[] bfs(ArrayList<ArrayList<Node>> ls) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, 0));

        boolean[] visited = new boolean[n + 1];

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curDes = cur.des;

            if (!visited[curDes]) {
                visited[curDes] = true;

                for (Node node : ls.get(curDes)) {
                    if (!visited[node.des] && dist[node.des] > dist[curDes] + node.time) {
                        dist[node.des] = dist[curDes] + node.time;
                        pq.add(new Node(node.des, dist[node.des]));
                    }
                }
            }
        }
        return dist;
    }
}
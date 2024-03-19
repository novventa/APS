import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));

    }

    private static int bfs(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int min = Integer.MAX_VALUE;

        visited[x][y] = true;

        pq.add(new Node(x,y,0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            int curX = cur.x;
            int curY = cur.y;

            if(curX == n-1 && curY == m-1) {
                min = Math.min(min,cur.cnt);
                return min;
            }
            for(int d=0;d<4;d++){
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    if(map[nx][ny]==0)
                        pq.add(new Node(nx,ny,cur.cnt));
                    if(map[nx][ny]==1)
                        pq.add(new Node(nx,ny,cur.cnt+1));
                }
            }
        }
        return -1;
    }
}
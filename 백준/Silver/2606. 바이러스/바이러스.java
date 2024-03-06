import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static int[][] Node;
    // 노드에 방문했는지 체크하는 배열
    static boolean[] isVisited; 
    // 이어져 있는 노드의 수
    static int cnt = 0;
    static int com;
    static int pair;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        com = Integer.parseInt(br.readLine());
        pair = Integer.parseInt(br.readLine());

        Node = new int[com+1][com+1];
        isVisited = new boolean[com+1];
        for (int i = 0; i < pair; i++) {
             StringTokenizer st = new StringTokenizer(br.readLine(), " ");
             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());
             // 방향성이 없기때문에 대칭으로 해도 된다
             Node[a][b] = 1;
             Node[b][a] = 1;
             
        }

        dfs(1);
        // 자기 자신을 제외하고
        System.out.println(cnt-1);

    }


    public static void dfs(int root) {
        // 1번 감염
        isVisited[root] = true;    
        //감염된 컴퓨터 수 증가
        cnt++;    
        //컴퓨터 개수만큼 반복
        for (int i = 0; i <= com; i++) {  
            if (Node[root][i] == 1 && !isVisited[i]) {    
                //node[root][i] == 1 : 1번과 연결된 노드라면     
                //!isVisited[i] : i번 컴퓨터가 감염되지 않았다면
                // i번 컴퓨터 감염처리
                dfs(i);           
            }
        }
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] city;
    static int[][] houses;
    static int[][] chickens;
    static int houseCnt = 0;
    static int chickenCnt = 0;
    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        city = new int[n][n];

        houses = new int[n*2][2];
        chickens = new int[13][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j] == 1) {
                    houses[houseCnt][0] = i;
                    houses[houseCnt][1] = j;
                    houseCnt++;
                } else if (city[i][j] == 2) {
                    chickens[chickenCnt][0] = i;
                    chickens[chickenCnt][1] = j;
                    chickenCnt++;
                }
            }
        }

        int[][] selected = new int[m][2];
        dfs(0,0,selected);
        System.out.println(minDist);
    }

    private static void dfs(int start, int cnt, int[][] selected) {
        if(cnt == m) {
            int dist = calculateDist(selected);
            minDist = Math.min(minDist, dist);
            return;
        }

        for(int i = start; i < chickenCnt; i++) {
            selected[cnt][0] = chickens[i][0];
            selected[cnt][1] = chickens[i][1];
            dfs(i + 1, cnt + 1, selected);
        }
    }

    private static int calculateDist(int[][] selected) {
        int totalDist = 0;
        for(int i = 0; i < houseCnt; i++) {
            int hx = houses[i][0];
            int hy = houses[i][1];
            int minDistance = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++) {
                int cx = selected[j][0];
                int cy = selected[j][1];
                int dist = Math.abs(hx - cx) + Math.abs(hy - cy);
                minDistance = Math.min(minDistance, dist);
            }
            totalDist += minDistance;
        }
        return totalDist;
    }
}
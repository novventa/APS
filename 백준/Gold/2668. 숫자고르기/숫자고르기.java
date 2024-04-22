import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n;
    static int[] map;
    static boolean[] visited;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);

        System.out.println(list.size());

        for (Integer i : list) {
            System.out.println(i);
        }

    }

    private static void dfs(int start, int target) {
        if (!visited[map[start]]) {
            visited[map[start]] = true;
            dfs(map[start], target);
            visited[map[start]] = false;
        }

        if (map[start] == target)
            list.add(target);
    }
}
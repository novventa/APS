import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Egg {
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }

    static int n, ans;
    static Egg[] eggs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ans = 0;

        n = Integer.parseInt(br.readLine());
        eggs = new Egg[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(durability, weight);
        }

        dfs(0);

        System.out.println(ans);

    }

    static void dfs(int cur) {
        if(cur == n) {
            int cnt = 0;
            for(Egg egg : eggs) {
                if(egg.durability <= 0) cnt++;
            }
            ans = Math.max(ans, cnt);
            return;
        }

        if(eggs[cur].durability <= 0 || noTarget(cur)) {
            dfs(cur + 1);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(i == cur) continue;
            if(eggs[i].durability <= 0) continue;

            int originalCur = eggs[cur].durability;
            int originalTarget = eggs[i].durability;

            eggs[cur].durability -= eggs[i].weight;
            eggs[i].durability -= eggs[cur].weight;

            dfs(cur + 1);

            eggs[cur].durability = originalCur;
            eggs[i].durability = originalTarget;
        }
    }

    private static boolean noTarget(int cur) {
        for(int i = 0; i < n; i++) {
            if(i == cur) continue;
            if(eggs[i].durability > 0) return false;
        }
        return true;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Guitar {
        String name;
        boolean[] song;
        int possible;

        public Guitar(String name, boolean[] song, int possible) {
            this.name = name;
            this.song = song;
            this.possible = possible;
        }
    }
    static int n,m;
    static Guitar[] guitars;
    static int[] idx;
    static int maxPlay, guitarCnt;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int ans = 0;

        idx = new int[n];
        guitars = new Guitar[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            boolean[] song = new boolean[m];
            int possible = 0;

            String possibleList = st.nextToken();
            for (int j = 0; j < m; j++) {
                song[j] = possibleList.charAt(j) == 'Y';
                if (song[j]) {
                    possible++;
                    ans++;
                }
            }
            guitars[i] = new Guitar(name, song, possible);
        }

        for (int i = 1; i <= n; i++) {
            dfs(0,0,i);
        }

        System.out.println(ans==0 ? -1 : guitarCnt);

    }

    private static void dfs(int cnt, int start, int max) {
        if (cnt == max) {
            if (check(guitars,idx, max)) {
                return;
            }
            return;
        }
        for (int i = start; i < n; i++) {
            idx[cnt] = i;
            dfs(cnt+1,i+1,max);
        }

    }

    private static boolean check(Guitar[] guitars, int[] idx, int max) {
        boolean result = true;

        int possible = 0;
        for (int i = 0; i < m; i++) {
            boolean guitarCheck = guitars[idx[0]].song[i];
            if (!guitarCheck) {
                for (int j = 1; j < max; j++) {
                    guitarCheck = guitars[idx[j]].song[i] || guitarCheck;
                }
            }
            if (!guitarCheck)
                result = false;
            if (guitarCheck)
                possible++;
        }

        if(maxPlay < possible) {
            maxPlay = possible;
            guitarCnt = max;
        }
        return result;
    }
}
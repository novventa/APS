import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Candidate {
        int num;
        int x;
        int y;

        public Candidate(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < t; tc++){
            int n = Integer.parseInt(br.readLine());

            List<Candidate> candidates = new ArrayList<>();

            int ans = 1;

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                candidates.add(new Candidate(i, x, y));
            }

            Comparator<Candidate> byX = Comparator.comparingInt(candidate -> candidate.x);

            candidates.sort(byX);

            int minY = candidates.get(0).y;

            for(int i = 1; i < n; i++){
                if(candidates.get(i).y < minY){
                    ans++;
                    minY = candidates.get(i).y;
                }
            }

            System.out.println(ans);

        }
    }
}
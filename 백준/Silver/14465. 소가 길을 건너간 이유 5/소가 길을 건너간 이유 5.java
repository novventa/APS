import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] isBroken = new boolean[n+1];

        for(int i=0;i<b;i++){
            int broken = Integer.parseInt(br.readLine());
            isBroken[broken] = true;
        }

        int s = 1;
        int e = k;
        int cnt = 0;

        for(int i=s;i<=e;i++){
            if(isBroken[i])
                cnt++;
        }

        int min = cnt;

        while(e<n){
            if(isBroken[s])
                cnt--;
            s++;
            e++;
            if(isBroken[e])
                cnt++;

            min = Math.min(min,cnt);

        }

        System.out.println(min);

    }
}
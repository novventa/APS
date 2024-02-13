import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] ans;
    static int[] arr;
    static int cnt;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ans = new int[10];
        arr = new int[10];

        cnt = 0;

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<10;i++){
            ans[i] = Integer.parseInt(st.nextToken());
        }

        recur(0);

        System.out.println(cnt);

    }

    private static void recur(int idx) {
        if(idx==10){
            int correctCnt = 0;
            for(int i=0;i<10;i++){
                if(ans[i]==arr[i])
                    correctCnt++;
                if(correctCnt==5) {
                    cnt++;
                    return;
                }
            }
            return;
        }

        for(int i=1;i<=5;i++){
            if(idx>1){
                if(arr[idx-1]==i && arr[idx-2]==i)
                    continue;
            }
            arr[idx] = i;
            recur(idx+1);
        }
    }
}
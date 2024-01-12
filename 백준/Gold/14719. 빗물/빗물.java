import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] blocks = new int[w+1];
        int ans = 0;

        st = new StringTokenizer(br.readLine());

        for(int i=1;i<=w;i++){
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftMax = new int[w+1];
        int[] rightMax = new int[w+1];

        leftMax[0] = blocks[0];
        for(int i=1;i<=w;i++){
            leftMax[i] = Math.max(leftMax[i-1], blocks[i]);
        }

        rightMax[blocks.length - 1] = blocks[blocks.length - 1];
        for (int i = blocks.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blocks[i]);
        }

        for (int i = 0; i < blocks.length; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            ans += Math.max(0, minHeight - blocks[i]);
        }

        System.out.println(ans);

    }
}
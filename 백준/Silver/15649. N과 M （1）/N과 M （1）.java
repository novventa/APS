import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static int[] sel;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        arr = new int[10];

        visited = new boolean[10];

        sel = new int[N];

        permu(new int[M], 0);

    }

    private static void permu(int[] sel, int idx) {
        if(idx==M){

            for(int i=0;i<M;i++){
                System.out.print(sel[i]+" ");
            }
            System.out.println();

            return;
        }

        for(int i=1;i<=N;i++){
            if(!visited[i]){
                sel[idx] = i;
                visited[i] = true;
                permu(sel,idx+1);
                visited[i] = false;
            }

        }
    }
}
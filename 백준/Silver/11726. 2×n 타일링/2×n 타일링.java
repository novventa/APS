import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static public void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n+1];

        arr[0] = 1;
        arr[1] = 1;

        System.out.println(recur(n));
    }
    static public int recur(int n){
        if(arr[n] > 0)
            return arr[n];
        else{
            arr[n] = (recur(n-1) + recur(n-2)) % 10007;
            return arr[n];
        }
    }
}
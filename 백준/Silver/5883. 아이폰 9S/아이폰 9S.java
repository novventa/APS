import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int num: arr) {
			set.add(num);
		}
		
		int max = 1;
		
		for (int b : set) {
            int cnt = 1;
            int num = -1;
            for (int value : arr) {
                if (value != b) {
                    if (num == -1) {
                        num = value;
                    } else {
                        if (num == value) {
                            cnt++;
                        } else {
                            max = Math.max(max, cnt);
                            num = value;
                            cnt = 1;
                        }
                    }
                }
            }
            max = Math.max(max, cnt);
        }
		
		System.out.println(max);
		
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Discount {
		int a, d;

		public Discount(int a, int d) {
			this.a = a;
			this.d = d;
		}
	}

	static class Portion {
		int c, p;
		Discount[] discounts;

		public Portion(int c) {
			this.c = c;
		}
	}

	static int n;
	static Portion[] portions;
	static int ans;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		portions = new Portion[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			portions[i] = new Portion(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < n; i++) {
			portions[i].p = Integer.parseInt(br.readLine());
			portions[i].discounts = new Discount[portions[i].p];

			for (int j = 0; j < portions[i].p; j++) {
				st = new StringTokenizer(br.readLine());
				portions[i].discounts[j] = new Discount(Integer.parseInt(st.nextToken()) - 1,
						Integer.parseInt(st.nextToken()));
			}
		}

		ans = Integer.MAX_VALUE;
		dfs(0, 0, new boolean[n]);

		System.out.println(ans);

	}

	private static void dfs(int cnt, int totalCost, boolean[] visited) {
		if (ans <= totalCost)
			return;

		if (cnt == n) {
			ans = totalCost;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			for (Discount discount : portions[i].discounts) {
				if (visited[discount.a])
					continue;

				portions[discount.a].c -= discount.d;
			}

			dfs(cnt + 1, portions[i].c <= 0 ? totalCost + 1 : totalCost + portions[i].c, visited);

			visited[i] = false;

			for (Discount discount : portions[i].discounts) {
				if (visited[discount.a]) {
					continue;
				}

				portions[discount.a].c += discount.d;
			}
		}
	}
}
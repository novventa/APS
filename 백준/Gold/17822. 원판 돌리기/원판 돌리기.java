import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, T, ans;
	static int[][] disk;
	static boolean[][] visited;
	static int[] dRow = { -1, 1, 0, 0 };
	static int[] dCol = { 0, 0, -1, 1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		M = sc.nextInt();

		T = sc.nextInt();

		disk = new int[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				disk[r][c] = sc.nextInt();
			}
		}

		for (int t = 0; t < T; t++) {
			int x = sc.nextInt();
			int d = sc.nextInt();
			int k = sc.nextInt();

			rotate(x, d, k);
			if (!remove())
				replace();
		}

		ans = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (disk[r][c] != -1)
					ans += disk[r][c];
			}
		}

		System.out.println(ans);

	}

	private static void rotate(int x, int d, int k) {

		for (int r = 0; r < N; r++) {
			if ((r+1) % x == 0) {
				if (d == 0) {
					for (int i = 0; i < k; i++) {
						int[] tmp = disk[r].clone();
						disk[r][0] = tmp[M - 1];
						for (int j = 1; j < M; j++) {
							disk[r][j] = tmp[j - 1];
						}
					}
				} else {
					for (int i = 0; i < k; i++) {
						int[] tmp = disk[r].clone();
						disk[r][M - 1] = tmp[0];
						for (int j = 0; j < M - 1; j++) {
							disk[r][j] = tmp[j + 1];
						}
					}
				}
			}
		}

	}

	private static boolean remove() {
		boolean flag = false;
		visited = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (disk[r][c] == -1 || visited[r][c])
					continue;
				
				Queue<int[]> q = new LinkedList<>();
				q.add(new int[] { r, c, disk[r][c] });
				visited[r][c] = true;
				
				while (!q.isEmpty()) {
					int[] curr = q.poll();
					for (int d = 0; d < 4; d++) {
						int nRow = curr[0] + dRow[d];
						int nCol = curr[1] + dCol[d];

						if (nRow < 0 || nRow >= N)
							continue;

						if (nCol == -1)
							nCol = M - 1;
						else if (nCol == M)
							nCol = 0;
						if (visited[nRow][nCol])
							continue;
						if (disk[nRow][nCol] == curr[2]) {
							visited[nRow][nCol] = true;
							q.add(new int[] { nRow, nCol, curr[2] });
							disk[curr[0]][curr[1]] = -1;
							disk[nRow][nCol] = -1;
							flag = true;
						}
					}
				}
			}
		}

		return flag;
	}

	private static void replace() {
		int sum = 0;
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (disk[r][c] != -1) {
					sum += disk[r][c];
					cnt++;
				}
			}
		}

		double avg = sum / (double) cnt;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (disk[r][c] != -1) {
					if ((double) disk[r][c] > avg)
						disk[r][c]--;
					else if ((double) disk[r][c] < avg)
						disk[r][c]++;
				}
			}
		}
	}
}

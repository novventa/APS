import java.util.Scanner;

public class Main {
	// 행, 열, 대각선을 고려한다.
	static int[] queen;
	static int cnt;

	public static void main(String[] args) {
		// 스캐너 선언
		Scanner sc = new Scanner(System.in);
	    // N 입력받기
		int N = sc.nextInt();
		// 퀸의 위치를 저장할 배열 선언
		queen = new int[N];
		// queen 배열 초기화
		for (int i = 0; i < N; i++) {
			queen[i] = -1;
		}
		// 경우의 수가 몇개인지 저장할 변수
		cnt = 0;
		// 탐색 시작
		nQueen(N, 0);
		// 출력
		System.out.println(cnt);
		
	}

	// 탐색 메서드
	private static void nQueen(int n, int row) {
		// boolean 배열 선언
		boolean isPossible;
		// 모두 탐색했으면
		if (n == row) {
			// 경우의 수 더하기 
			cnt++;
			return;
		}
		// 열 하나씩 옮겨가면서 체크
		for (int col = 0; col < n; col++) {
			// 일단 true로 설정
			isPossible = true;
			// 행 하나씩 옮겨가면서
			for (int tmpRow = 0; tmpRow < row; tmpRow++) {
				// 같은 행에 있는지, 대각선에 있는지 체크하고
				if ((queen[tmpRow] == col) || col == queen[tmpRow] + (row - tmpRow)
						|| col == queen[tmpRow] - (row - tmpRow)) {
					// 있으면 false로 다시 바꿔주고 break
					isPossible = false;
					break;
				}
			}
			
			// 가능하다면
			if(isPossible) {
				// 값을 바꿔주고
				queen[row] = col;
				// 다음 탐색
				nQueen(n, row+1);

			}
		}
	}
}
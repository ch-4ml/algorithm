package swea.test.p4012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {
	
	static int score1, score2, min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[][] board, scoreBoard;
		int N;
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t < T + 1; t++) {
			min = Integer.MAX_VALUE;
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(in.readLine());

			// Draw board
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 계산을 줄이기 위해 시너지 합을 미리 계산해 둔 이차원 배열
			scoreBoard = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(j == i) break;
					scoreBoard[i][j] = board[i][j] + board[j][i];
				}
			}

			combFood(N, N / 2, 0, new int[N / 2], scoreBoard);
			sb.append(min).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	// 요리 재료를 선택하는 조합
	private static void combFood(int n, int r, int startIdx, int[] comb, int[][] scoreBoard) {
		if(r == 0) {
			int[] rComb = new int[n / 2];
			int idx = 0;
			
			find:
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n / 2; j++) {
					if(comb[j] == i) continue find;
				}
				rComb[idx++] = i;
			}
			
			// 사용한 요리들의 시너지 합 초기화
			// 나머지 요리들의 시너지 합 초기화
			score1 = 0;
			score2 = 0;
			combSynerge(n / 2, 2, 0, new int[2], comb, scoreBoard, true);
			combSynerge(n / 2, 2, 0, new int[2], rComb, scoreBoard, false);
			
			// 차이를 계산해서 최소값인지 비교 후 할당
			int result = Math.abs(score1 - score2);
			min = Math.min(result, min);
			
			return;
		}
		
		for(int i = startIdx; i < n; i++) {
			comb[n / 2 - r] = i;
			combFood(n, r - 1, i + 1, comb, scoreBoard);
		}
	}
	
	// 요리 재료의 시너지를 계산하는 조합
	private static void combSynerge(int n, int r, int startIdx, int[] comb, int[] foods, int[][] scoreBoard, boolean flag) {
		if(r == 0) {
			if(flag) score1 += scoreBoard[comb[1]][comb[0]];
			else score2 += scoreBoard[comb[1]][comb[0]];
			
			return;
		}
		
		for(int i = startIdx; i < n; i++) {
			comb[2 - r] = foods[i];
			combSynerge(n, r - 1, i + 1, comb, foods, scoreBoard, flag);
		}
	}
}

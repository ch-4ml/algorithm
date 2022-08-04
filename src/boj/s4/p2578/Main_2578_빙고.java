package boj.s4.p2578;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2578_빙고 {
	
	public static final int SIZE = 5;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// draw board
		int[][] board = new int[SIZE][SIZE];
		int[][] indexOfNumber = new int[SIZE * SIZE][2];
		boolean[][] isChecked = new boolean[SIZE][SIZE];
		int next;
		for(int i = 0; i < SIZE; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < SIZE; j++) {
				next = Integer.parseInt(st.nextToken());
				board[i][j] = next;
				indexOfNumber[next-1] = new int[] { i, j };
			}
		}
		
		// check
		int count = 0;
		int bingo = 0;
		
		check:
		for(int i = 0; i < SIZE; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < SIZE; j++) {
				count++;
				int[] pos = indexOfNumber[Integer.parseInt(st.nextToken()) - 1];
				isChecked[pos[0]][pos[1]] = true;
				bingo = checkBingo(isChecked);
				if(bingo == 3) break check;
			}
		}
		
		out.write(String.valueOf(count));
		out.flush();
		out.close();
	}
	
	static int checkBingo(boolean[][] isChecked) {
		int count = 0;
		boolean flag;
		
		// 가로줄 체크
		for(int i = 0; i < SIZE; i++) {
			flag = true;
			for(int j = 0; j < SIZE; j++) {
				if(!isChecked[i][j]) {
					flag = false;
					break;
				}
			}
			if(flag) count++;
		}
		
		// 세로줄 체크
		for(int i = 0; i < SIZE; i++) {
			flag = true;
			for(int j = 0; j < SIZE; j++) {
				if(!isChecked[j][i]) {
					flag = false;
					break;
				}
			}
			if(flag) count++;
		}
		
		// 대각선 체크
		flag = true;
		for(int i = 0; i < SIZE; i++) {
			if(!isChecked[i][i]) {
				flag = false;
				break;
			}
		}
		if(flag) count++;
		
		flag = true;
		for(int i = 0; i < SIZE; i++) {
			if(!isChecked[SIZE-i-1][i]) {
				flag = false;
				break;
			}
		}
		if(flag) count++;
		
		return count;
	}
}

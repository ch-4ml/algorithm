package boj.s1.p16935;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기3 {	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(in.readLine());
		int op;
		for(int i = 0; i < R; i++) {
			op = Integer.parseInt(st.nextToken());
			switch(op) {
			case 1:
				reverseVertical(arr);
				break;
			case 2:
				reverseHorizontal(arr);
				break;
			case 3:
				arr = rotateClockwise(arr, true);
				break;
			case 4:
				arr = rotateClockwise(arr, false);
				break;
			case 5:
				rotateGroupClockwise(arr, true);
				break;
			case 6:
				rotateGroupClockwise(arr, false);
				break;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
		
	}
	
	private static void reverseVertical(int[][] arr) {
		List<int[]> rows = new ArrayList<>();
		int[] row;
		int x = arr[0].length;
		int y = arr.length;
		for(int i = 0; i < y; i++) {
			row = new int[x];
			for(int j = 0; j < x; j++) {
				row[j] = arr[i][j];
			}
			rows.add(row);
		}
		
		Collections.reverse(rows);
		for(int i = 0; i < y; i++) {
			arr[i] = rows.get(i);
		}
	}
	
	private static void reverseHorizontal(int[][] arr) {
		List<int[]> cols = new ArrayList<>();
		int[] col;
		int x = arr[0].length;
		int y = arr.length;
		for(int i = 0; i < x; i++) {
			col = new int[y];
			for(int j = 0; j < y; j++) {
				col[j] = arr[j][i];
			}
			cols.add(col);
		}
		
		Collections.reverse(cols);
		for(int i = 0; i < x; i++) {
			col = cols.get(i);
			for(int j = 0; j < y; j++) {
				arr[j][i] = col[j];
			}
		}
	}
	
	private static int[][] rotateClockwise(int[][] arr, boolean isClockwise) {
		int x = arr[0].length;
		int y = arr.length;
		int[][] rotatedArr = new int[x][y];
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				if(isClockwise) rotatedArr[j][y - i - 1] = arr[i][j];
				else rotatedArr[x - j - 1][i] = arr[i][j];
			}
		}
		
		return rotatedArr;
	}
	
	private static void rotateGroupClockwise(int[][] arr, boolean isClockwise) {
		int x = arr[0].length;
		int y = arr.length;
		
		int[] sx = { 0, x / 2, x / 2, 0 };
		int[] sy = { 0, 0, y / 2, y / 2 };
		
		int[][][] arrs = new int[4][y / 2][x / 2];
		for(int i = 0; i < 4; i++) {
			int[][] a = new int[y / 2][x / 2];
			for(int j = 0; j < y / 2; j++) {
				for(int k = 0; k < x / 2; k++) {
					a[j][k] = arr[sy[i] + j][sx[i] + k];
				}
			}
			arrs[i] = a;
		}

		ArrayDeque<Integer> idxQueue = new ArrayDeque<>();
		for(int i = 0; i < 4; i++) idxQueue.offer(i);
		
		// 0, 1, 2, 3 -> 3, 0, 1, 2
		if(isClockwise) idxQueue.addFirst(idxQueue.removeLast());			
		// 0, 1, 2, 3 -> 1, 2, 3, 0
		else idxQueue.offer(idxQueue.poll()); 
		
		Integer[] idx = idxQueue.toArray(new Integer[0]);
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < y / 2; j++) {
				for(int k = 0; k < x / 2; k++) {
					arr[sy[i] + j][sx[i] + k] = arrs[idx[i]][j][k];
				}
			}
		}
	}
}

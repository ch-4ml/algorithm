package boj.g4.p17406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
	
	static List<int[]> permutations = new ArrayList<>();
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		List<int[]> operations = new ArrayList<>();
		
		int[][] arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] op;
		for(int i = 0; i < K; i++) {
			op = new int[3];
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < 3; j++) {
				op[j] = Integer.parseInt(st.nextToken());
			}
			operations.add(op);
		}
		
		// 회전 연산을 받아서 Index Permutation 만들기
		perm(K, new int[K], new boolean[K]);
		
		// 모든 순서의 회전 연산을 시도해서 최소값을 구하고, 현재 저장된 최소값과 비교 후 갱신
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < permutations.size(); i++) {
			// 배열 넘겨주기 전 deep copy
			int[][] newArr = new int[N][M];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					newArr[j][k] = arr[j][k];
				}
			}
			
			// 시도할 순서
			int[] pIdx = permutations.get(i);
			int result = 0;
			
			// 순서대로 모든 연산을 시도하기
			for(int j = 0; j < K; j++) {
				op = operations.get(pIdx[j]);
				result = rotateAndFindMinVal(newArr, op[0] - 1, op[1] - 1, op[2]);
			}
			min = Math.min(result, min);
		}

		sb.append(min);
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	private static void perm(int left, int[] permutation, boolean[] isSelected) {
		if(left == 0) {
			int[] p = new int[K];
			for(int i = 0; i < K; i++) {
				p[i] = permutation[i];
			}
			permutations.add(p);
			return;
		}
		
		for(int i = 0; i < K; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			permutation[K - left] = i;
			perm(left - 1, permutation, isSelected);
			isSelected[i] = false;
		}
	}
	
	
	private static int rotateAndFindMinVal(int[][] arr, int r, int c, int s) {
		if(s == 0) {
			int sum, min = Integer.MAX_VALUE;
			for(int i = 0; i < arr.length; i++) {
				sum = 0;
				for(int j = 0; j < arr[0].length; j++) {
					sum += arr[i][j];
				}
				min = Math.min(sum, min);
			}
			
			return min;
		}
	
		int px = c - s;
		int py = r - s;
		int d = 0;
				
		// 큐에 회전시키려는 숫자 그룹 담기
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		while(d < 4) {
			queue.add(arr[py][px]);
			px = px + dx[d];
			py = py + dy[d];
			if(px + dx[d] > c + s) d++;
			else if(py + dy[d] > r + s) d++;
			else if(px + dx[d] < c - s) d++;
			else if(py + dy[d] < r - s) d++;
		}
		
		queue.addFirst(queue.removeLast());
		
		// 회전한 큐의 원소를 array에 순서대로 담기
		d = 0;
		while(d < 4) {
			arr[py][px] = queue.poll();
			px = px + dx[d];
			py = py + dy[d];
			if(px + dx[d] > c + s) d++;
			else if(py + dy[d] > r + s) d++;
			else if(px + dx[d] < c - s) d++;
			else if(py + dy[d] < r - s) d++;
		}
		
		return rotateAndFindMinVal(arr, r, c, s - 1);
	}
}

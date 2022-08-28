package swea.d4.p3234;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3234_준환이의양팔저울 {
	
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t <= T; t++) {
			result = 0;
			int N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			int[] weights = new int[N];

			for(int i = 0; i < N; i++) {
				int weight = Integer.parseInt(st.nextToken());
				weights[i] = weight;
			}
			
			Arrays.sort(weights);
			
			do {
				inspect(weights, 0, 0, 0, N);
			} while(nextPermutation(weights, weights.length));
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	static boolean nextPermutation(int[] weights, int size) {
		// 꼭대기 찾기
		int i = size - 1;
		while(i > 0 && weights[i - 1] >= weights[i]) --i;

		// 꼭대기가 가장 왼쪽이면 (내림차순으로 정렬된 형태이면) 종료
		if(i == 0) return false;
		
		// 꼭대기의 바로 왼쪽(i - 1)을 크게 만들 수 있는 값을 배열의 끝에서부터 찾기
		int j = size - 1;
		while(weights[i - 1] >= weights[j]) {
			--j;
		}
		
		// 꼭대기의 바로 왼쪽(i - 1)과 선택된 큰 값의 자리를 바꾸기
		swap(weights, i - 1, j);
		
		// 꼭대기의 오른쪽 부분을 오름차순으로 정렬
		int k = size - 1;
		while(i < k) swap(weights, i++, k--);
		
		return true;
	}
	
	static void swap(int[] weights, int i, int j) {
		int temp = weights[i];
		weights[i] = weights[j];
		weights[j] = temp;
	}
	
	static void inspect(int[] weights, int left, int right, int count, int N) {
		if(right > left) return;
		if(count == N) { 
			result++;
			return;
		}
		
		inspect(weights, left + weights[count], right, count + 1, N);
		inspect(weights, left, right + weights[count], count + 1, N);
	}
}

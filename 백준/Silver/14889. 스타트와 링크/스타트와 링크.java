import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] stat;	
	static int min;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		stat = new int[N][N];
		min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				stat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0, N / 2, new int[N / 2], 0);
		out.write(min + "");
		out.flush();
		out.close();
	}
	
	static void combination(int count, int r, int[] comb, int start) {
		if(count == r) {
			int[] inverse = new int[r];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				if(!contains(comb, i)) {
					inverse[idx++] = i;
				}
			}
			
			int s = 0;
			int l = 0;
			for(int i = 0; i < r - 1; i++) {
				for(int j = i; j < r; j++) {
					s += stat[comb[i]][comb[j]] + stat[comb[j]][comb[i]];
					l += stat[inverse[i]][inverse[j]] + stat[inverse[j]][inverse[i]];
				}
			}
			
			min = Math.min(Math.abs(s - l), min);
			return;
		}
		
		for(int i = start; i < N; i++) {
			comb[count] = i; 
			combination(count + 1, r, comb, i + 1);
		}
	}
	
	static boolean contains(int[] arr, int target) {
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == target) return true;
		}
		return false;
	}
}

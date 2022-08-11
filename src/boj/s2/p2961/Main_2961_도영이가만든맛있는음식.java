package boj.s2.p2961;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		int[] sour = new int[N];
		int[] bitter = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			sour[i] = Integer.parseInt(st.nextToken()); 
			bitter[i] = Integer.parseInt(st.nextToken()); 
		}
		
		out.write(String.valueOf(powerset(N, sour, bitter)));
		out.flush();
		out.close();
	}
	
	private static int powerset(int size, int[] sour, int[] bitter) {
		int s, b, min = Integer.MAX_VALUE;
		for(int i = 0; i < (1 << size); i++) {  // 모든 부분집합의 수만큼 반복
			s = 1;
			b = 0;
			for(int j = 0; j < size; j++) {  // index를 모두 탐색하면서
				if((i & 1 << j) > 0) {  // index를 선택한 경우
					s *= sour[j];
					b += bitter[j];
				}
			}
			if(s != 1 || b != 0) min = Math.min(min, Math.abs(s - b));
		}
		return min;
	}
}

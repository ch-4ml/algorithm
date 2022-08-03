package boj.b2.p2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798_블랙잭 {	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] params = in.readLine().split(" ");
		int N = Integer.parseInt(params[0]);
		int target = Integer.parseInt(params[1]);
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] cards = new int[N];
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = -1;
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				for(int k = j + 1 ; k < N; k++) {
					 int sum = cards[i] + cards[j] + cards[k];
					 if(sum <= target) max = Math.max(max, sum);
				}
			}
		}
		
		System.out.println(max);
	}
}

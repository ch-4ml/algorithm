package boj.b2.p3040;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_3040_백설공주와일곱난쟁이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dwarfs = new int[9];
		for(int i = 0; i < 9; i++) {
			dwarfs[i] = Integer.parseInt(in.readLine());
		}
		
		comb(7, new int[7], dwarfs, 0);
	}
	
	private static void comb(int left, int[] c, int[] d, int startIdx) throws IOException {
		
		if(left == 0) {
			int sum = 0;
			for(int i = 0; i < 7; i++) {
				sum += c[i];
			}
			
			if(sum == 100) {
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < 7; i++) {
					sb.append(c[i]).append("\n");
				}
				
				out.write(sb.toString());
				out.flush();
				out.close();
			}
			
			return;
		}
		
		for(int i = startIdx; i < 9; i++) {
			c[7 - left] = d[i];
			comb(left - 1, c, d, i + 1);
		}
	}
}

package swea.test.p1952;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {
	
	static int min, pDay, pMonth, pThreeMonth, pYear;
	static int[] plans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine());
			pDay = Integer.parseInt(st.nextToken());
			pMonth = Integer.parseInt(st.nextToken());
			pThreeMonth = Integer.parseInt(st.nextToken());
			pYear = Integer.parseInt(st.nextToken());
			
			plans = new int[13];
			st = new StringTokenizer(in.readLine());
			for(int i = 1; i <= 12; i++) {
				plans[i] = Integer.parseInt(st.nextToken());
			}
			
			min = pYear;
			accumulate(1, 0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	private static void accumulate(int month, int sum) {
		if(min < sum) return;
		
		if(month > 12) {
			min = Math.min(min, sum);
			return; 
		}
		
		accumulate(month + 1, sum + pMonth);
		accumulate(month + 3, sum + pThreeMonth);
		accumulate(month + 1, sum + pDay * plans[month]);
	}
}

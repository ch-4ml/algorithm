package boj.b1.p11050;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11050_이항계수1 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int denominator = 1;
		int numerator = 1; 
		for(int i = K; i > 0; i--) {
			denominator *= N--;
			numerator *= i;
		}
				
		out.write(denominator / numerator + "");
		out.flush();
		out.close();
	}
}

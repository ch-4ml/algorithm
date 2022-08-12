package boj.s3.p1463;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1463_1로만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(in.readLine());
		out.write(String.valueOf(getResult(N)));
		out.flush();
		out.close();
	}
	
	private static int getResult(int N) {
		int count = 0;
		while(N > 1) {
			
			
		}
		return count;
	}
}

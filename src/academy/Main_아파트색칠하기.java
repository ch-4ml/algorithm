package academy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_아파트색칠하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(in.readLine());
		int[] color = new int[N + 1];
		color[1] = 2;
		color[2] = 3;
		
		int result = getCase(color, N);
		out.write(result + "");
		out.flush();
		out.close();
	}
	
	private static int getCase(int[] color, int n) {
		if(color[n] == 0) {
			return color[n] = getCase(color, n - 1) + n - 1;
		} else {
			return color[n];
		}
	}
}

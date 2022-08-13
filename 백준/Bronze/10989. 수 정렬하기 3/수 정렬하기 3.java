import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		int[] count = new int[10000];
		for(int i = 0; i < N; i++) {
			count[Integer.parseInt(in.readLine()) - 1]++;
		}
		
		for(int i = 0; i < 10000; i++) {
			for(int j = 0; j < count[i]; j++) {				
				sb.append(i + 1).append("\n");
			}
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
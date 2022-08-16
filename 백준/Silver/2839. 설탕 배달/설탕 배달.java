import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(in.readLine());
		
		int x = 0, y = 0, z = N;
		while(z > 0 && z % 5 != 0) {
			z -= 3;
			y++;
		}
		
		if(z < 0) out.write("-1");
		else {
			x = z / 5;
			out.write(String.valueOf(x + y));
		}
		
		out.flush();
		out.close();
	}
}
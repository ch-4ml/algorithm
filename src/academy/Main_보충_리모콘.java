package academy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_보충_리모콘 {
	
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int init = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		min = Integer.MAX_VALUE;
		dfs(0, init, target);
		out.write(min + "");
		out.flush();
		out.close();
	}
	
	private static void dfs(int cnt, int temp, int target) {
		if(cnt > min) return;
		if(temp == target) {
			min = Math.min(cnt, min);
			return;
		}
		if(temp < target) {
			dfs(cnt + 1, temp + 10, target);
			dfs(cnt + 1, temp + 5, target);
			dfs(cnt + 1, temp + 1, target);
		} else {
			dfs(cnt + 1, temp - 1, target);
			dfs(cnt + 1, temp - 5, target);
			dfs(cnt + 1, temp - 10, target);
		}
	}
}

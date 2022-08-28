import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(map, N, 0, 0, 0, 0, 0);
		
		out.write(String.valueOf(min));
		out.flush();
		out.close();
	}
	
	static void dfs(int[][] map, int N, int flag, int start, int cur, int count, int value) {	
		if(count == N - 1) {
			if(map[cur][start] == 0) return;
			value += map[cur][start];
			min = min > value ? value : min;
			return;
		}
		
		if(value >= min) return;
		
		for(int i = 0; i < N; i++) {
			if(i == start) continue;
			if((flag & 1 << i) != 0) continue;
			if(map[cur][i] == 0) continue;
			dfs(map, N, flag | 1 << i, start, i, count + 1, value + map[cur][i]);
		}
	}
}
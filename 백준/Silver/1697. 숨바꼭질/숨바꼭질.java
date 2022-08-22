import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int pos = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int result = pos >= target ? pos - target : bfs(pos, target);

		out.write(String.valueOf(result));
		out.flush();
		out.close();
	}

	static int bfs(int pos, int target) {
		final int MAX = 100000;
		int breadth = 0; // 너비
		int size = 0; // 현재 너비
		int p = 0;
		boolean[] visited = new boolean[MAX + 1];
		Queue<Integer> queue = new ArrayDeque<>();

		queue.offer(pos);
		visited[pos] = true;

		while (!queue.isEmpty()) {
			size = queue.size();
			while (size-- > 0) {
				p = queue.poll();
				
				if (p == target) {
					return breadth;
				}

				if (p * 2 <= MAX && p > 0 && !visited[p * 2]) {
					visited[p * 2] = true;
					queue.offer(p * 2);
				}
				
				if (p + 1 <= MAX && !visited[p + 1]) {
					visited[p + 1] = true;
					queue.offer(p + 1);
				}

				if (p - 1 >= 0 && !visited[p - 1]) {
					visited[p - 1] = true;
					queue.offer(p - 1);
				}
			}
			
			breadth++;
		}

		return breadth;
	}
}
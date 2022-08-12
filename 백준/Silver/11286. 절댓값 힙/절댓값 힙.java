import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				int result = Math.abs(i1) - Math.abs(i2);
				if (result == 0) result = i1 - i2; 
				return result;
			}
		});

		int next;
		for(int i = 0; i < N; i++) {
			next = Integer.parseInt(in.readLine());
			if(next == 0) {
				if(queue.isEmpty()) sb.append(0);
				else sb.append(queue.poll());
				sb.append("\n");
			} else {
				queue.offer(next);
			}
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
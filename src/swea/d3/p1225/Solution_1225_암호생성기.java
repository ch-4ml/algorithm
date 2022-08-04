package swea.d3.p1225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		ArrayDeque<Integer> queue;
		for(int t = 1; t <= 10; t++) {
			in.readLine();
			st = new StringTokenizer(in.readLine());
			queue = new ArrayDeque<>();
			
			// Set data
			for(int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			// 마지막 요소의 값이 0보다 큰동안 반복
			while(queue.getLast() > 0) {
				for(int i = 1; i <= 5; i++) {
					// 회전
					queue.offer(queue.poll() - i);
					// 마지막 요소의 값이 0보다 낮으면
					if(queue.getLast() <= 0) {
						queue.removeLast();
						queue.offer(0);
						break;
					}
				}
			}
			
			sb.append("#").append(t).append(" ");
			Iterator<Integer> iter = queue.iterator();
			while(iter.hasNext()) {
				sb.append(iter.next()).append(" ");
			}
			sb.append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

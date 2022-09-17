package swea.test.p4013;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		final int SIZE = 4;
		final int LEFT = 6;
		final int RIGHT = 2;

		ArrayDeque<Integer>[] magnets = new ArrayDeque[SIZE + 1];
		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(in.readLine());

			for (int i = 1; i <= SIZE; i++) {
				st = new StringTokenizer(in.readLine());
				magnets[i] = new ArrayDeque<Integer>();
				for (int j = 0; j < 8; j++) {
					magnets[i].offer(Integer.parseInt(st.nextToken()));
				}
			}

			for (int i = 0; i < K; i++) {
				boolean[] visited = new boolean[SIZE + 1];
				Queue<Integer> rotates = new ArrayDeque<>();
				st = new StringTokenizer(in.readLine());
				int magnetIdx = Integer.parseInt(st.nextToken()); // 회전하려는 자석의 index
				int rotateDir = Integer.parseInt(st.nextToken()); // 1: 시계, -1: 반시계

				visited[magnetIdx] = true;
				rotates.add(magnetIdx);
				
				List<Integer> tempList = null;

				while (!rotates.isEmpty()) {
					int qSize = rotates.size();
					while (qSize-- > 0) {
						int idx = rotates.poll();
						
						// 왼쪽에 자석이 있으면 왼쪽 검사
						if (idx > 1 && !visited[idx - 1]) {
							tempList = new ArrayList<>(magnets[idx]);
							int curLeft = tempList.get(LEFT);
							tempList = new ArrayList<>(magnets[idx - 1]);
							int contact = tempList.get(RIGHT);
							if(curLeft != contact) {
								visited[idx - 1] = true;
								rotates.offer(idx - 1);
							}
						}

						// 오른쪽에 자석이 있으면 오른쪽 검사
						if (idx < SIZE && !visited[idx + 1]) {
							tempList = new ArrayList<>(magnets[idx]);
							int curRight = tempList.get(RIGHT);
							tempList = new ArrayList<>(magnets[idx + 1]);
							int contact = tempList.get(LEFT);
							if(curRight != contact) {
								visited[idx + 1] = true;
								rotates.offer(idx + 1);
							}
						}
						
						// 회전
						if (rotateDir == 1) { // 시계방향
							magnets[idx].addFirst(magnets[idx].removeLast());
						} else {
							magnets[idx].offer(magnets[idx].poll());
						}

						
					}
					rotateDir *= -1;
				}
			}
			
			int result = 0;
			for(int i = 1; i <= SIZE; i++) {
				if(magnets[i].peek() == 1) result += (int) Math.pow(2, i - 1);
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

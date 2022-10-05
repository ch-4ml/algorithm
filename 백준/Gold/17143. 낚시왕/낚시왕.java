import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Shark {
	int s, d, z;
	
	Shark(int s, int d, int z) {
		this.s = s;
		this.d = d;
		this.z = z;
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // 상어 수
		Queue<int[]> queue = new ArrayDeque<>(); // 상어 좌표 큐
		Shark[][] before = new Shark[R + 1][C + 1]; 
		Shark[][] after = new Shark[R + 1][C + 1];
		
		// Draw map
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken()); // 속력
			int d = Integer.parseInt(st.nextToken()); // 방향. 1: 위, 2: 아래, 3: 오른쪽, 4: 왼쪽
			int z = Integer.parseInt(st.nextToken()); // 크기
			
			
			// 방향 변경. -1: 위, 1: 아래, 2: 오른쪽, -2: 왼쪽
			d = d == 1 ? -1 : d == 2 ? 1 : d == 3 ? 2 : -2;
			
			// 속력 변경(상어 위치 계산 시 반복 횟수 줄이기)
			s = (d == 1 || d == -1) ? s % (R * 2 - 2) : s % (C * 2 - 2);
			
			Shark shark = new Shark(s, d, z); 
			before[r][c] = shark;
			int[] pos = { r, c };
			queue.add(pos);
		}
		
		// 낚시왕 이동
		int sum = 0;
		for (int i = 1; i <= C; i++) {
			
			// 낚시왕이 상어 잡음(땅과 제일 가까운 상어)
			for(int j = 1; j <= R; j++) {
				if(before[j][i] != null) {
					sum += before[j][i].z;
					before[j][i] = null;
					break;
				}
			}
			
			// 상어 이동
			int size = queue.size();
			while(size-- > 0) {	// 현재 큐에 들어있던 상어의 좌표에 대해서만 검사			
				int[] cur = queue.poll();
				int r = cur[0];
				int c = cur[1];
				Shark shark = before[r][c];
				if(shark == null) continue;
				
				// 상어 위치 계산
				if(shark.d == -1) {
					r -= shark.s;
				} else if(shark.d == 1) {
					r += shark.s;
				} else if(shark.d == -2) {
					c -= shark.s;
				} else {
					c += shark.s;
				}
				
				// 상어가 범위를 넘어가는 경우 왔다갔다 처리
				while(r < 1 || r > R || c < 1 || c > C) {
					if(r < 1) {
						r = r * -1 + 2;
					} else if(r > R) {
						r = 2 * R - r;
					} else if(c < 1) {
						c = c * -1 + 2;
					} else if(c > C) {
						c = 2 * C - c;
					}
					shark.d *= -1;
				}
				
				// 이동을 완료한 상어를 새로운 배열에 배치
				if(after[r][c] != null) { // 이동하려는 위치에 상어가 있음		
					after[r][c] = after[r][c].z > shark.z ? after[r][c] : shark;
				} else {
					after[r][c] = shark;
					int[] newPos = { r, c };
					queue.offer(newPos); // 검사할 좌표를 큐에 넣기
				}
			}
			
			// 모든 상어의 이동을 마친 후
			before = after;
			after = new Shark[R + 1][C + 1];
		}
		
		out.write(sum + "");
		out.flush();
		out.close();
	}
}

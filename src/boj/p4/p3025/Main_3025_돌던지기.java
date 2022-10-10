package boj.p4.p3025;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Node {
	int r, c;
	Node next;
	
	public Node(int r, int c, Node next) {
		super();
		this.r = r;
		this.c = c;
		this.next = next;
	}
}

public class Main_3025_돌던지기 {
	
	static char[][] map;
	static Node[][] direction;
	static int R, C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];
		direction = new Node[R + 1][C + 1];

		// Direction node 배열 초기화
		// 가장 아래 줄
		for (int i = 1; i < C + 1; i++) {
			direction[R][i] = new Node(R, i, null);
		}
		
		// 나머지 줄
		for (int i = 1; i < C + 1; i++) {
			for (int j = R - 1; j > 0; j--) {
				direction[j][i] = new Node(j, i, direction[j + 1][i]);
			}
		}

		// 지도 그리기 및 장애물을 돌멩이가 떨어질 위치 배열에 반영
		for (int i = 1; i < R + 1; i++) {
			String rows = in.readLine();
			for (int j = 1; j < C + 1; j++) {
				char status = rows.charAt(j - 1);
				if (status == 'X') {
					direction[i - 1][j].next = null;
				}
				map[i][j] = status;
			}
		}

		System.out.println(direction[2][1].next);
		
		// 돌 굴리기 N회
		int N = Integer.parseInt(in.readLine());


		System.out.println();
		// 돌 굴리기 반복
		for (int i = 0; i < N; i++) {
			int col = Integer.parseInt(in.readLine());
			
			// 돌이 떨어질 위치 찾기
			Node node = direction[1][col];
			while(node.next != null) {
				node = node.next;
			}
			
			System.out.println(node.r + " " + node.c + " " + node.next);
			
			map[node.r][node.c] = 'O';

			System.out.println();
			for (int a = 1; a < R + 1; a++) {
				for (int j = 1; j < C + 1; j++) {
					System.out.print(map[a][j]);
				}
				System.out.println();
			}
			
			// 돌이 굴러떨어질 수 있는 위치 검사
			update(node);
		}

//		for (int i = 1; i < R + 1; i++) {
//			for (int j = 1; j < C + 1; j++) {
//				sb.append(map[i][j]);
//			}
//			sb.append("\n");
//		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void update(Node node) {
		if(node.r > 1 && node.c > 1 && map[node.r - 1][node.c - 1] == '.' && map[node.r][node.c - 1] == '.') {
			node.next = direction[node.r - 1][node.c - 1];
		} else if(node.r > 1 && node.c < C && map[node.r - 1][node.c + 1] == '.' && map[node.r][node.c + 1] == '.') {
			node.next = direction[node.r][node.c + 1];
		} else {
			node.next = null;
		}
	}
}





//System.out.println(dp[col - 1][0] +
//		" " + dp[col][0] +
//		" " + dp[col + 1][0]);






//System.out.println("-------");
//for (int i = 1; i < R + 1; i++) {
//	for (int j = 1; j < dp.length; j++) {
//		System.out.print(map[i][j]);
//	}
//	System.out.println();
//}
//
//System.out.println("------");
//for (int i = 1; i < dp.length; i++) {
//	System.out.println(Arrays.toString(dp[i]));
//}
//System.out.println();

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
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];
		direction = new Node[R + 1][C + 1];

		// Direction node 배열 초기화
		for (int i = 1; i < C + 1; i++) {
//			Node 
		}
		
		for (int i = 1; i < C + 1; i++) {
			for (int j = R - 1; j > 0; j--) {
				
			}
		}

		// 지도 그리기 및 장애물을 돌멩이가 떨어질 위치 배열에 반영
		for (int i = 1; i < R + 1; i++) {
			String rows = in.readLine();
			for (int j = 1; j < C + 1; j++) {
				char status = rows.charAt(j - 1);
				if (status == 'X') {
					
				}
				map[i][j] = status;
			}
		}

		// 돌 굴리기 N회
		int N = Integer.parseInt(in.readLine());

		// 돌 굴리기 반복
		for (int i = 0; i < N; i++) {
			
		}

		for (int i = 1; i < R + 1; i++) {
			for (int j = 1; j < C + 1; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void update(Node node) {
		if(map[node.r][node.c - 1] == '.' && map[node.r + 1][node.c - 1] == '.') {
			node.next = direction[node.r][node.c - 1];
		} else if(map[node.r][node.c + 1] == '.' && map[node.r + 1][node.c + 1] == '.') {
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

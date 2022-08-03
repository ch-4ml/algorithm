package boj.b3.p4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4153_직각삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] lines = new int[3];
		int max, maxIdx, line, sum;
		do {
			max = -1;
			maxIdx = -1;
			line = 0;
			sum = 0;
			st = new StringTokenizer(in.readLine());			
			for(int i = 0; i < 3; i++) {
				line = Integer.parseInt(st.nextToken());
				lines[i] = line;
				if(line > max) {
					max = line;
					maxIdx = i;
				}
			}
			
			if(lines[0] == 0 && lines[1] == 0 && lines[2] == 0) break;
			
			for(int i = 0; i < 3; i++) {
				if(i == maxIdx) continue;
				sum += Math.pow(lines[i], 2);
			}
			
			if(Math.pow(max, 2) == sum) sb.append("right\n");
			else sb.append("wrong\n");
		} while(lines[0] > 0 || lines[1] > 0 || lines[2] > 0);
		System.out.println(sb);
	}
}

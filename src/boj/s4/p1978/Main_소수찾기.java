package boj.s4.p1978;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_소수찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int num;
		boolean flag;
		int count = 0;
		for(int i = 0; i < N; i++) {
			flag = true;
			num = Integer.parseInt(st.nextToken());
			if(num < 2) continue;
			for(int j = 2; j < num; j++) {
				if(num % j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) count++;
		}
		
		System.out.println(count);
	}
}

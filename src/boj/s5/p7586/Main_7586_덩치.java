package boj.s5.p7586;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_7586_덩치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		int[][] people = new int[N][3]; // w, h, rank
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int w = Integer.parseInt(st.nextToken()); 
			int h = Integer.parseInt(st.nextToken());
			int rank = 1;
			for(int j = 0; j < i; j++) {
				if(people[j][0] > w && people[j][1] > h) {
					rank++;
				} else if(people[j][0] < w && people[j][1] < h) {
					people[j][2]++;
				}
			}
			people[i][0] = w;
			people[i][1] = h;
			people[i][2] = rank;
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(people[i][2]).append(" ");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}

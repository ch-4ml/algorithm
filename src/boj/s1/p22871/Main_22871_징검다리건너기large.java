package boj.s1.p22871;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_22871_징검다리건너기large {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        long[] dt = new long[N + 1]; // n까지 건너는 데 최대로 사용한 힘의 최솟값
        long[] stones = new long[N + 1];
        
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 2; i <= N; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                long cur = (i - j) * (1 + Math.abs(stones[i] - stones[j]));
                min = Math.min(Math.max(dt[j], cur), min); 
            }
            dt[i] = min;
        }
        
        out.write(dt[N] + "");
        out.flush();
        out.close();
    }
}

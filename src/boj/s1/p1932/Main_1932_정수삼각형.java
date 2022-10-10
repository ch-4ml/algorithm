package boj.s1.p1932;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(in.readLine());
        int[] before = { Integer.parseInt(in.readLine()) };
        int[] after = null;
        for(int i = 2; i <= N; i++) {
            after = new int[i];
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < i; j++) {
                after[j] = Integer.parseInt(st.nextToken());
            }
            
            after[0] += before[0];
            after[i - 1] += before[i - 2];
            for(int j = 1; j < i - 1; j++) {
                after[j] += Math.max(before[j - 1], before[j]);
            }
            
            before = after;
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, before[i]);
        }
        
        out.write(max + "");
        out.flush();
        out.close();
    }
}

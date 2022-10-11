package boj.g4.p15961;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15961_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 2 <= N <= 3,000,000
        int D = Integer.parseInt(st.nextToken()); // 2 <= D <= 3,000
        int K = Integer.parseInt(st.nextToken()); // 2 <= K <= 3,000 (K <= N)
        int C = Integer.parseInt(st.nextToken()); // 1 <= C <= D
        
        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(in.readLine());
        }
        
        // 초밥 종류별 개수
        int[] selected = new int[D + 1];
        // K개를 연속해서 선택
        for (int i = 0; i < K; i++) {
            selected[sushi[i]]++;
        }
        
        int count = 0;
        for (int j = 1; j <= D; j++) {
            if (selected[j] > 0) {
                count++;
            }
        }
        
        int maxWithCoupon = 0;
        int maxWithoutCoupon = 0;
        
        for (int i = 0; i < N; i++) {
            if (selected[C] > 0) maxWithCoupon = Math.max(maxWithCoupon, count);
            else maxWithoutCoupon = Math.max(maxWithoutCoupon, count);
            
            if(--selected[sushi[i]] == 0) count--;
            if(++selected[sushi[i + K < N ? i + K : i + K - N]] == 1) count++;
        }
        
        out.write(maxWithCoupon > maxWithoutCoupon ? maxWithCoupon + "" : maxWithoutCoupon + 1 + "");
        out.flush();
        out.close();
    }
}

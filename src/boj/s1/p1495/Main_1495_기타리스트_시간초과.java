package boj.s1.p1495;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1495_기타리스트_시간초과 {
    
    static int N, S, M, max;
    static int[] volumes;
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        max = Integer.MIN_VALUE;
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        volumes = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            volumes[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, S);
        
        out.write(max == Integer.MIN_VALUE ? "-1" : max + "");
        out.flush();
        out.close();
    }

    private static void dfs(int idx, int volume) {
        if (volume < 0 || volume > M) return;
        if (idx == N) {
            max = Math.max(max, volume);
            return;
        }
        
        dfs(idx + 1, volume - volumes[idx]);
        dfs(idx + 1, volume + volumes[idx]);
    }
}

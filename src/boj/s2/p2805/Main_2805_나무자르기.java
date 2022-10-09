package boj.s2.p2805;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] heights = new int[N];
        st = new StringTokenizer(in.readLine());
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int height = heights[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, height);
        }
        
        long left = 0, mid = 0, sum = 0, height = 0;
        long right = max;
        
        while(left <= right) {
            mid = (left + right) / 2;
            sum = 0;
            for (int i = 0; i < N; i++) {
                height = heights[i];
                if(height <= mid) continue;
                sum += height - mid;
            }
            
            if (sum >= M) left = mid + 1;
            else right = mid - 1;
        }
        
        out.write(right + "");
        out.flush();
        out.close();
    }
}

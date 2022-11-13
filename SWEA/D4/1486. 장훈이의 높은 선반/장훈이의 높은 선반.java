import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    
    static int N, B, min;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;
            int[] heights = new int[N];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }
            
            powerset(heights);
            sb.append("#").append(t).append(" ").append(min - B).append("\n");
        }
        
        out.write(sb.toString());
        out.flush();
        out.close();
    }
    
    static void powerset(int[] source) {
        for (int i = 0; i < (1 << N); i++) {
            List<Integer> includes = new ArrayList<>();
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if ((1 << j & i) > 0) {
                    includes.add(source[j]);
                    sum += source[j];
                }
            }
            if (sum >= B) min = Math.min(min, sum);
        }
    }
}
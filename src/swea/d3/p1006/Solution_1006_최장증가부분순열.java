package swea.d3.p1006;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1006_최장증가부분순열 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(in.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(in.readLine());
            int[] arr = new int[N];
            int[] LIS = new int[N]; // 현재 인덱스의 원소를 마지막 원소로 갖는 LIS의 길이
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                LIS[i] = 1;
                for (int j = 0; j < i; j++) {
                    if(arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
                        LIS[i] = LIS[j] + 1;
                        max = Math.max(LIS[i], max);
                    }
                }
            }
            
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}

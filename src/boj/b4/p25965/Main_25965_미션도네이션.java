package boj.b4.p25965;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_25965_미션도네이션 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());
        for (int i = 0; i < N; i++) {
            long total = 0;
            
            int M = Integer.parseInt(in.readLine());
            long[][] missions = new long[M][3];
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(in.readLine());
                long[] mission = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
                missions[j] = mission;
            }
            
            st = new StringTokenizer(in.readLine());
            long k = Integer.parseInt(st.nextToken());
            long d = Integer.parseInt(st.nextToken());
            long a = Integer.parseInt(st.nextToken());
            
            for (int j = 0; j < M; j++) {
                long result = missions[j][0] * k - missions[j][1] * d + missions[j][2] * a;
                if (result > 0) total += result;
            }
            
            sb.append(total).append("\n");
        }
        
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}

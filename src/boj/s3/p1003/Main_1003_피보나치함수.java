package boj.s3.p1003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1003_피보나치함수 {
    
    static int[] fibos;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(in.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(in.readLine());
            fibos = new int[N + 1];
            if (N == 0) {
                sb.append(1).append(" ").append(0).append("\n");
            } else if (N == 1) {
                sb.append(0).append(" ").append(1).append("\n");
            } else if (N == 2) {
                sb.append(1).append(" ").append(1).append("\n");
            } else {
                fibo(N);
                sb.append(fibos[N - 1]).append(" ").append(fibos[N]).append("\n");
            }
            
        }
        
        out.write(sb.toString());
        out.flush();
        out.close();
    }
    
    static int fibo(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            if (fibos[n] > 0) return fibos[n];
            else return fibos[n] = fibo(n - 1) + fibo(n - 2);
        }
    }
}

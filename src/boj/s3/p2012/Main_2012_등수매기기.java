package boj.s3.p2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_2012_등수매기기 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        int[] rank = new int[N];
        for (int i = 0; i < N; i++) {
            rank[i] = Integer.parseInt(in.readLine());
        }
        
        Arrays.sort(rank);
        long result = 0;
        for (int i = 0; i < N; i++) {
            result += Math.abs(rank[i] - (i + 1));
        }
        
        out.write(result + "");
        out.flush();
        out.close();
    }
}

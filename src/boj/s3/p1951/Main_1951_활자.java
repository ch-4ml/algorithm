package boj.s3.p1951;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1951_활자 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long N = Integer.parseInt(in.readLine());
        long digit = new String(N + "").length();
        
        long count = 0;
        for (int i = 0; i < digit; i++) {
            count += 9 * (long) Math.pow(10, i) * (i + 1);
        }
        
        count += (N - ((long) Math.pow(10, digit) - 1)) * digit;
        out.write(count % 1234567 + "");
        out.flush();
        out.close();
    }
}

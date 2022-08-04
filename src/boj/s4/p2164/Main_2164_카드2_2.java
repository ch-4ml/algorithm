package boj.s4.p2164;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main_2164_카드2_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());        
        String binaryString = Integer.toBinaryString(N).replaceFirst("1", "0");
        int left = Integer.parseInt(binaryString, 2);
        if(left == 0) out.write(String.valueOf(N));
        else out.write(String.valueOf(left * 2));       
        out.flush();
        out.close();
    }    
}
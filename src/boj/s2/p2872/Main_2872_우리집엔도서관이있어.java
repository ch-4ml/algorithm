package boj.s2.p2872;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2872_우리집엔도서관이있어 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        int[] books = new int[N + 1];
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int i = 1; i <= N; i++) {
            int book = books[i] = Integer.parseInt(in.readLine());
            if (max < book) {
                max = book;
                maxIdx = i;
            }
        }
        
        int count = 0;
        while (maxIdx > 0) {
            if (books[maxIdx] == max) {
                count++;
                max--;
            }
            maxIdx--;
        }

        out.write(N - count + "");
        out.flush();
        out.close();
    }
}

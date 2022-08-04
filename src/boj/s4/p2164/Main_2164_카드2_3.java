package boj.s4.p2164;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

class Main_2164_카드2_3 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= N; i++) {
        	queue.offer(i);
        }
        
        while(queue.size() > 1) {
        	queue.poll();
        	queue.offer(queue.poll());
        }
        
        out.write(String.valueOf(queue.peek()));
        out.flush();
        out.close();
    }    
}
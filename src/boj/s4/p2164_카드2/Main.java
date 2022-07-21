package boj.s4.p2164_카드2;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String binaryString = Integer.toBinaryString(N).replaceFirst("1", "0");
        int left = Integer.parseInt(binaryString, 2);
        if(left == 0) System.out.println(N);
        else System.out.println(left * 2);       
        sc.close();        
    }    
}
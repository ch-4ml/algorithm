package boj.s3.p1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1929_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] strNums = in.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int a = Integer.valueOf(strNums[0]);
        int b = Integer.valueOf(strNums[1]);
        boolean flag;
        int n;
        while(a <= b) {
            flag = true;
            n = 2;
            while(n < a) {
                if(a % n++ == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                sb.append(a);
                sb.append("\n");
            }
            a++;
        }
        System.out.println(sb);
    }
}


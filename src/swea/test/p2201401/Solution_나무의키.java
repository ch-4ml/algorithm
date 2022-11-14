package swea.test.p2201401;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_나무의키 {
    
    static int[] trees;
    static int N, max;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(in.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(in.readLine());
            trees = new int[N];
            st = new StringTokenizer(in.readLine());
            max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                int tree = trees[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, tree);
            }
            
            int result = 0;
            int count = 0; // max가 아닌 나무 수 
            int leftOne = 0; // 높이 1 남은 나무 수
            int left = 0;
            for (int i = 0; i < N; i++) {
                int l = max - trees[i];
                if (l == 1) leftOne++;
                if (l != 0) count++;
                left += l;
            }
            
            // 모두 높이가 1 남은 나무인 경우
            if (count > 0 && count == leftOne) {
                result = count * 2 - 1;
            } else { // 나머지 경우
                int[] dt = new int[left + 1];
                boolean flag = true; // 홀수
                int evenCnt = 0;
                int current = 1; // 해당 값
                for (int i = 1; i <= left; i++) {
                    if (flag) {
                        dt[i] = current++;
                        flag = false;
                    } else {
                        dt[i] = current;
                        if (++evenCnt == 2) {
                            evenCnt = 0;
                            flag = true;
                            current++;
                        }
                    }
                }
                result = dt[left];
            }
            
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        
        out.write(sb.toString());
        out.flush();
        out.close();
    }
    
}

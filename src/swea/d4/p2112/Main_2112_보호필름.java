package swea.d4.p2112;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2112_보호필름 {
    
    static int D, W, K, min;
    static int[][] board;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(in.readLine());
        
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(in.readLine());
            D = Integer.parseInt(st.nextToken()); // 보호 필름의 두께
            W = Integer.parseInt(st.nextToken()); // 보호 필름의 가로 크기
            K = Integer.parseInt(st.nextToken()); // 합격 기준
            gmdk    
            board = new int[D][W];
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < W; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            if (K == 1) min = 0;
            else {
                min = Integer.MAX_VALUE;
                dfs(0);
            }
            
            sb.append("#").append(t).append(" ").append(min).append("\n");
//            System.out.println("#" + t + " " + min);
        }
        
        out.write(sb.toString());
        out.flush();
        out.close();
    }
    
    static void dfs(int count) {
        if (count > min || count > K) return;

        if (check()) {  
            System.out.println(count);
            min = Math.min(count, min);
            return;
        }
        
        for (int i = 0; i < D; i++) {
            int[] oldRow = new int[W];
            for (int j = 0; j < W; j++) {
                oldRow[j] = board[i][j];
            }
             
            // 현재 row를 모두 A로 변경 후 검사
            Arrays.fill(board[i], 0);
            dfs(count + 1);

            // 현재 row를 모두 B로 변경 후 검사
            Arrays.fill(board[i], 1);
            dfs(count + 1);
            
            board[i] = row;
        }
    }

    // 보호 필름이 성능 검사를 통과하는지 체크
    static boolean check() {
        for (int i = 0; i < W; i++) { // 열
            int cnt = 1; // 보호 필름 두께 초기화
            for (int j = 1; j < D; j++) { // 행
                if (board[j - 1][i] == board[j][i]) {
                    if (++cnt >= K) break;
                }
                else {
                    cnt = 1;
                    if (j > D - K) return false;
                }
            }
        }
        return true;
    }
}

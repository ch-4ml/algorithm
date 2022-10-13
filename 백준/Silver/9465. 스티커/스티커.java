import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(in.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(in.readLine());
            int[][] board = new int[2][N];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int[][] dt = new int[2][N];  // 현재 셀에서 구할 수 있는 최댓값을 저장한 다이나믹 테이블
            dt[0][0] += board[0][0];
            dt[1][0] += board[1][0];
            
            if(N > 1) {
                dt[0][1] += dt[1][0] + board[0][1];
                dt[1][1] += dt[0][0] + board[1][1];
            }
            
            for (int i = 2; i < N; i++) {
                dt[0][i] = Math.max(dt[1][i - 1], dt[1][i - 2]) + board[0][i];
                dt[1][i] = Math.max(dt[0][i - 1], dt[0][i - 2]) + board[1][i];
            }
            
            sb.append(Math.max(dt[0][N - 1], dt[1][N - 1])).append("\n");
        }
        
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
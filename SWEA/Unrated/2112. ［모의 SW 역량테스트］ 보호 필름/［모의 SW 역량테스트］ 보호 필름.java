import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int D, W, K, min;
    static int[][] film, tmpFilm;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(in.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(in.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            min = K;
            film = new int[D][W];
            tmpFilm = new int[D][W];
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                    tmpFilm[i][j] = film[i][j];
                }
            }
             
            if (K == 1) min = 0; // 효율
            else inject(0, 0);
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
         
        out.write(sb.toString());
        out.flush();
        out.close();
    }
 
    static void inject(int row, int cnt) {
        if (cnt >= min) return;
        if (check()) {
            min = Math.min(min, cnt);
            return;
        }
        if (row == D) return;
         
        // 약품 투입 하지 않고 다음 row 검사
        inject(row + 1, cnt);
         
        // A 약품 투입 후 다음 row 검사
        Arrays.fill(tmpFilm[row], 0);
        inject(row + 1, cnt + 1);
         
        // B 약품 투입 후 다음 row 검사
        Arrays.fill(tmpFilm[row], 1);
        inject(row + 1, cnt + 1);
         
        // 원래대로 되돌리기
        for (int i = 0; i < W; i++) {
            tmpFilm[row][i] = film[row][i];
        }
    }
 
    static boolean check() {
        col: for (int i = 0; i < W; i++) {
            int k = 1;
            for (int j = 1; j < D; j++) {
                k = tmpFilm[j - 1][i] == tmpFilm[j][i] ? k + 1 : 1;
                if (k >= K)
                    continue col;
            }
            return false;
        }
        return true;
    }
}
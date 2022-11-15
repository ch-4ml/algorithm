import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int D, W, K, min, r;
    static int[][] film;

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
            r = 0;
            min = Integer.MAX_VALUE;
            film = new int[D][W];
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (check())
                min = 0;
            else {
                for (int i = 1; i <= D; i++) {
                    r = i;
                    combination(new int[i], 0, 0);
                    if (min < Integer.MAX_VALUE)
                        break;
                }
            }

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static void combination(int[] comb, int idx, int start) {
        if (min < Integer.MAX_VALUE)
            return;
        if (idx == r) {
            
            int[][] old = new int[r][W];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < W; j++) {
                    old[i][j] = film[comb[i]][j];
                }
            }
            
            for (int i = 0; i < 1 << r; i++) {
                for (int j = 0; j < r; j++) {
                    inject(comb[j], (i & 1 << j) > 0 ? 1 : 0);
                }
                
                if (check()) {
                    min = r;
                    return;
                }
            }
            
            for (int i = 0; i < r; i++) {
                revert(comb[i], old[i]);
            }
            
            return;
        }

        for (int i = start; i < D; i++) {
            comb[idx] = i;
            combination(comb, idx + 1, i + 1);
        }
    }

    static void inject(int row, int medicine) {
        for (int i = 0; i < W; i++) {
            film[row][i] = medicine;
        }
    }

    static void revert(int row, int[] oldRow) {
        film[row] = oldRow;
    }

    static boolean check() {
        col: for (int i = 0; i < W; i++) {
            int k = 1;
            for (int j = 1; j < D; j++) {
                k = film[j - 1][i] == film[j][i] ? k + 1 : 1;
                if (k >= K)
                    continue col;
            }
            return false;
        }
        return true;
    }
}
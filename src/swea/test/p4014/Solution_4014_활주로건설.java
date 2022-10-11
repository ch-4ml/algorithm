package swea.test.p4014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설 {

    static int N, X;
    static int[][] map, map2;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            map2 = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    map2[j][i] = map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                answer += process(map[i]);
                answer += process(map2[i]);
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static int process(int[] row) {
        int basis = 1; // 오르막이 생길 때를 대비해서 땅의 길이를 누산
        int count = 0; // 내리막이 생겼을 때 경사로가 놓일 수 있는지 검사하기 위한 값
        
        for (int col = 1; col < N; col++) {
            if (row[col - 1] == row[col]) {
                basis++;
                if (count > 0) {
                    if (--count == 0) basis = 0;
                }
            } else {
                if (count > 0) return 0;
                
                if (row[col - 1] + 1 == row[col]) {
                    if (basis < X) return 0;
                }
                else if (row[col - 1] - 1 == row[col]) count = X - 1;
                else return 0;
                
                basis = 1;
            }
        }
        return count > 0 ? 0 : 1;
    }
}

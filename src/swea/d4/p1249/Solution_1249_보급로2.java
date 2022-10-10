package swea.d4.p1249;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_1249_보급로2 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        int T = Integer.parseInt(in.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(in.readLine());

            int[][] map = new int[N][N];
            int[][] time = new int[N][N];

            for (int i = 0; i < N; i++) {
                String row = in.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = row.charAt(j) - '0';
                    time[i][j] = -1;
                }
            }

            Queue<int[]> queue = new ArrayDeque<>();
            int[] pos = { 0, 0 };
            queue.offer(pos);
            time[0][0] = 0;

            while (!queue.isEmpty()) {
                int[] cPos = queue.poll();
                int r = cPos[0];
                int c = cPos[1];

                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                        continue;
                    if (time[nr][nc] < 0 || time[nr][nc] > time[r][c] + map[nr][nc]) {
                        time[nr][nc] = time[r][c] + map[nr][nc];
                        int[] nPos = { nr, nc };
                        queue.offer(nPos);
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(time[N - 1][N - 1]).append("\n");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}

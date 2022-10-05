import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] board = new int[R][C];
        boolean[][] visited = new boolean[R][C];

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        Queue<int[]> queue = new ArrayDeque<>();

        int cheese = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < C; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                if (num == 1)
                    cheese++;
            }
        }

        int time = 0;
        int hole = 0;
        while (cheese > 0) {
            hole = 0;
            int[] pos = { 0, 0 };
            queue.offer(pos);
            visited[0][0] = true;
            visited = new boolean[R][C];
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc])
                        continue;
                    if (board[nr][nc] == 0) {
                        visited[nr][nc] = true;
                        int[] nPos = { nr, nc };
                        queue.offer(nPos);
                    } else if (board[nr][nc] == 1) {
                        board[nr][nc] = -1;
                        hole++;
                    }
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(board[i][j] == -1) board[i][j] = 0;
                }
            }

            cheese -= hole;
            time++;
        }
        
        System.out.println(time);
        System.out.println(hole);
    }
}
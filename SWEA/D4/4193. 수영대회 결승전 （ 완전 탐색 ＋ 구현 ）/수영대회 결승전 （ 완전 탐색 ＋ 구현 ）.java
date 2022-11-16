import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    
    static int[][] map;
    static boolean[][] visited;
    static int N;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        
        int T = Integer.parseInt(in.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            st = new StringTokenizer(in.readLine());
            int[] start = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            st = new StringTokenizer(in.readLine());
            int[] dest = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(start);
            visited[start[0]][start[1]] = true;
            
            int time = 0;
            boolean isFound = false;
            calc:
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int[] pos = queue.poll();
                    int r = pos[0];
                    int c = pos[1];
                    if (r == dest[0] && c == dest[1]) {
                        queue.clear();
                        isFound = true;
                        break calc;
                    }
                    boolean isOfferedCurrentPosition = false;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        int next = check(nr, nc, time);
                        if (next == -1) continue;
                        else if (next == 0) { // 소용돌이가 치는 중
                            if (isOfferedCurrentPosition) continue;
                            isOfferedCurrentPosition = true;
                            queue.offer(pos);
                        } else {
                            visited[nr][nc] = true;
                            int[] nPos = { nr, nc };
                            queue.offer(nPos);
                        }
                    }
                }
                time++;
            }
            
            sb.append("#").append(t).append(" ").append(isFound ? time + "" : "-1").append("\n");
        }
        
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static int check(int r, int c, int time) {
        if (r < 0 || c < 0 || r >= N || c >= N || visited[r][c] || map[r][c] == 1) return -1;
        else if (map[r][c] == 2 && time % 3 != 2) return 0;
        else return 1;
    }
}
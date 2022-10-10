package swea.d5.p7793;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7793_오나의여신님 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(in.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            char[][] map = new char[N][M];
            boolean[][] visited = new boolean[N][M];
            
            int[] dest = new int[2];
            int[] dr = { -1, 0, 1, 0 };
            int[] dc = { 0, 1, 0, -1 };
            
            Queue<int[]> sQueue = new ArrayDeque<>();
            Queue<int[]> fQueue = new ArrayDeque<>();
            
            for(int i = 0; i < N; i++) {
                String row = in.readLine();
                for(int j = 0; j < M; j++) {
                    char c = row.charAt(j);
                    map[i][j] = c;
                    if(c == 'S') {
                        int[] start = new int[2];
                        start[0] = i;
                        start[1] = j;
                        visited[i][j] = true;
                        map[i][j] = '.';
                        sQueue.offer(start);
                    } else if(c == 'D') {
                        dest[0] = i;
                        dest[1] = j;
                    } else if(c == '*') {
                        int[] fire = new int[2]; 
                        fire[0] = i;
                        fire[1] = j;
                        fQueue.offer(fire);
                    }
                }
            }
            
            // 불을 먼저 퍼뜨리면 움직이려 할 때 걸러질 듯
            int count = 0;
            boolean flag = false;
            
            find:
            while(!sQueue.isEmpty()) {
                // 불 퍼뜨리기
                int fSize = fQueue.size();
                while(fSize-- > 0) {
                    int[] fPos = fQueue.poll();
                    int r = fPos[0];
                    int c = fPos[1];
                    
                    for(int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        if(nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] != '.') continue;
                        map[nr][nc] = '*';
                        int[] nPos = { nr, nc };
                        fQueue.offer(nPos);
                    }
                }
                
                // 수연이 이동하기
                int sSize = sQueue.size();
                while(sSize-- > 0) {
                    
                    int[] sPos = sQueue.poll();
                    int r = sPos[0];
                    int c = sPos[1];
                    if(r == dest[0] && c == dest[1]) {
                        flag = true;
                        break find;
                    }
                    
                    for(int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        if(nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == '*' || map[nr][nc] == 'X' || visited[nr][nc]) continue;
                        int[] nPos = { nr, nc };
                        visited[nr][nc] = true;
                        sQueue.offer(nPos);
                    }
                }
                
                count++;
            }
            sb.append("#").append(t).append(" ").append(flag ? count : "GAME OVER").append("\n");
        }
        
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}

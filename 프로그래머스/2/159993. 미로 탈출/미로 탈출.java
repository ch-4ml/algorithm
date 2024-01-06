import java.util.*;

class Solution {
    
    static int N;
    static int M;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, -1, 0, 1 };
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        int[] start = new int[2];
        int[] lever = new int[2];
        
        for (int i = 0; i < N; i += 1) {
            for (int j = 0; j < M; j += 1) {
                char c = maps[i].charAt(j);                
                int[] position = { i, j };
            
                if (c == 'S') start = position;
                if (c == 'L') lever = position;
            }
        }
        
        // 레버 찾기
        int leverDepth = bfs(maps, start, 'L');
        if (leverDepth == -1) return -1;
        
        // 출구 찾기
        int exitDepth = bfs(maps, lever, 'E');
        if (exitDepth == -1) return -1;
        
        return leverDepth + exitDepth;
    }
                    
    // TODO: BFS 를 함수로 만들어서 Target 지정하기
    private int bfs(String[] maps, int[] start, char target) {
        boolean[][] visited = new boolean[N][M];
        int depth = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] pos = q.poll();
                for (int d = 0; d < 4; d += 1) {
                    int row = pos[0] + dr[d];
                    int col = pos[1] + dc[d];
                    if (isMovable(maps, visited, row, col)) {
                        if (maps[row].charAt(col) == target) return depth + 1;
                        visited[row][col] = true;
                        int[] nextPos = { row, col };
                        q.offer(nextPos);
                    }
                }
            }
            depth += 1;
        }
        return -1;
    }
    
    private boolean isMovable(String[] maps, boolean[][] visited, int row, int col) {
        return 
            row > -1 &&
            col > -1 && 
            row < N && 
            col < M && 
            !visited[row][col] && 
            maps[row].charAt(col) != 'X';
    
    }
                         
}
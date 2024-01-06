import java.util.*;

class Solution {
    
    int N;
    int M;
    boolean[][] checked;
    List<boolean[]> hasColumnByGroup;
    int[] dr = { -1, 0, 1, 0 };
    int[] dc = { 0, -1, 0, 1 };
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        hasColumnByGroup = new ArrayList();
        
        checked = new boolean[N][M];
        List<List<int[]>> oilGroups = new ArrayList();
        for (int i = 0; i < N; i += 1) {
            for (int j = 0; j < M; j += 1) {
                if (land[i][j] == 1 && !checked[i][j]) {
                    int[] start = { i, j };
                    oilGroups.add(bfs(land, checked, start));
                }
            }
        }
        
        int[] sumByColumn = new int[M];
        for (int i = 0, size = oilGroups.size(); i < size; i += 1) {
            int oilCount = oilGroups.get(i).size();
            for (int j = 0; j < M; j += 1) {
                if (hasColumnByGroup.get(i)[j]) sumByColumn[j] += oilCount;
            }
        }
        
        int max = -1;
        for (int i = 0; i < M; i += 1) {
            max = Math.max(max, sumByColumn[i]);
        }
        
        return max;
    }
    
    // 같은 석유 덩어리의 좌표 리스트를 반환
    private List<int[]> bfs(int[][] land, boolean[][] checked, int[] start) {
        boolean[] hasColumn = new boolean[M];
        List<int[]> oilList = new ArrayList();
        Queue<int[]> q = new ArrayDeque();
        checked[start[0]][start[1]] = true;
        q.offer(start);
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            hasColumn[pos[1]] = true;
            oilList.add(pos);
            for (int d = 0; d < 4; d += 1) {
                int r = pos[0] + dr[d];
                int c = pos[1] + dc[d];
                if (isOil(land, r, c)) {
                    checked[r][c] = true;
                    int[] newPos = { r, c };
                    q.offer(newPos);
                }
            }
        }
        hasColumnByGroup.add(hasColumn);
        return oilList;
    }
    
    private boolean isOil(int[][] land, int row, int col) {
        return 
            row > -1 &&
            col > -1 &&
            row < N &&
            col < M &&
            !checked[row][col] &&
            land[row][col] == 1;
    }
}
import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    int[][] map;
    int[][] rectangles;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    int R, C, rMin, cMin, rMax, cMax;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        rectangles = rectangle;
        // 지도의 크기 정하기
        rMin = Integer.MAX_VALUE;
        cMin = Integer.MAX_VALUE;
        rMax = Integer.MIN_VALUE;
        cMax = Integer.MIN_VALUE;
        for (int[] rect : rectangle) {
            int c1 = rect[0];
            int r1 = rect[1];
            int c2 = rect[2];
            int r2 = rect[3];

            rMin = Math.min(rMin, r1);
            rMax = Math.max(rMax, r2);
            cMin = Math.min(cMin, c1);
            cMax = Math.max(cMax, c2);
        }

        // 주어진 사각형을 기반으로 지도 만들기. 최소 좌표를 0으로 조정함에 주의
        R = rMax - rMin + 1;
        C = cMax - cMin + 1;
        map = new int[R][C];
        for (int[] rect : rectangle) {
            int c1 = rect[0] - cMin;
            int r1 = rect[1] - rMin;
            int c2 = rect[2] - cMin;
            int r2 = rect[3] - rMin;

            for (int i = r1; i <= r2; i += 1) {
                for (int j = c1; j <= c2; j += 1) {
                    if (i == r1 || i == r2 || j == c1 || j == c2) map[i][j] += 1;
                    else map[i][j] += 2;
                }
            }
        }

        return bfs(characterY - rMin, characterX - cMin, itemY - rMin, itemX - cMin);
    }

    public int bfs(int startR, int startC, int targetR, int targetC) {
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> queue = new ArrayDeque<>();

        int[] start = {startR, startC};
        visited[startR][startC] = true;
        queue.offer(start);

        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.poll();
                if (current == null) break;

                while (queue.size() < 2) {
                    int min = Integer.MAX_VALUE;
                    int direction = -1;
                    for (int i = 0; i < 4; i += 1) {
                        int nr = current[0] + dr[i];
                        int nc = current[1] + dc[i];
                        int[] next = {nr, nc};
                        if (nr > -1 && nc > -1 && nr < R && nc < C && isMovable(current, next) && !visited[nr][nc] && map[nr][nc] > 0 && min > map[nr][nc]) {
                            min = map[nr][nc];
                            direction = i;
                        }
                    }

                    if (direction == -1) break;

                    int nr = current[0] + dr[direction];
                    int nc = current[1] + dc[direction];
                    if (nr == targetR && nc == targetC) return distance + 1;

                    visited[nr][nc] = true;
                    int[] next = {nr, nc};
                    queue.offer(next);
                }
            }
            distance += 1;
        }
        return -1;
    }

    public boolean isMovable(int[] from, int[] to) {
        boolean isIncluded = false;
        boolean isCrossed = false;
        for (int[] rect : rectangles) {
            int c1 = rect[0] - cMin;
            int r1 = rect[1] - rMin;
            int c2 = rect[2] - cMin;
            int r2 = rect[3] - rMin;

            if (isTargetIncluded(r1, r2, c1, c2, from) && isTargetIncluded(r1, r2, c1, c2, to)) {
                isIncluded = true;
                isCrossed = isCrossed(r1, r2, c1, c2, from, to);
                if (isCrossed) return false;
            }
        }

        return isIncluded;
    }

    // 한 칸 이동 검사 중 사각형을 가로지르는 경우를 검사
    public boolean isCrossed(int r1, int r2, int c1, int c2, int[] from, int[] to) {
        int sameVertical = from[0] - to[0];
        int sameHorizontal = from[1] - to[1];

        // 두 점이 같은 세로선에 있는 경우
        if (sameHorizontal == 0) {
            // 사각형의 세로 크기가 2 이상이면 가로지르지 않음
            if (r2 - r1 > 1) return false;
            // 사각형의 세로 크기가 1 이라도 양쪽 가로 끝에 있다면 가로지르지 않음
            if ((from[1] == c1 && to[1] == c1) || (from[1] == c2 && to[1] == c2)) return false;
        }

        // 두 점이 같은 가로선에 있는 경우
        if (sameVertical == 0) {
            // 사각형의 가로 크기가 2 이상이면 가로지르지 않음
            if (c2 - c1 > 1) return false;
            // 사각형의 가로 크기가 1 이라도 양쪽 세로 끝에 있다면 가로지르지 않음
            if ((from[0] == r1 && to[0] == r1) || (from[0] == r2 && to[0] == r2)) return false;
        }

        // 사각형을 가로지르는 경우
        return true;
    }

    public boolean isTargetIncluded(int r1, int r2, int c1, int c2, int[] target) {
        boolean includedInRow = (target[0] == r1 || target[0] == r2) && target[1] >= c1 && target[1] <= c2;
        boolean includedInCol = target[0] >= r1 && target[0] <= r2 && (target[1] == c1 || target[1] == c2);
        return includedInRow || includedInCol;
    }
}

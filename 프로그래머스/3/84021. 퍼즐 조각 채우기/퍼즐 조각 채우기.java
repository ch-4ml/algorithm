import java.util.*;

class Solution {

    static int N;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public int solution(int[][] game_board, int[][] table) {
        N = game_board.length;
        
        // 보드의 빈 칸을 탐색하면서 빈 칸 모양 리스트 만들기
        List<List<int[]>> spaces = new ArrayList<>();
        for (int r = 0; r < N; r += 1) {
            for (int c = 0; c < N; c += 1) {
                if (game_board[r][c] == 0) {
                    spaces.add(bfs(r, c, 0, game_board));   
                }
            }
        }

        // 테이블의 블록을 탐색하면서 블록 모양 리스트 만들기
        List<List<int[]>> blocks = new ArrayList<>();
        for (int r = 0; r < N; r += 1) {
            for (int c = 0; c < N; c += 1) {
                if (table[r][c] == 1) {
                    blocks.add(bfs(r, c, 1, table));    
                }
            }
        }
        
        // 빈 칸 모양 리스트를 탐색하면서 블록 모양 맞춰보기
        int total = 0;
        for (List<int[]> space : spaces) {
            boolean isMatched = false;
            findBlock:
            for (int i = 0; i < blocks.size(); i += 1) {
                List<int[]> block = blocks.get(i);
                if (space.size() == block.size()) {
                    for (int j = 0; j < 4; j += 1) {
                        rotate90(block);
                        if (isEqual(space, block)) {
                            total += space.size();
                            isMatched = true;
                            blocks.remove(i);
                            break findBlock;
                        }
                    }
                }
            }
        }

        return total;
    }

    // board 의 (r, c) 위치부터 target을 탐색해 만들어지는 좌표 리스트를 반환
    public List<int[]> bfs(int r, int c, int target, int[][] board) {
        List<int[]> shape = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        int[] start = {r, c};
        queue.offer(start);

        int visited = 1 - target;
        board[r][c] = visited;

        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            shape.add(coordinate);
            for (int i = 0; i < 4; i += 1) {
                int nr = coordinate[0] + dr[i];
                int nc = coordinate[1] + dc[i];
                if (nr > -1 && nc > -1 && nr < N && nc < N && board[nr][nc] == target) {
                    int[] next = {nr, nc};
                    queue.offer(next);
                    board[nr][nc] = visited;
                }
            }
        }

        // 정렬
        adjust(shape);
        return shape;
    }

    // 시계방향으로 90도 회전시킴
    public void rotate90(List<int[]> block) {
        int rMax = Integer.MIN_VALUE;
        int cMax = Integer.MIN_VALUE;
        int rMin = Integer.MAX_VALUE;
        int cMin = Integer.MAX_VALUE;
        for (int[] coordinate : block) {
            rMax = Math.max(rMax, coordinate[0]);
            cMax = Math.max(cMax, coordinate[1]);
            rMin = Math.min(rMin, coordinate[0]);
            cMin = Math.min(cMin, coordinate[1]);
        }
        int rSize = rMax - rMin + 1;
        for (int[] coordinate : block) {
            int temp = coordinate[0];
            coordinate[0] = coordinate[1];
            coordinate[1] = rSize - 1 - temp;
        }

        adjust(block);
    }

    // 두 개의 모양을 단순하게 비교할 수 있도록 아래 조건으로 데이터를 수정함
    // 1. 좌표의 최솟값이 항상 0이 되도록
    // 2. row, col을 기준으로 오름차순 정렬
    public void adjust(List<int[]> shape) {
        int rMin = Integer.MAX_VALUE;
        int cMin = Integer.MAX_VALUE;
        for (int[] coordinate : shape) {
            rMin = Math.min(rMin, coordinate[0]);
            cMin = Math.min(cMin, coordinate[1]);
        }

        for (int[] coordinate : shape) {
            coordinate[0] -= rMin;
            coordinate[1] -= cMin;
        }

        shape.sort((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
    }

    public boolean isEqual(List<int[]> shape1, List<int[]> shape2) {
        int size = shape1.size();
        if (size != shape2.size()) return false;

        for (int i = 0; i < size; i += 1) {
            if (shape1.get(i)[0] != shape2.get(i)[0]) return false;
            if (shape1.get(i)[1] != shape2.get(i)[1]) return false;
        }

        return true;
    }
    
    // public String printShape(List<int[]> shape) {
    //     StringBuilder sb = new StringBuilder();
    //     for (int[] coordinate : shape) {
    //         sb.append(Arrays.toString(coordinate));
    //         sb.append(" ");
    //     }
    //     return sb.toString();
    // }
}

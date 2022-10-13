package boj.p5.p23289;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_23289_온풍기안녕 {
    
    static int R, C, K, W;
    static int[][] map, tempMap;
    static boolean[][] wallsLtoR, wallsDtoU;
    static List<Heater> heaters;
    static List<int[]> check;
    
    static class Heater {
        int r, c, direction;

        public Heater(int r, int c, int direction) {
            this.r = r;
            this.c = c;
            this.direction = direction;
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        R = Integer.parseInt(st.nextToken()); // 행 개수
        C = Integer.parseInt(st.nextToken()); // 열 개수
        K = Integer.parseInt(st.nextToken()); // 조사해야 하는 칸의 온도가 모두 K 이상인지 검사해야 함
        
        map = new int[R][C];
        tempMap = new int[R][C];
        heaters = new ArrayList<>();
        check = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < C; j++) {
                // 0: 빈 칸, 1: 오른쪽을 바라보는 온풍기, 2: 왼쪽을 바라보는 온풍기, 3: 위쪽을 바라보는 온풍기, 4: 아래쪽을 바라보는 온풍기, 5: 온도를 조사해야 하는 칸
                int info = Integer.parseInt(st.nextToken()); 
                if (info > 4) {
                    int[] pos = { i, j };
                    check.add(pos);
                } else if (info > 0) {
                    heaters.add(new Heater(i, j, info));
                } 
                map[i][j] = 0;
            }
        }
        
        W = Integer.parseInt(in.readLine());
        wallsLtoR = new boolean[R][C];
        wallsDtoU = new boolean[R][C];
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()); // 0: (r, c) -> (r - 1, c) 벽, 1: (r, c) -> (r, c + 1) 벽
            if (d == 0) wallsDtoU[r][c] = true;
            else wallsLtoR[r][c] = true; 
            
            
        }
        
        int chocolate = 0;
        while(chocolate <= 100) {
            // 1. 집에 있는 모든 온풍기에서 바람이 한 번 나옴
            heat();

            // 2. 온도가 조절됨
            balance();
            
            // 3. 온도가 1 이상인 가장 바깥쪽 칸의 온도가 1씩 감소
            cool();
            
            // 4. 초콜릿을 하나 먹는다.
            chocolate++;
            
            // 5. 조사하는 모든 칸의 온도가 K 이상이 되었는지 검사. 모든 칸의 온도가 K 이상이면 테스트를 중단하고, 아니면 1부터 다시 시작
            if (checkGoal()) break;
        }
        
        out.write(chocolate + "");
        out.flush();
        out.close();
    }
    
    static void heat() {
        // 방향에 따라 퍼지는 시나리오, 벽, 
    }
    
    static void balance() {
        // BFS, 벽 위치를 고려해서 가능한 영역으로 계산된 값만큼 열 전도
    }
    
    static void cool() {
        // BFS, 모든 0인 지점부터 visited 체크하면서 사방 탐색, 0이 아닌 지점이 queue에서 나오면 그 위치의 온도를 1 낮춤
    }
    
    static boolean checkGoal() {
        for (int i = 0, size = check.size(); i < size; i++) {
            int[] pos = check.get(i);
            int r = pos[0];
            int c = pos[1];
            if (map[r][c] < K) {
                return false;
            }
        }
        return true;
    }
}

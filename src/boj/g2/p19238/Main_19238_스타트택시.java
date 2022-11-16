package boj.g2.p19238;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 승객 데리러 갈 때 거리 같으면 우선순위(행번호 작은 순 -> 열번호 작은 순) 체크하기
// 목적지 도달 시 승객을 "태워서" 움직인 거리 * 2 만큼 연료 충전 

public class Main_19238_스타트택시 {

    static boolean[][] visited;
    static int[][] map;
    static int N, M, F;

    static List<int[]> pStart = new ArrayList<>();
    static List<int[]> pDest = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());

        int[] dr = { 1, 0, -1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        Queue<int[]> queue = new ArrayDeque<>();

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(in.readLine());
        int[] pos = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int[] start = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            int[] dest = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            pStart.add(start);
            pDest.add(dest);
            map[start[0]][start[1]] = 2;
        }

        queue.offer(pos);
        visited[pos[0]][pos[1]] = true;
        
        boolean flag = false; // 승객 탑승 여부
        
        while (!queue.isEmpty() && F > 0) {
            int size = queue.size();
            int distance = 0;
            int psr = Integer.MAX_VALUE; // 다음 승객 좌표
            int psc = Integer.MAX_VALUE;
            int pdr = -1;
            int pdc = -1;
            int pIndex = -1;
            while (size-- > 0) {
                int[] cp = queue.poll();
                int r = cp[0];
                int c = cp[1];
                if (!flag && map[r][c] == 2) { // 승객 있음
                    if (r < psr || (r == psr && c < psc)) {
                        psr = r;
                        psc = c;
                    }
                } else if(flag && r == pdr && c == pdc) {
                    F += distance * 2;
                    flag = false;
                    map[psr][psc] = 1;
                    pStart.remove(pIndex);
                    pDest.remove(pIndex);
                    queue.clear();
                    pos[0] = pdr;
                    pos[1] = pdc;
                    queue.offer(pos);
                    continue;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (!isAvailable(nr, nc))
                        continue;
                    int[] np = { nr, nc };
                    visited[nr][nc] = true;
                    queue.offer(np);
                }
            }
            
            // 찾은 승객에 대해서 거리 계산
            if (psr < Integer.MAX_VALUE) {
                for (int i = 0; i < pStart.size(); i++) {
                    int[] p = pStart.get(i);
                    if (psr == p[0] && psc == p[1]) pIndex = i;
                }
                
                queue.clear();
                pos[0] = psr;
                pos[1] = psc;
                queue.offer(pos);
                
                flag = true;
                distance = -1;
            }
            
            distance++;
            F--;
            System.out.println(F);
        }
        
        // 실패
        if (pStart.size() > 0) out.write("-1");
        else out.write(F + "");
        out.flush();
        out.close();
    }

    static boolean isAvailable(int r, int c) {
        return r > 0 && c > 0 && r <= N && c <= N && !visited[r][c] && map[r][c] != 1;
    }
}

package swea.d4.p1249;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_1249_보급로3 {

    static int[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(in.readLine());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String row = in.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = row.charAt(j) - '0';
                }
            }
            
            int ans = dijkstra(0, 0, N);
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static int dijkstra(int startR, int startC, int N) {

        int[][] minCost = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        int INF = Integer.MAX_VALUE;

        // 출발지에서 자신(현재 인덱스)로의 최소비용을 저장할 배열 생성 후 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                minCost[i][j] = INF;
            }
        }

        // 출발지에서의 최소비용 처리
        minCost[startR][startC] = 0;

        int r = 0, c = 0, nr, nc, min;
        while (true) {

            // 1. 방문하지 않은 정점 중 최소 비용인 정점 찾기
            r = c = -1;
            min = INF;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && min > minCost[i][j]) {
                        min = minCost[i][j];
                        r = i;
                        c = j;
                    }
                }
            }

            // r, c가 -1인 경우 더이상 갈 수 있는 정점이 없음
            if (r == -1)
                return -1;

            // 2. 방문 처리
            visited[r][c] = true;
            if (r == N - 1 && c == N - 1)
                return min;

            // 3. 현재 정점 기준으로 인접한 정점을 들여다보며 경유 비용이 유리한지 계산
            int[] dr = { -1, 0, 1, 0 };
            int[] dc = { 0, 1, 0, -1 };
            for (int d = 0; d < 4; d++) {
                nr = r + dr[d];
                nc = c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && minCost[nr][nc] > min + map[nr][nc]) {
                    minCost[nr][nc] = min + map[nr][nc];
                }
            }
        }
    }

}

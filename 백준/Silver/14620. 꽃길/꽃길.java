import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    
    static boolean[][] visited;
    static int[][] map;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int N, min;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        min = Integer.MAX_VALUE;
        visited = new boolean[N][N];
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 0 ~ N-1까지 심을 수 있지만, 가장 외곽에 심는 경우 꽃잎이 빠져나가서 꽃을 심을 수 없음
        dfs(N + 1, 0, 0);
        
        out.write(min + "");
        out.flush();
        out.close();
    }
   
    private static void dfs(int idx, int cnt, int sum) {
        
        // 이미 최솟값을 넘김
        if (sum > min) return;
        
        // 최솟값을 넘지 않고, 3개의 꽃을 정상적으로 심음
        if (cnt == 3) {
            min = sum;
            return;
        }
        
        // 끝까지 수행하였음
        if (idx == N * (N - 1)) return;
        
        int r = idx / N;
        int c = idx % N;
        
        // 이번 칸에 꽃을 심지 않는 경우
        dfs(idx + 1, cnt, sum);
        
        // 이번 칸에 꽃을 심는 경우
        if (check(r, c)) {
            int acc = plant(r, c, true);
            dfs(idx + 1, cnt + 1, sum + acc);
            plant(r, c, false);
        }
    }
        
    private static int plant(int r, int c, boolean isPlant) {
        int sum = map[r][c];
        visited[r][c] = isPlant;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            sum += map[nr][nc];
            visited[nr][nc] = isPlant;
        }
        return sum;
    }

    private static boolean check(int r, int c) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) return false;
        }
        
        return true;
    }
}
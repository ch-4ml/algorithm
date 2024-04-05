import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] map;
    static int[] hole = new int[2];
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int[] red = new int[2];
        int[] blue = new int[2];

        for (int i = 0; i < N; i += 1) {
            String row = in.readLine();
            for (int j = 0; j < M; j += 1) {
                char c = row.charAt(j);
                map[i][j] = c == '#' ? '#' : '.';
                if (c == 'R') red = new int[]{i, j};
                if (c == 'B') blue = new int[]{i, j};
                if (c == 'O') hole = new int[]{i, j};
            }
        }

        out.write(String.valueOf(bfs(red, blue)));
        out.flush();
        out.close();
    }

    public static int bfs(int[] red, int[] blue) {
        Queue<int[]> queueR = new ArrayDeque<>();
        Queue<int[]> queueB = new ArrayDeque<>();
        Queue<Integer> queueD = new ArrayDeque<>(); // direction
        queueR.add(red);
        queueB.add(blue);
        queueD.add(-1);

        int count = 0;
        while (!queueR.isEmpty()) {
            int size = queueR.size();
            while (size-- > 0) {
                if (queueR.isEmpty() || queueB.isEmpty() || queueD.isEmpty()) break;
                int[] currentR = queueR.poll();
                int[] currentB = queueB.poll();
                int previousDirection = queueD.poll();
                for (int i = 0; i < 4; i += 1) {
                    if (previousDirection > -1 && i == (previousDirection + 2) % 4) continue;
                    int[] nextR, nextB;

                    if (isBlueInFrontOfRed(currentR, currentB, i)) {
                        nextB = move(currentB, currentR, i);
                        nextR = move(currentR, nextB, i);
                    } else {
                        nextR = move(currentR, currentB, i);
                        nextB = move(currentB, nextR, i);
                    }

                    if (nextB[0] == -1) continue;
                    else if (nextR[0] == -1) return count + 1;

                    queueR.add(nextR);
                    queueB.add(nextB);
                    queueD.add(i);
                }
            }
            count += 1;
            if (count >= 10) return -1;
        }
        return -1;
    }

    // 이동하려는 방향 기준으로 파란 구슬이 빨간 구슬보다 앞에 있는지 검사
    public static boolean isBlueInFrontOfRed(int[] red, int[] blue, int direction) {
        if (direction == 0 && red[1] == blue[1] && red[0] > blue[0]) return true;
        if (direction == 1 && red[0] == blue[0] && red[1] < blue[1]) return true;
        if (direction == 2 && red[1] == blue[1] && red[0] < blue[0]) return true;
        if (direction == 3 && red[0] == blue[0] && red[1] > blue[1]) return true;
        return false;
    }

    // {-1, -1}: 구멍에 빠짐
    public static int[] move(int[] marble, int[] oppositeMarble, int direction) {
        int r = marble[0];
        int c = marble[1];
        while (true) {
            int nr = r + dr[direction];
            int nc = c + dc[direction];
            if (map[nr][nc] == '#' || (nr == oppositeMarble[0] && nc == oppositeMarble[1])) break;
            if (nr == hole[0] && nc == hole[1]) return new int[]{-1, -1};
            r = nr;
            c = nc;
        }
        return new int[]{r, c};
    }
}
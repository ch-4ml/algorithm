import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static final int SIZE = 65536;
    static int N;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(in.readLine());
        int[] house = new int[2];
        int[] festival = new int[2];
        
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(in.readLine());
            int[][] cvs = new int[N][2];
            boolean[] visitedCVS = new boolean[N];
            
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            house[0] = r;
            house[1] = c;
                    
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                cvs[i][0] = Integer.parseInt(st.nextToken());
                cvs[i][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(in.readLine());
            festival[0] = Integer.parseInt(st.nextToken());
            festival[1] = Integer.parseInt(st.nextToken());
            
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(house);
            
            boolean isHappy = false;
            bfs: 
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int[] pos = queue.poll();
                    r = pos[0];
                    c = pos[1];
                    
                    if (getDistance(r, c, festival[0], festival[1]) <= 1000) {
                        isHappy = true;
                        break bfs;
                    }
                    
                    for (int i = 0; i < N; i++) {
                        if (!visitedCVS[i] && getDistance(r, c, cvs[i][0], cvs[i][1]) <= 1000) {
                            visitedCVS[i] = true;
                            int[] curCVS = { cvs[i][0], cvs[i][1] };
                            queue.offer(curCVS);
                        }
                    }
                }
            }
            
            sb.append(isHappy ? "happy" : "sad").append("\n");
        }
        
        out.write(sb.toString());
        out.flush();
        out.close();
    }
    
    static boolean isAvailable(int r, int c) {
        return r >= 0 && c >= 0 && r < SIZE && c < SIZE;
    }
    
    static int getDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}

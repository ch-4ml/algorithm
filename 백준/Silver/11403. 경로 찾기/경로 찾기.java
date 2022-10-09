import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] adjMatrix;
    static int[][] path;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        adjMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        path = new int[N][N];
        Queue<Integer> queue = null;
        boolean[] visited = null;
        for (int i = 0; i < N; i++) {
            queue = new ArrayDeque<>();
            visited = new boolean[N];
            
            queue.offer(i);
            
            while(!queue.isEmpty()) {
                int vertex = queue.poll();
                for (int j = 0; j < N; j++) {
                    if (adjMatrix[vertex][j] == 0 || visited[j]) continue;
                    visited[j] = true;
                    path[i][j] = 1;
                    queue.offer(j);
                }
            }
        }
        
        // DRAW
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(path[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static class Node {
        int vertex;
        Node next;

        public Node(int vertex, Node next) {
            this.vertex = vertex;
            this.next = next;
        }

    }

    static Node[] adjList;
    static int[] enter;
    static int[] leave;
    static int N, M;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // path를 저장하는 matrix 만들어서 모든 노드에 대해 참조하거나 참조 당하면 count
        int T = Integer.parseInt(in.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(in.readLine());
            adjList = new Node[N + 1];
            enter = new int[N + 1];
            leave = new int[N + 1];
            M = Integer.parseInt(in.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjList[from] = new Node(to, adjList[from]);
            }
            
            for (int i = 1; i <= N; i++) {
                bfs(i);
            }
            
            int answer = 0;
            for (int i = 1; i <= N; i++) {
                if (enter[i] + leave[i] == N - 1) answer++;
            }
            
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static void bfs(int current) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(current);
        visited[current] = true;
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (Node node = adjList[vertex]; node != null; node = node.next) {
                int next = node.vertex;
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    leave[current]++;
                    enter[next]++;
                }
            }
        }
    }
}
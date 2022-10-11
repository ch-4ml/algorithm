package swea.d4.p5643;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키순서 {

    static class Node {
        int vertex;
        Node next;

        public Node(int vertex, Node next) {
            super();
            this.vertex = vertex;
            this.next = next;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // path를 저장하는 matrix 만들어서 모든 노드에 대해 참조하거나 참조 당하면 count
        int T = Integer.parseInt(in.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(in.readLine());
            Node[] adjList = new Node[N];

            int M = Integer.parseInt(in.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjList[from] = new Node(to, adjList[from]);
            }
            
            boolean[][] path = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                Queue<Integer> queue = new ArrayDeque<>();
                boolean[] visited = new boolean[N];
                queue.offer(i);
                
                while(!queue.isEmpty()) {
                    int v = queue.poll();
                    for (Node node = adjList[v]; node != null; node = node.next) {
                        int n = node.vertex;
                        if (!visited[n]) {
                            visited[n] = true;
                            path[i][n] = true;
                        }
                    }
                }
            }
        }
        
    }
}

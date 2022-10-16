package boj.g3.p1238;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1238_파티 {

    static class Node {
        int vertex, weight;
        Node next;

        public Node(int vertex, int weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }

    static int N, M, X;
    static Node[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        // 다익스트라를 끝까지 해서 각 N부터 X까지의 최단 거리 중 최댓값을 구하는 문제
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        adjList = new Node[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from] = new Node(to, weight, adjList[from]);
        }

        int max = Integer.MIN_VALUE;
        // 모든 노드에 대해서 검사
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, getMinDistance(i, X) + getMinDistance(X, i));
        }

        out.write(max + "");
        out.flush();
        out.close();
    }

    // Dijkstra
    static int getMinDistance(int startNode, int endNode) {
        int[] D = new int[N + 1];
        boolean[] visited = new boolean[N + 1]; // start -> N 확정된 최소 거리가 저장됨
        
        Arrays.fill(D, Integer.MAX_VALUE);
        D[startNode] = 0;
        
        int min, minVertex;
        // 노드 수만큼 반복하며 최단 경로 찾기
        for (int rep = 1; rep <= N; rep++) {
            min = Integer.MAX_VALUE;
            minVertex = -1;
            
            // 아직 확정되지 않은 노드 중 이동 비용이 최소인 노드 선택
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && min > D[i]) {
                    min = D[i];
                    minVertex = i;
                }
            }
            
            // 도착지까지의 최소 이동 시간을 구한 경우 return
            if (minVertex == endNode) return D[endNode];
            
            // 방문 처리 (이 노드까지 최소가 보장된 이동 시간을 기록)
            visited[minVertex] = true;

            // 최소 거리 최신화
            for (Node node = adjList[minVertex]; node != null; node = node.next) {
                int vertex = node.vertex;
                if (!visited[vertex]) {
                    D[vertex] = Math.min(D[vertex], D[minVertex] + node.weight);
                }
            }
        }

        return D[endNode];
    }
}

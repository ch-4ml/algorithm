import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i += 1) {
            edges.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            int from = e[0] - 1;
            int to = e[1] - 1;
            edges.get(from).add(to);
            edges.get(to).add(from);
        }

        return bfs(n, edges);
    }

    public int bfs(int n, List<List<Integer>> edges) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        boolean[] visited = new boolean[n];
        visited[0] = true;

        int answer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            answer = size;
            while (size-- > 0) {
                if (queue.isEmpty()) break;
                int vertex = queue.poll();
                for (int e : edges.get(vertex)) {
                    if (!visited[e]) {
                        visited[e] = true;
                        queue.offer(e);
                    }
                }
            }
        }

        return answer;
    }
}
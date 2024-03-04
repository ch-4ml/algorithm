import java.util.*;

class Solution {

    static int N;
    static List<Integer>[] connections;
    static List<int[]> bridges;

    public int solution(int n, int[][] costs) {
        N = n;
        // 자료 구조 생성
        connections = new ArrayList[n];
        for (int i = 0; i < n; i += 1) {
            connections[i] = new ArrayList<>();
        }

        // 정렬
        bridges = Arrays.asList(costs);
        bridges.sort(Comparator.comparingInt(o -> o[2]));

        // 탐색 및 추가
        int sum = 0;
        for (int[] bridge : bridges) {
            int s = bridge[0];
            int e = bridge[1];

            if (isConnected(s, e)) continue;
            
            connections[s].add(e);
            connections[e].add(s);
            sum += bridge[2];

            if (isFullyConnected()) break;
        }

        return sum;
    }

    boolean isConnected(int s, int e) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        queue.offer(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int island = queue.poll();
            for (int i : connections[island]) {
                if (i == e) return true;
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        return false;
    }

    boolean isFullyConnected() {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int island = queue.poll();
            for (int i : connections[island]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        for (int i = 0; i < N; i += 1) {
            if (!visited[i]) return false;
        }
        return true;
    }
}
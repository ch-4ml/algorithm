import java.util.*;

public class Solution {
    public int solution(int n, int[][] results) {
        List<List<Integer>> winners = new ArrayList<>();
        List<List<Integer>> losers = new ArrayList<>();
        for (int i = 0; i <= n; i += 1) {
            winners.add(new ArrayList<>());
            losers.add(new ArrayList<>());
        }

        for (int[] result : results) {
            int win = result[0];
            int lose = result[1];
            winners.get(lose).add(win);
            losers.get(win).add(lose);
        }

        int answer = 0;
        for (int i = 1; i <= n; i += 1) {
            if (countOpponents(i, winners) + countOpponents(i, losers) == n - 1) answer += 1;
        }

        return answer;
    }

    // TODO: 메모이제이션으로 중복 연산 줄이기
    public int countOpponents(int boxer, List<List<Integer>> opponents) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[opponents.size()];
        queue.offer(boxer);
        visited[boxer] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            List<Integer> opponentsByBoxer = opponents.get(current);
            for (int opponent : opponentsByBoxer) {
                if (!visited[opponent]) {
                    visited[opponent] = true;
                    count += 1;
                    queue.offer(opponent);
                }
            }
        }

        return count;
    }
}
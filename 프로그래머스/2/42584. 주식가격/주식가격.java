import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i += 1) {
            int size = queue.size();
            for (int j = 0; j < size; j += 1) {
                int idx = queue.poll();
                if (prices[idx] > prices[i]) result[idx] = i - idx;
                else queue.offer(idx);
            }
            queue.offer(i);
        }
        
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            result[idx] = n - 1 - idx;
        }
        
        return result;
    }
}
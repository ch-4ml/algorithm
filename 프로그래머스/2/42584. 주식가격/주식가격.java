import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i += 1) {
            int size = queue.size();
            for (int j = 0; j < size; j += 1) {
                int[] q = queue.poll();
                if (q[1] > prices[i]) result[q[0]] = i - q[0];
                else queue.offer(q);
            }
            int[] price = { i, prices[i] };
            queue.offer(price);
        }
        
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            result[q[0]] = n - 1 - q[0];
        }
        
        return result;
    }
}
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
                
        for(int s: scoville) {
            pq.offer(s);
        }
        
        while (pq.size() > 0) {
            if (pq.peek() >= K) return answer;
            if (pq.size() == 1) break;
            
            answer += 1;
            pq.offer(pq.poll() + pq.poll() * 2);
        }
        
        return -1;
    }
}
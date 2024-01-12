import java.util.*;

class Solution {
    public int solution(int[][] jobs) {        
        Arrays.sort(jobs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int jobIndex = 0;
        int startTime = 0;
        int endTime = 0;
        int spentTime = 0;
        Queue<int[]> pq = new PriorityQueue<int[]>(jobs.length, (int[] a, int[] b) -> a[1] - b[1]);
        pq.offer(jobs[jobIndex++]);
        
        while (!pq.isEmpty()) {
            int[] job = pq.poll();
            startTime = Math.max(job[0], endTime);
            endTime = startTime + job[1];
            
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= endTime) {
                pq.offer(jobs[jobIndex++]);
            }
            
            spentTime += endTime - job[0];
            
            if (pq.isEmpty() && jobIndex < jobs.length) pq.offer(jobs[jobIndex++]);
        }
        
        return spentTime / jobs.length;
    }
}
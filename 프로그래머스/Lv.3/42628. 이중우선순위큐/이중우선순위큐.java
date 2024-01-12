import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        Queue<Integer> maxPriorityQueue = new PriorityQueue<Integer>((a, b) -> b - a);
        Queue<Integer> minPriorityQueue = new PriorityQueue<>();
        
        for (int i = 0; i < operations.length; i += 1) {
            String[] operation = operations[i].split(" ");
            
            String op = operation[0];
            Integer n = Integer.parseInt(operation[1]);
            System.out.println(op + " " + n);
            
            if ("I".equals(op)) {
                maxPriorityQueue.offer(n);
                minPriorityQueue.offer(n);
            } else if ("D".equals(op)) {
                if (n == 1) {
                    maxPriorityQueue.poll();
                } else if (n == -1) {
                    minPriorityQueue.poll();
                }
                
                if (maxPriorityQueue.isEmpty() || minPriorityQueue.isEmpty()) {
                    maxPriorityQueue.clear();
                    minPriorityQueue.clear();
                }
            }
            System.out.println(i);
            System.out.println(maxPriorityQueue.toString());
            System.out.println(minPriorityQueue.toString());
        }
        
        // 둘 다 가지고 있는 값 찾기
        List<Integer> queue = new ArrayList<>();
        Integer[] arr = maxPriorityQueue.toArray(new Integer[]{0});
        for (int i = 0; i < arr.length; i += 1) {
            Integer n = arr[i];
            if (minPriorityQueue.contains(n)) queue.add(n);
        }
        
        // System.out.println(queue.toString());

        
        if (queue.isEmpty()) {
            answer = new int[]{0, 0};
            return answer;
        }
        
        // 최대, 최소 구하기
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < queue.size(); i += 1) {
            int n = queue.get(i);
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        
        answer = new int[]{max, min};
        return answer;
    }
}
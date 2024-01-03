import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length - 1;
                
        while ((end - start) > -1) {
            int left = limit - people[end--];
            if (left - people[start] >= 0) {
                start += 1;
            }
            answer += 1;
        }
        
        return answer;
    }
}
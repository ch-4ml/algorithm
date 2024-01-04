import java.util.*;

class Solution {
    public int[] solution(String[] gems) {        
        // 종류 찾기
        Map<String, Integer> gemIndex = new HashMap<>();
        Integer numberOfGemTypes = 0;
        
        for (int i = 0, size = gems.length; i < size; i += 1) {
            if (!gemIndex.containsKey(gems[i])) gemIndex.put(gems[i], numberOfGemTypes++);
        }
                        
        int start = 0;
        int end = numberOfGemTypes - 1; // inclusive
                
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        // initialize
        int[] gemCounts = new int[numberOfGemTypes];
        for (int i = start; i <= end; i += 1) {
            gemCounts[gemIndex.get(gems[i])]++;
        }
        
        boolean flag = findIndex(gemCounts, 0) == -1;
                
        // 현재 선택된 보석 종류
        while (end <= gems.length) {
            if (flag) {
                if (min > end - start + 1) {
                    min = end - start + 1;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }
                if (min == numberOfGemTypes) return answer;
                gemCounts[gemIndex.get(gems[start])] -= 1;
                flag = gemCounts[gemIndex.get(gems[start])] > 0;
                start += 1;
            } else {
                end += 1;
                if (end >= gems.length) break;
                gemCounts[gemIndex.get(gems[end])] += 1;
                flag = findIndex(gemCounts, 0) == -1;
            }
        }
                        
        return answer;
    }
    
    int findIndex(int[] arr, int target) {
        for (int i = 0, size = arr.length; i < size; i += 1) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
}
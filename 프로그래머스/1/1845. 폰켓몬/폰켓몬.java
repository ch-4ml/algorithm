import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) map.put(num, 0);
            map.put(num, map.get(num) + 1);
        }

        return Math.min(nums.length / 2, map.keySet().size());
    }
}
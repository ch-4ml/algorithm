import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i += 1) {
            Character parenthesis = s.charAt(i);
            if (')' == parenthesis) {
                if (stack.isEmpty()) return false;
                Character top = stack.pop();
                if ('(' != top) return false;
            } else stack.push(parenthesis);
        }

        return stack.isEmpty();
    }
}
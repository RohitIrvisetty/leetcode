import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
        );
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // If it's a closing bracket
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            }
            // If it's an opening bracket
            else if (map.containsValue(c)) {
                stack.push(c);
            }
            // Ignore everything else
        }
        
        return stack.isEmpty();
    }
}
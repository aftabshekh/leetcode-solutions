class Solution {
    public boolean isValid(String s) {
          Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // If opening bracket, push
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // If closing bracket, check match
            else {
                if (stack.isEmpty()) return false; // No matching opening
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Stack should be empty for valid parentheses
        return stack.isEmpty();
    }

}

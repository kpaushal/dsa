import java.util.Stack;

class Solution {

    public boolean backspaceCompare(String s, String t) {

        return buildString(s).equals(buildString(t));
    }

    private String buildString(String str) {

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {

            if (ch == '#') {

                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {

                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}
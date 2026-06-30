import java.util.Stack;

class Solution {

    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (String operation : operations) {

            if (operation.equals("+")) {

                int last = stack.pop();
                int secondLast = stack.peek();

                stack.push(last);
                stack.push(last + secondLast);

            } else if (operation.equals("D")) {

                stack.push(stack.peek() * 2);

            } else if (operation.equals("C")) {

                stack.pop();

            } else {

                stack.push(Integer.parseInt(operation));
            }
        }

        int total = 0;

        while (!stack.isEmpty()) {
            total += stack.pop();
        }

        return total;
    }
}
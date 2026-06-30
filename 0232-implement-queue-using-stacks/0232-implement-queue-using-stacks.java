import java.util.Stack;

class MyQueue {

    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue() {

        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(int x) {

        inputStack.push(x);
    }

    public int pop() {

        moveElements();

        return outputStack.pop();
    }

    public int peek() {

        moveElements();

        return outputStack.peek();
    }

    public boolean empty() {

        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    private void moveElements() {

        if (outputStack.isEmpty()) {

            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
}
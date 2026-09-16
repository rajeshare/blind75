package org.monotonicstack;

import java.util.Stack;

public class MinStack {
    public Stack<Integer> stack;
    public Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x < minStack.peek()){
            minStack.push(x);
        }
    }
    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int value = stack.pop();
        if (value == minStack.peek()) {
            minStack.pop();
        }
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {

        MinStack ms = new MinStack();

        ms.push(10);
        ms.push(5);
        ms.push(8);
        ms.push(2);
        ms.push(6);

        System.out.println("Top: " + ms.top());
        System.out.println("Min: " + ms.getMin());

        ms.pop();

        System.out.println("Top: " + ms.top());
        System.out.println("Min: " + ms.getMin());

        ms.pop();

        System.out.println("Min: " + ms.getMin());
    }

}

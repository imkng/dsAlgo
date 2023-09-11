package com.company.stack;

public class StackImpl {
    public static void main(String[] args) throws StackException {
        StackImplUsingArray stack = new StackImplUsingArray(-1);
        System.out.println(stack.peek());
        stack.push(12);
        System.out.println(stack.peek());
        System.out.println(stack.top);
        System.out.println("====================================");
        stack.push(2);
        stack.pop();
        stack.pop();
        stack.pop();
    }
}

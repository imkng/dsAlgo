package com.company.stack;

import java.util.*;

public class NextGreaterElement {
    static List<Integer> array = List.of(1, 2, 1, 6, 7, 10);

    public static void main(String[] args) {
        List<Integer> outPut = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = array.size() - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                outPut.add(-1);
            } else if (!stack.isEmpty() && stack.peek() > array.get(i)) {
                outPut.add(stack.peek());
            } else if (!stack.isEmpty() && stack.peek() <= array.get(i)) {
                while (!stack.isEmpty() && stack.peek() <= array.get(i)) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    outPut.add(-1);
                } else {
                    outPut.add(stack.peek());
                }
            }
            stack.push(array.get(i));
        }
        Collections.reverse(outPut);
        System.out.println(outPut);
    }
}

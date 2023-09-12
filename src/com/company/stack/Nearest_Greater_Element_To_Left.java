package com.company.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Nearest_Greater_Element_To_Left {
    static List<Integer> array = List.of(5, 3, 5, 6, 5, 10);

    // output Array: -1, 5, -1, -1, 6, -1
    public static void main(String[] args) {
        List<Integer> output = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (Integer integer : array) {
            if (stack.isEmpty()) {
                output.add(-1);
            } else if (!stack.isEmpty() && stack.peek() > integer) {
                output.add(stack.peek());
            } else if (!stack.isEmpty() && stack.peek() <= integer) {
                while (!stack.isEmpty() && stack.peek() <= integer) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    output.add(-1);
                } else {
                    output.add(stack.peek());
                }
            }
            stack.push(integer);
        }
        System.out.println(output);
        //output: {-1, 5, -1, -1, 6, -1}
    }
}

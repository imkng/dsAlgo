package com.company.stack;

import java.util.*;

public class NumberOfStudentsUnableToEatLunch {
    public static int countStudents(int[] students, int[] sandwiches) {
//        int[] students = new int[]{1,1,0,0};
//        int[] sandwiches = new int[]{0,1,0,1};

        Queue<Integer> studentQueue = new LinkedList<>();

        for (int i = 0; i < students.length; i++) {
            studentQueue.add(students[i]);
        }
        int count = 0;
        for (int i = 0; i < sandwiches.length; ) {
            if (sandwiches[i] == studentQueue.peek()) {
                studentQueue.remove();
                i++;
                count = 0;
            } else {
                studentQueue.add(studentQueue.peek());
                studentQueue.remove();
                count++;

                if (count >= studentQueue.size()) {
                    break;
                }
            }
        }
        return studentQueue.size();
    }

    public static void main(String[] args) {
        int[] students = new int[]{1, 1, 0, 0};
        int[] sandwiches = new int[]{0, 1, 0, 1};
        int answer = countStudents(students, sandwiches);
        System.out.println(answer);
    }
}

package com.company.threads;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,54,1,4,6);

        Collections.sort(list, (e1,e2)-> e2-e1);
        for (int ele :
                list) {
            System.out.println(ele);
        }
    }
}

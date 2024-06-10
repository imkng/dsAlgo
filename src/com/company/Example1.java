package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example1 {
//    static int[] arr = {3, 3, 4, 345, 3, 0, 2, 23234, 34};

    public static void main(String[] args) {
//        int count = 0;
//        List<Integer> temp = new ArrayList<>();
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i] != 3){
//                temp.add(arr[i]);
//            }else{
//                count++;
//            }
//        }
//        for (int i = 0; i < count; i++) {
//            temp.add(3);
//        }
//        for (int ele: temp) {
//            System.out.print(ele + " ");
//        }


        String str = "234Adas";
        if (str.length() <3){
            System.out.println(false);
        }
        Pattern pattern1 = Pattern.compile("[0-9a-zA-Z]*");
        Pattern pattern2 = Pattern.compile(".*[aeiouAEIOU].*" );
        Pattern pattern3 = Pattern.compile(".*[a-zA-Z&&[^aeiouAEIOU]].*");

        Matcher matcher1 = pattern1.matcher(str);
        Matcher matcher2 = pattern2.matcher(str);
        Matcher matcher3 = pattern3.matcher(str);

        if (matcher2.matches() && matcher1.matches() && matcher3.matches()){
            System.out.println(true);
        }else {
            System.out.println(false);
        }


    }
}


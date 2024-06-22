package com.company.hashMap;

import java.util.*;

public class StringCompression {

    static char[] chars = {'a','b','b','b','b','b', 'b','b','b','b','b','b', 'b'};
    public static void main(String[] args) {
        int ans = compress(chars);
        System.out.println(ans);

    }

    private static int compress(char[] chars) {
        int ans = 0;
        Map<Character, Integer> map = new LinkedHashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
//        List<Character> list = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        for (Map.Entry<Character, Integer> ele: map.entrySet()){
            stringBuilder.append(ele.getKey());
//            list.add(ele.getKey());
            if (ele.getValue() > 1){
                stringBuilder.append(ele.getValue().toString());
            }
        }
        System.out.println(stringBuilder);
        for (int i = 0; i < stringBuilder.length(); i++) {
            chars[i] = stringBuilder.charAt(i);
        }
        return stringBuilder.length();
    }
}

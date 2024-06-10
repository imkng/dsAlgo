package com.company.regex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example1 {
    public static void main(String[] args) {


        List<String> blockedIp = Arrays.asList("*111.*", "123.*", "34.*");

        List<String> reguestIps = Arrays.asList("123.1.23.34", "121.1.23.34", "121.1.23.34", "34.1.23.34",
                "121.1.23.34", "12.1.23.34", "121.1.23.34");

        for (int i = 0; i < reguestIps.size(); i++) {
            int blocked = 0;
            for (int j = 0; j < blockedIp.size(); j++) {
                if (checkBlockedIp(reguestIps.get(i), blockedIp.get(j))){
                    blocked = 1;
                    break;
                }
            }
            if(blocked != 1){
                int k = 0;
                Map<String, Integer> map = new HashMap<>();
                while (k < reguestIps.size()){
                    if(!map.containsKey(reguestIps.get(k))){
                        map.put(reguestIps.get(k), 1);
                    }else {
                        blocked = 1;
                        break;
                    }
                    if(k-i+1 < 5){
                        k++;
                    }else if( k - i + 1 == 5){
                        break;
                    }
                }
            }
            if (blocked == 1){
                System.out.println(reguestIps.get(i));
            }
        }

    }

    private static boolean checkBlockedIp(String reguestIp, String regex1) {

        String converted = regex1.replace("*", "[0-9.]*");

        Pattern pattern = Pattern.compile(converted);
        // to string we need to perform regex

        Matcher matcher = pattern.matcher(reguestIp);

        //get the result;
        if (matcher.matches()){
            return true;
        }
        return false;
    }
}

package com.company;

import java.util.*;

public class GroupAnargams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(int i = 0 ; i < strs.length; i++){

            char tempArray[] = strs[i].toCharArray();
            Arrays.sort(tempArray);

            String temp = new String(tempArray);

            if(!map.containsKey(temp)){
                List<String> stringList = new ArrayList<>();
                stringList.add(strs[i]);
                map.put(temp, stringList);
            }else{
                List<String> stringList = map.get(temp);
                stringList.add(strs[i]);
                map.put(temp, stringList);
            }
        }
        for(Map.Entry<String, List<String>> itr : map.entrySet()){
            ans.add(itr.getValue());
        }
        return ans;
    }
}

package com.company.arrays;

public class RemoveAllAdjacentDuplicatesInString {
    static String str = "azxxzy";

    public static void main(String[] args) {
        String ans = removeDuplicates(str);
        System.out.println(ans);
    }

    private static String removeDuplicates(String str) {
        StringBuffer stringBuffer  = new StringBuffer(str);

        int i = 0;
        while (i < stringBuffer.length() - 1){
            if (stringBuffer.charAt(i) == stringBuffer.charAt(i+1)){
                stringBuffer.deleteCharAt(i+1);
                stringBuffer.deleteCharAt(i);
                i--;
                if(i < 0){
                    i++;
                }
            }else {
                i++;
            }
        }
        return stringBuffer.toString();
    }
}

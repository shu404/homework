package com.my.homework;

import com.sun.org.apache.xpath.internal.objects.XString;

public class Count {
    public static void main(String[] args) {

    }

    public static int countChar(String string){
        //String string = "System up with the top down,Got the city on lock down,Drive by in the low ride,Hands high when we fly by,System up with the top down,Got the city on lock down,Drive by in the low ride,Hands high when we fly by.";
        char[] chars = {};

        for(int i=0; i<string.length(); i++){
            char ch = string.charAt(i);
            int count = 0;

            //System.out.println(ch);
            for(int j=0; j<chars.length; j++){
                if(ch == chars[j]){

                    ++count;
                    break;
                }
            }

        }
        return 0;
    }

}

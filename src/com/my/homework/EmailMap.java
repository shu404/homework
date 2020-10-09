package com.my.homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EmailMap {
    public static void main(String[] args) {
        String[] emails = {"zhang@sohu.com","lisi@163.com","wangwu@sina.com","zhangsan@qq.com"};
        String[] name = new String[4];

        for(int i=0; i<emails.length; i++){
            String[] temp = emails[i].split("@");
            name[i]=temp[0];
            System.out.println(name[i]);
        }

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        for (int i=0; i<emails.length; i++){
            stringStringHashMap.put(name[i], emails[i]);
        }

        Set<Map.Entry<String, String>> entries = stringStringHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next);
        }

    }
}

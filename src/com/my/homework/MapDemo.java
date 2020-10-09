package com.my.homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void map(){
        Map<String, String> map = new HashMap<>();
        map.put("11", "shu");
        map.put("22", "jing");
        map.put("33", "liang");
        System.out.println(map);
        System.out.println(map.get("11"));
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
       while (iterator.hasNext()){
           Map.Entry<String, String> next = iterator.next();
           System.out.println(next);
       }
        Set<String> keySet = map.keySet
                ();
       for (String key : keySet){
           System.out.println(key+map.get(key));
       }



    }

    public static void main(String[] args) {
        map();
    }
}

package com.my.homework;

import java.io.*;

public class CharStream {
    public static void main(String[] args) {
        charWrite();
    }

    private static void charWrite(){
        int count1 = 0;
        int count2 = 0;
        char[] chars = new char[2];
        BufferedReader bufferedReader = null;
        try {

           bufferedReader = new BufferedReader(new FileReader("E:\\ideaProjects\\homework\\src\\test.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
           while(bufferedReader.read() != -1){
               ++count1;
           }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while (bufferedReader.read(chars) != -1){
                System.out.println(chars);
                if(chars.toString().equals("三菱")){
                    ++count2;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("字符总数是："+count1);

        System.out.println("三菱总数是："+count2);
    }

    public static void traverseFile(String dir){
        File file = new File("dir");

        if(file.isFile()){
            System.out.println(file.getName());
        }else file.listFiles();
    }

}

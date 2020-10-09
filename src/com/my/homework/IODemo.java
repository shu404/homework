package com.my.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IODemo {
    public static void main(String[] args) throws IOException {
        File file1 = null;
        File file2 = null;
        try {
            file1 = new File("test.txt");
            if (!file1.exists() && !file2.exists()) {
                System.err.println("文件1或文件2不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileInputStream in1 = null;
        FileInputStream in2 = null;
        try {
            in1 = new FileInputStream(file1);
            in2 = new FileInputStream(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte[] bytes1 = new byte[10240];
        byte[] bytes2 = new byte[10240];

        in1.read(bytes1);
        in2.read(bytes2);

        for (int i=0; i<bytes1.length; i++){
            if(bytes1[i] == bytes2[i]){
                continue;
            }else {
                System.out.println("不是完全相同");
                break;
            }
        }


    }
}

package com.my.homework;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class Test {

    /**
    public static void main(String[] args) throws ParseException {
        Calendar calendar = new GregorianCalendar(2018, 2, 23, 18, 23, 53);
        Date d = calendar.getTime();

        System.out.println(d);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(d);
               System.out.println(date);

       Date date1 = simpleDateFormat.parse("2019-5-30 20:32:46");
        System.out.println(date1);


        System.out.println(cirArea(2));

        int i = 2;
        Integer I = i;
        System.out.println(Integer.valueOf(i));
        System.out.println(Integer.parseInt("3"));

        System.out.println(I.intValue());

        int[][] arr = new int[3][3];
        System.out.println(Arrays.deepToString(arr));
        //System.out.println((int)(Math.ceil(-7.3)));


    }

    public static double cirArea(int r){
        return Math.PI*Math.pow(r,2);
    }

    */
    public static void main(String[] args) {
        String[] emails = new String[]{"12345@qq.com", "aaaaaa", "aaaa@123.com", "333333", "23{[@qq.com"};
        System.out.println("合法的邮箱是:");
        for (String email: emails) {
            if(isValidEmail( email) == true) {
                System.out.println(email);
            }
        }

        String string1 = "abccba";
        String string2 = "abc";
        System.out.println("abccba是回文吗："+ isReverse(string1));
        System.out.println("abc是回文吗："+ isReverse(string2));
        //isReverse(string2);
       // File file = new File();
       // printFilesAndDirects(file);
        printDirectories("E:\\录屏");

        try {
            modify("E:\\录屏\\a.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        test();
    }
    public static boolean isValidEmail(String email) {


            if ((email != null) && (!email.isEmpty())) {
                return Pattern.matches("^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][A-Za-z0-9]+)*$", email);
            }
            return false;
    }

    public static boolean isReverse(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        StringBuffer reverse = stringBuffer.reverse();
        System.out.println("stringBuffer"+stringBuffer);
        System.out.println("resever"+reverse);
        String revString = reverse.toString();
        if(revString.equals(str)){
            return true;
        }
        return false;
    }

    public static void printFilesAndDirects(File file) {

        if(!file.exists()) {
            System.out.println("文件不存在，错误");
            return;
        }

        if (file.isFile()){
            System.out.println("改文件名是："+file.getName());
            return;
        }


        System.out.println("该目录名是："+file.getName());
      //  printFilesAndDirects(file.);

    }

    public static void printDirectories(String fileName) {
        File file = new File(fileName);
        if(!file.exists()){
            System.out.println("改目录不存在");
            file.mkdir();
            return;
        }

        File[] listFiles = file.listFiles();
        for (File f : listFiles ){
            System.out.println(f.getName());
        }


    }

    public static void modify(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
            return ;

        }

        Date data = new Date(file.lastModified());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(fileName+"文件最后修改时间是"+simpleDateFormat.format(data));
        return ;
    }

    public static void test(){
        StringBuffer stringBuffer = new StringBuffer("123");
        System.out.println("test反向 是"+stringBuffer.reverse());
        if(stringBuffer == stringBuffer.reverse()){
            System.out.println("stringBuffer == stringBuffer.reverse()");
        }
    }

}

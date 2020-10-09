package com.my.homework;

import java.io.File;

public class CreateFile {


    public static void main(String[] args) {
        try {
            Person person = new Person("shu", 20);
            System.out.println();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}

class Person {
    private String name;
    private int age;



    public Person() {
    }

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }
}

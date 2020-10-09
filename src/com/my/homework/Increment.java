package com.my.homework;

public class Increment {
    public static void main(String[] args) {
        MyT t = new MyT();
        Thread thread1 =new Thread(t);

        try {
            thread1.start();
            thread1.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main finished");
    }
}

class MyT extends Thread{
    private int i= 0;

    @Override
    public void run() {
        while (i<3){
            System.out.println("sub"+i);
            i++;
        }
    }
}
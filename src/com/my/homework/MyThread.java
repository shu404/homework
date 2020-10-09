package com.my.homework;

public class MyThread {
    private static void t1(){
        // 创建子线程对象
        MyThread1 t1 = new MyThread1("mythread1");
        t1.start();//启动子线程 ， 会自动执行，不需干预。
    }
    private static void t2(){
        new MyThread2("mythread2").start();//创建子线程且启动
        System.out.println("程序结束");
    }
    private static void t3(){
        // 创建自定义线程对象
        MyThread3 t3 = new MyThread3();
        //需要借助Thread对象，包装自定义线程对象 ,然后在启动。
        new Thread(t3,"mythread3").start();
    }
    private static void t4(){
        //利用Thread的匿名子类创建子线程对象
        new Thread("no name sub class 1"){
            @Override
            public void run() {
                System.out.println(getName()+"子线程执行啦");
            }
        }.start();

        new Thread("no name sub class 2"){
            @Override
            public void run() {
                System.out.println(getName()+"子线程执行啦");
            }
        }.start();
    }
    private static void t5(){
        Runnable ra = new Runnable(){
            private int a=0;
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"子线程执行啦"+(++a));
            }
        };
        //可以用多个Thread包装同一个Runable对象。
        new Thread(ra,"no name runable 1").start();
        new Thread(ra,"no name runable 2").start();
        new Thread(ra,"no name runable 3").start();
    }
    private static void t6(){
        new Thread("no name1"){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName()+":"+(i+1));
                }
            }
        }.start();
        new Thread("no name2"){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName()+":"+(i+1));
                }
            }
        }.start();
        new Thread("no name3"){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName()+":"+(i+1));
                }
            }
        }.start();
        System.out.println("程序结束");
    }

    static void t10(){
        new Thread() {
            @Override
            public void run() {
                System.out.println("这是t10;");
            }
        }.start();
    }
    public static void main(String[] args) {
        t10();
    }
}

//自定义类实现Runnable接口 ，
class MyThread3 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"子线程执行啦。");
    }
}

class MyThread2 extends Thread{
    public MyThread2(String name) {
        super(name);
    }
    @Override
    public void run() {
        //输出1-20 ， 延缓输出 ， 需要线程名
        for (int i = 1; i < 21; i++) {
//            Thread.sleep();
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName()+":"+i);
        }
    }
}


//继承jdk提供的Thread线程类 ， 变成了线程类
class MyThread1 extends Thread{
    //通过构造方法指定线程名 , 不指定时 会自动分配线程名
    public MyThread1(String name){
        //super(name);
    }
    @Override
    public void run() {
        // 子线程需要实现的功能代码
        System.out.println(this.getName()+"子线程运行啦");
    }


}

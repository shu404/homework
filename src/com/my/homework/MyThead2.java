package com.my.homework;

public class MyThead2 {
    public static void main(String[] args) {

       Thread t = new Thread("子线程"){
            @Override
            public void run() {
                int n=1, k=1;
                double sum=0;
                while ((k<=10000)){
                    if(k%2 == 0){
                        sum -= -1.0/n;

                    }else {
                        sum +=1.0/n;
                    }
                    n += 2;
                    k++;
                }
                System.out.println(sum);
            }
        };
        t.start();
        try {
            t.join();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double sum =0;
        double before =1L, next = 0L;
        for (int i=1; i<=100; i++){
            next = i*before;
            before = next;
            sum += 1/next;
        }
        System.out.println(sum);
    }
}

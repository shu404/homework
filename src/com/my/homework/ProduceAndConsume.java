package com.my.homework;

public class ProduceAndConsume {
    public static void main(String[] args) {
        Store store = new Store();
        Produce produce = new Produce("生产者", store);
        Consume consume = new Consume("消费者", store);
        produce.start();
        consume.start();
    }
}

class Store{
    int[] store = new int[100];
    int index = 0;

    public synchronized void produre(int val){
        try {
            if(index>= store.length){
                wait();
            }else {
                store[index++]= val;
                System.out.println(Thread.currentThread().getName()+"生产了"+val);
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void consume(){
        try {
            if(index<=0){
                wait();
            }else {
                int val = store[--index];
                System.out.println("消费了"+val);
                notifyAll();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class Produce extends Thread {
    private Store store;
    public Produce(String name, Store store) {
        super(name);
        this.store = store;
    }

    @Override
    public void run() {
        int val = 1;
        try {
            while (true){
                sleep(1000);
                store.produre(val++);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consume extends Thread{
    private Store store;

    public Consume(String name, Store store) {
        super(name);
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (true){
                sleep(1000);
                store.consume();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

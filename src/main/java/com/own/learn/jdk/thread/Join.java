package com.own.learn.jdk.thread;

/**
 * @author wangzhenya
 */
public class Join {

    public static void main(String[] args) {

        Thread previous = Thread.currentThread();

        for (int i=0; i< 10; i++) {

            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
    }
}

class Domino implements Runnable {

    private Thread thread;

    public Domino(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {

        try {
            thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " , " + " terminate.");
    }
}
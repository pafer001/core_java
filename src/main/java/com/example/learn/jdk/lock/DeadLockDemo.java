package com.example.learn.jdk.lock;

/**
 * @author wangzhenya
 */
public class DeadLockDemo {

    private static String A = "A";
    private static String B = "B";


    public static void main(String[] args) {

        new DeadLockDemo().deadLock();
    }
    private void deadLock() {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (A) {

                    try {

                        Thread.currentThread().sleep(20000000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                synchronized (B) {
                        System.out.println("1");
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

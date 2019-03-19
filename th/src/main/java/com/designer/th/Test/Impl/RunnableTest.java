package com.designer.th.Test.Impl;

public class RunnableTest implements Runnable {
    private  static int tick = 60;
//    private String name;
//    public RunnableTest(String name){
//        this.name = name;
//    }
    @Override
    public void run() {
        while (true) {
            synchronized (RunnableTest.class) {
                if (tick == 0) {
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "=========" + tick--);
            }
        }
    }
    public static void main(String[] args) {
        RunnableTest runnableTest=new RunnableTest();
        Thread t1 = new Thread(runnableTest,"窗口1");
        Thread t2 = new Thread(runnableTest,"窗口2");
        t1.start();
        t2.start();
       try {
           t1.join();
           t2.join();
       }catch (Exception e){
           e.printStackTrace();
       }

    }
}



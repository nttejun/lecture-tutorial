package com.thread;

public class ThreadTest2 {
    public static void main(String[] args){
        Thread2 thread1 = new Thread2("첫 번째 스레드");
        Thread2 thread2 = new Thread2("두 번째 스레드");

        Thread threadObj1 = new Thread(thread1);
        Thread threadObj2 = new Thread(thread2);

        threadObj1.start();
        threadObj2.start();

        System.out.println("runnable thread1, thread2 실행");
    }
}

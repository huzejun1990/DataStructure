package com.dream.study.juc;

/**
 * Created by huzejun
 * on 2020/11/10 21:27
 *
 * 可重入锁：可重复可递归调用的锁，在外层使用锁之后，在内层仍然可以使用，并且不发生死锁，这样的锁就叫可重入锁。
 *
 * 在一个Synchronized修饰的方法或代码的内部
 * 调用本类的其他Synchronized修饰的方法或代码块时，是永远可以得到锁的
 */
public class ReEnterLockDemo {

    static Object objectLockA = new Object();

    public static void m1(){

        new Thread(() ->{
            synchronized (objectLockA){
                System.out.println(Thread.currentThread().getName()+"\t"+"----外层调用--------");
                synchronized (objectLockA){
                    System.out.println(Thread.currentThread().getName()+"\t"+"-----中层调用-----");
                    synchronized (objectLockA){
                        System.out.println(Thread.currentThread().getName()+"\t"+"------内层调用--------");
                    }
                }
            }
        },"t1").start();

    }

    public static void main(String[] args) {

        m1();
    }
}

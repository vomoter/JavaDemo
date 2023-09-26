package mythread.src.threadsafe03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread{

        //表示这个类的所以对象，都共享ticket变量
        static int ticket=0;
        //锁对象：一定要是唯一的
        static  Object object=new Object();

        //创建锁lock的子类对象
        static Lock lock=new ReentrantLock();

        @Override
        public void run() {
            while (true){
                //文件字节码对象也是唯一的
                //synchronized (threadsafe01.MyThread.class) {
                lock.lock();    //上锁
                    if (ticket < 100){
                        ticket++;
                        System.out.println(getName()+"正在卖第"+ticket+"张票");
                    }   else {
                        break;
                    }
                //}
                lock.unlock();  //开锁
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
}


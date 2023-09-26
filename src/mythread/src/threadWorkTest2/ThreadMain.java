package mythread.src.threadWorkTest2;

public class ThreadMain {
    public static void main(String[] args) {

        /*
        *   问题：有100份礼物，两人同时发送，当剩下的礼物小于10份时不在送出
        *   要求：利用多线程模拟该过程并将线程的名字和礼物的剩余数量打印出来
         */
        GiftRunnable g=new GiftRunnable();

        Thread t1=new Thread(g);
        Thread t2=new Thread(g);

        t1.setName("张三");
        t2.setName("李四");

        t1.start();
        t2.start();



    }
}

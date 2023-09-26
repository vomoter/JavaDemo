package mythread.src.threadWorkTest1;

public class ThreadMain {
    public static void main(String[] args) {
        /*
        *   问题：一共有1000张电影票，可以在两个窗口领取，假设每次领取的时间为3000毫秒，
        *   要求：请用多线程模拟卖票过程并打印剩余电影票的数量
        * */


        MyThread m1=new MyThread();
        MyThread m2=new MyThread();

        m1.setName("窗口1");
        m2.setName("窗口2");

        m1.start();
        m2.start();
    }
}

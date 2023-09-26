package mythread.src.threadsafe02;

public class Test {
    public static void main(String[] args) {
        /*  一个电影院共有100张电影票，有三个窗口在售票，请实现这一功能*/

        //创建MyRunnable的对象
        //表示多线程要执行的任务
        MyRunnable mr=new MyRunnable();

        //创建线程对象
        Thread t1=new Thread(mr);
        Thread t2=new Thread(mr);
        Thread t3=new Thread(mr);

        //开启线程
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        //开启线程
        t1.start();
        t2.start();
        t3.start();
    }
}

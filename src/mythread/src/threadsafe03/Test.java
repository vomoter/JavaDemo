package mythread.src.threadsafe03;

public class Test {
    public static void main(String[] args) {
        /*  一个电影院共有100张电影票，有三个窗口在售票，请实现这一功能*/

        //创建线程对象
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        MyThread t3=new MyThread();

        //设置线程名字
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        //开启线程
        t1.start();
        t2.start();
        t3.start();
    }
}

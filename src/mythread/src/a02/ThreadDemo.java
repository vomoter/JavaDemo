package mythread.src.a02;

public class ThreadDemo {
    public static void main(String[] args) {
        /*
        *   多线程的第二种启类实现：
        *   1.自己定义一个类实现Runable接口
        *   2。重写里面的run方法
        *   3.创建自己的类的对象
        *   4.创建一个Thread类的对象，并开启线程
        * */

        //创建Myrun的对象
        //表示多线程要执行的任务
        Myrun m1=new Myrun();

        //创建线程对象
        Thread t1=new Thread(m1);
        Thread t2=new Thread(m1);

        //给线程设置名字"
        t1.setName("线程1");
        t2.setName("线程2");

        //开启线程
        t1.start();
        t2.start();
    }
}

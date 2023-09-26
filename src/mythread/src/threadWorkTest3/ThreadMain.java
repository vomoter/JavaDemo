package mythread.src.threadWorkTest3;

public class ThreadMain {
    public static void main(String[] args) {
        /*
        *   问题：同时开启两个线程，共同获取1-100之间的所有数字
        *   要求：将输出所有的奇数
        */

        //创建线程
        NumberThread n1=new NumberThread();
        NumberThread n2=new NumberThread();

        //设置线程名称
        n1.setName("张三");
        n2.setName("李四");

        //开启线程
        n1.start();
        n2.start();

    }
}

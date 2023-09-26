package mythread.src.a02;

public class Myrun implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <=100 ; i++) {
            //获取当前线程的对象
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName()+" HelloWorld!"+i);
        }
    }
}

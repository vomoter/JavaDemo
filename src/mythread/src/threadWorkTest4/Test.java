package mythread.src.threadWorkTest4;

public class Test {

    public static void main(String[] args) {
        /*
        *   抢红包多线程
        *   假设：100块，分成三个包，现在有五个人去抢
        *   其中：红包是共享数据
        *   打印结果如下：
        *   xxx抢到了xxx元
        *   xxx抢到了xxx元
        *   xxx抢到了xxx元
        *   xxx没有抢到
        *   xxx没有抢到
        * */

       RedPacketThread t1=new RedPacketThread();
       RedPacketThread t2=new RedPacketThread();
       RedPacketThread t3=new RedPacketThread();
       RedPacketThread t4=new RedPacketThread();
       RedPacketThread t5=new RedPacketThread();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


    }
}

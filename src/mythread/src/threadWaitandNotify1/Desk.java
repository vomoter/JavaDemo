package mythread.src.threadWaitandNotify1;

public class Desk  {
       /*
       *     作用： 控制生产消费者的执行
       */

        //是否有面条 0:没有  1:有
        public static int foodFlag=0;

        //总个数
        public static int count=10;

        //锁对象
        public static Object lock=new Object();
}

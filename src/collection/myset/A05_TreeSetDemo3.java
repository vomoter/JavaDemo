package collection.myset;

import java.util.Comparator;
import java.util.TreeSet;

public class A05_TreeSetDemo3 {
    public static void main(String[] args) {
        /*
        *      需求：请自行选择比较器和自然排序两种方式：
        *      要求：存入四个字符串："c","ab","df","qwe";
        *      按照长度排序，如果一样长按照首字母排序
        *
        *       采取第二种排序方式：比较器排序
        *
        */

        //1.创建集合
        //o1:表示当前要添加的元素
        //o2:表示已经存在红黑树的元素
        //返回值规则跟之前是一样的
        TreeSet<String> ts=new TreeSet<>((String o1, String o2)-> {
                //按照长度排序
                int i=o1.length()-o2.length();
                //如果一样长则按照首字母排序
                i=i==0?o1.compareTo(o2):i;
                return i;
            }
        );

        //2.添加元素
        ts.add("c");
        ts.add("ab");
        ts.add("dr");
        ts.add("qwe");

        //3.打印集合
        System.out.println(ts);
    }
}

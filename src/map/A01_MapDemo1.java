package map;

import java.util.*;
import java.util.function.Consumer;

public class A01_MapDemo1 {
    public static void main(String[] args) {
        //Map的第一种遍历方式(键找值)

        //1.创立Map集合的对象
        Map<String,Integer>map = new HashMap<>();

        //2.添加元素
        map.put("张三",19);
        map.put("李四",23);
        map.put("王五",20);

        //3。通过键找值

        //3.1获取所有的键，把这些键放到一个单列集合当中
        Set<String> keys=map.keySet();
        //3.2遍历单列集合，得到每一个键
        //  增强for循环
        System.out.println("增强for循环--------------");
        for (String key : keys){
            System.out.println(key);
            //3.3利用map集合中的键获取对应的值 get()
            int value= map.get(key);
            System.out.println(key+"="+value);
        }

        //迭代器遍历
        System.out.println("迭代器遍历------------------");
        Iterator<String> it =keys.iterator();
        while (it.hasNext()){
            String key = it.next();
            System.out.println(key);
            int value = map.get(key);
            System.out.println(key+"="+value);
        }

        //lambda表达式
        System.out.println("lambda表达式-------------------");
        keys.forEach(new Consumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println(str);
                int value = map.get(str);
                System.out.println(str+"="+value);
            }
        });

    }
}

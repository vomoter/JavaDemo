package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class A02_MapDemo2 {
    public static void main(String[] args) {
        //Map的第二种遍历方式,获取所有的键值对对象

        //1.创立Map集合的对象
        Map<String,String> map=new HashMap<>();

        //2.添加元素
        //键:人物的外号
        //值：人物的名字
        map.put("标枪选手","马超");
        map.put("人物挂件","明世隐");
        map.put("御龙骑士","尹世平");
        //3.通过键值对对象进行增强for遍历
        //3.1通过一个方法获取所有的键值对对象，返回一个Set集合
        System.out.println("增强for遍历---------------------");
        Set<Map.Entry<String, String>> entries = map.entrySet();

        //3.2 遍历entries集合，得到里面的每一个键值对对象
        for (Map.Entry<String, String> entry : entries) {
            //3.3利用entry调用get方法获取键和值
            String key=entry.getKey();
            String value=entry.getValue();
            System.out.println(key+"="+value);
        }

        //4.通过键值对对象进行迭代器遍历
        System.out.println("迭代器遍历-------------------------");
        Iterator<Map.Entry<String, String>> entryIterator = entries.iterator();
        while(entryIterator.hasNext()){
            Map.Entry<String, String> entry = entryIterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+"="+value);
        }

        //5.通过键值对对象进行Lambda表达式遍历
        System.out.println("Lambda表达式-------------------------");
        entries.forEach( stringStringEntry -> {
                String key = stringStringEntry.getKey();
                String value = stringStringEntry.getValue();
                System.out.println(key+"="+value);
            }
        );

    }
}

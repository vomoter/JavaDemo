package map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class A03_MapDemo3 {
    public static void main(String[] args) {
        //Map集合的第三种遍历方式：Lambda表达式

        //1.创立Map集合的对象
        Map<String,String> map=new HashMap<>();

        //2。添加元素
        //键：人物的名字
        //值：名人名言
        map.put("鲁迅","这句话是我说的");
        map.put("曹操","不可能绝对不可能");
        map.put("刘备","接着奏乐，接着舞");
        map.put("柯镇恶","看我眼色行事");

        //3.利用Lambda表达式进行遍历
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key+"="+value);
            }
        });

        System.out.println("----------------------");
        map.forEach((String key, String value) ->{
                System.out.println(key+"="+value);
            }
        );

        System.out.println("----------------------");
        map.forEach(( key, value) -> System.out.println(key+"="+value));

    }
}

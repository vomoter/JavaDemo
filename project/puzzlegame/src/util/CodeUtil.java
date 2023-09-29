package util;

import java.util.ArrayList;
import java.util.Random;

public class CodeUtil {
    public static String getCode()
    {
        StringBuilder stringBuilder=new StringBuilder();
        //1.创建一个集合
        ArrayList<Character> list=new ArrayList<>();
        //2.添加字母 a - z  A - Z
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i));//a - z
            list.add((char)('A' + i));//A - Z
        }
        //3.打印集合
        //System.out.println(list);
        //4.生成4个随机字母
        Random random=new Random();
        for (int i = 0; i < 4; i++) {
            int index= random.nextInt(52);
            stringBuilder.append(list.get(index));
        }
       // String str=stringBuilder.toString();
       // System.out.println(str);
        //5.在后面拼接数字 0~9
        int number=random.nextInt(10);
        stringBuilder.append(number);
        String st=stringBuilder.toString();
       // System.out.println(st);

        char charArray[]=st.toCharArray();
        int index =random.nextInt(charArray.length);
        char temp=charArray[index];
        charArray[index]=charArray[4];
        charArray[4]= temp;


        //6.把随机数字拼接到result的后面
        //7.把字符串变成字符数组
        String result=new String(charArray);
        return result;
    }


}

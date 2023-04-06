package collection.mygenerics;

import java.util.Arrays;

public class MyArryList<E> {

    Object[] obj=new Object[10];
    int size;
    /*
    * E:表示是不确定的类型，该类型在类名后面已经定义过了
    * e:形参的名字，变量名
    *
    * */
    public boolean add(E e){
        obj[size]=e;
        size++;
        return true;
    }

    public E get(int index){
        return (E)obj[index];   //进行强制转换为E类型的
    }

    @Override
    public String toString() {
        return Arrays.toString(obj);
    }

}

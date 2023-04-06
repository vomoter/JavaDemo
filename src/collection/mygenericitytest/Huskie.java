package collection.mygenericitytest;

public class Huskie extends Dog{
    public Huskie(){

    }
    public Huskie(String name,int age){
        super(name,age);
    }
    @Override
    public String eat(){
        return "一只叫做"+this.getName()+","+this.getAge()+"岁的哈士奇，边吃边拆家";

    }
}

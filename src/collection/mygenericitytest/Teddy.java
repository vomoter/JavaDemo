package collection.mygenericitytest;

public class Teddy extends Dog{
    public Teddy(){

    }

    public Teddy(String name, int age) {
        super(name, age);
    }

    @Override
    public String eat(){
        return "一只叫做"+this.getName()+","+this.getAge()+"岁的泰迪，边吃边蹭";

    }
}

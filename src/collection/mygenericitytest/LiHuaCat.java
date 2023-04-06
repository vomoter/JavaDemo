package collection.mygenericitytest;

public class LiHuaCat extends Cat{
   public LiHuaCat(){

   }
   public LiHuaCat(String name,int age){
       super(name,age);
   }


    @Override
    public String  eat(){
        return "一只叫做"+this.getName()+","+this.getAge()+"岁的狸花猫，正在吃鱼";

    }
}

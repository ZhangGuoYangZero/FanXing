package general;

public class general<T,A> extends Object {
    //我觉得一但实例化哪怕是走无参的也要指定这个类型
    protected      T  name;
    protected      A  age;


   /* //A T 是 类的泛型  C 是方法的泛型
    public <C> general(T name ,  A age, C test){
         this.name = name;
         this.age = age;
        System.out.println("泛型构造成功!! +" + test);
    }*/

    public general() {
    }

    public  <B> void  show(T namet, B agee){
     /*   System.out.println("------"+ namet);
        System.out.println("------"+ agee);
        System.out.println("------"+ name);
        System.out.println("------"+ age);*/

        if( agee instanceof Double)
            System.out.println("Double");
        else if (agee instanceof String)
            System.out.println("String");
        else
            System.out.println("nothing");
    }

}

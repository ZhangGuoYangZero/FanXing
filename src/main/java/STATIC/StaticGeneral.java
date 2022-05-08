package STATIC;

public class StaticGeneral<A> {

  /*泛型不能定义泛型静态属性
    这个泛型是随类创建的时候使用
    而静态是在类加载的时候就已经开始
    所以不在静态变量里面使用泛型
    public static  A  name;*/

    private  static String name;
    //这里再次证明了 方法不属于类

    public static  <T> int  TEST(T Tname){
        System.out.println("方法不属于类 + " + StaticGeneral.name);
        System.out.println( Tname.getClass());
        return   1;
    }
}

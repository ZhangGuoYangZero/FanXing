package extends_SUper;

import StringTestFather.StringTestFather;
import general.general;
import string.string;

public class ES {
    //类的泛型的上下界作用于类上面 -- 不能用
    public String name;

    //这里是StringTest类型的变量 做成员， 这种通配符方式的写法不能写在ES类上
    //本身st就是一个引用，所以需要在创建st所指向的实例化对象时候，指定这个泛型
    public StringTest<? extends StringTest> st;

    // public <?> name1; 类的泛型作用于 属性 不行
    //泛型通配符 是作用域类的区域的，所以要配合具体的类一起用
    //如果通配符拿到当作普通的泛型用，还不如直接用泛型
  /*  public <A> void test0(A name, general<?,?> general) {
        System.out.println(general.getClass());
        System.out.println("? 通配符测试成功!!");
    }*/

    //让general第一个参数变成 只有 Number 和 Numer的父类可以进入 也是就是object
    //让general第二个参数变成 只有 StringTest 和 StringTest 测试类写在测试文件中叫string类

    public <A> void test0(A name, general<? super StringTest, ? extends StringTest> general) {
        System.out.println(general.getClass());
        general.show(new string(),new string());
        System.out.println("? 通配符测试成功!!");
    }

}

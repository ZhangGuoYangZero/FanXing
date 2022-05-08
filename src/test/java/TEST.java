
import CollectTest.Person;
import CollectTest.PersonT;
import INTERFACE.FanxingInterface;
import STATIC.StaticGeneral;
import StringTestFather.StringTestFather;
import extends_SUper.ES;
import extends_SUper.StringTest;
import general.general;
import org.junit.jupiter.api.Test;
import ChaChu.ChaChu;
import string.string;
import CollectTest.IntegerFanxing;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class TEST {

    @Test
    public void test() {
        //生成一个泛型类的实例化对象
        //A T 是 类的泛型  C 是方法的泛型
        general<String, Integer> general =
                new general<String, Integer>();
        general.show("StringNamet", "嘿嘿 方法的泛型不用指定");
        System.out.println("---------1---1--------1-------");
    }

    @Test
    public void test1() {
        general<String, Integer> general =
                new general<String, Integer>();
        general.show("2", "21");

    }

    @Test
    public void test2() {
        // 不写默认OBJ StaticGeneral staticGeneral = new StaticGeneral();
        StaticGeneral staticGeneral = new StaticGeneral<String>();
        staticGeneral.TEST("2");
    }


    @Test
    public void test3() {
        //object型的类
        ChaChu chaChu = new ChaChu<Object>();
        //String
        ChaChu chaChu1 = new ChaChu<Object>();

        ChaChu chaChu2 = new ChaChu();

        ChaChu<String> chaChu3 = new ChaChu<String>();
        ChaChu<Integer> chaChu4 = new ChaChu<Integer>();

        // System.out.println( chaChu == chaChu1); false
        // 泛型擦除，无论所选的是那种类型，他们的字节码文件是一样的
        System.out.println(chaChu2.getClass() == chaChu1.getClass());

        System.out.println(chaChu.getClass() == chaChu3.getClass());

        System.out.println(chaChu4.getClass() == chaChu3.getClass());

    }

    @Test
    public void test4() {
        FanxingInterface<String> fanxingInterface = new FanxingInterface<>() {
            //跟普通类一样，一旦指定了泛型的类型，就会改变一切跟泛型有关的东西
            int a = 5;

            @Override
            public void TestInterface(String name) {
                System.out.println("--------泛型1");
            }

            @Override
            public <B> int TestInterface2(String name, B age) {
                System.out.println(name);
                System.out.println(age);
                // System.out.println(age + a); 泛型不能用于各种运算
                System.out.println(this.a);
                return 5;
            }
        };


        fanxingInterface.TestInterface("name");
        //这里还是父类引用 指向子类对象,由于是匿名类 也不能使用向下
        System.out.println(fanxingInterface.TestInterface2("name1", 5.5));
    }


    @Test
    public void test5() {
        ES es = new ES();
        //第一个参数被super修饰 当前和当前的父类可以
        //es.test0("0",new general<Number,Object>());
        //第二给参数被extends修饰，当前和当前的子类可以，子类写在了下面
        es.test0("0", new general<StringTestFather, string>());
        //这样就可以
        // es.st = new StringTest<StringTestFather>();
        //这样就不可以
        // es.st = new StringTest<string>();
        //如果不是拿到StringTest本身的话，可以直接用父类指针指向子类，不管那个东西
        es.st = new StringTest<string>();

        //设置了泛型的传递，stirng 也有一个泛型A， 这ES这个类中的ST成员的 变量格式
        //由于泛型是用 extends修饰的，在使用父类的引用指向子类的对象的时候，要NEW子类的对象符合父类的引用的泛型结构

        es.st = new string<string>();
        System.out.println(es.st.getClass());
    }

    @Test
    public void test6() {
        //用一个有排序功能的treeSet 去存储
        TreeSet<IntegerFanxing> treeSet = new TreeSet<>();
        treeSet.add(new IntegerFanxing(5));
        treeSet.add(new IntegerFanxing(2));
        treeSet.add(new IntegerFanxing(4));
        treeSet.add(new IntegerFanxing(1));
        treeSet.add(new IntegerFanxing(3));

        //获取一个 迭代器（interfx
        Iterator<IntegerFanxing> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            IntegerFanxing integerFanxing = iterator.next();
            System.out.println(integerFanxing.n);
        }


    }


  /*  @Test//这是给失败的测试，不要用 一切来源object的泛型数组
    public void test7() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        PersonT<Person> p = new PersonT<Person>() {
            private ArrayList<Person> name = super.name;
            private int total;

            {
                Class c = Class.forName("java.util.ArrayList");
                Field field = c.getField("elementData");
                field.setAccessible(true);
                Object[] object = (Object[])field.get(name);
                this.total = object.length;
            }

            //由于这是给匿名类 局部类拿不到父类的属性，所以强行重写


            //来一个自定义的内部类

            public Iterator<Person> Iterator() {
                //因为每次都要新的迭代器
                return new MyIterator();
            }

            //局部内部类(这个类是在test8里面的匿名类中出现的，无论怎么样都是局部类) 实现了iterator接口
            class MyIterator implements Iterator<Person> {
                private int index = 0;

                @Override
                public boolean hasNext() {
                    //这里不能用this 这个this会指向局部类
                    return index != total;
                }

                @Override
                public Person next() {
                    Person person = name.get(index);
                    index++;
                    return person;
                }
            }

        };
        for (int i = 0; i < 5; i++)
            p.name.add(new Person(i + 1));

        Iterator<Person> iterator = p.Iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().a);
        }


    }

*/
}






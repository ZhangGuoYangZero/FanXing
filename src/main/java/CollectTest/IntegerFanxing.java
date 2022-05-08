package CollectTest;

public class IntegerFanxing implements Comparable<IntegerFanxing>{
    //属性排序--给自己准备一些数字
    public  Integer n;

    public  IntegerFanxing(){
    }
    public  IntegerFanxing(Integer m ){
        n = m;
    }
    //只要继承了 compareable接口，并且实现了compareTo方法，
    // 在进入有HASH系列的集合中会自动调用对应的compareTo方法
    //默认自然排序就是从小到大 ，如果返回1就交换
    @Override
    public int compareTo(IntegerFanxing o) {
        int a  = this.n.compareTo(o.n);
        return  -a;
    }
}

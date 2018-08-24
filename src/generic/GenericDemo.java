package generic;


/**
 * Created by shichong on 2018/8/20.
 * 使用Generic泛型类和UnGeneric非泛型类
 */
public class GenericDemo {
    public static void main(String[] args) {
        //定义泛型类Gen的一个Integer版本
        Generic<Integer> intOb =new Generic<Integer>(88);
        intOb.showType();
        int i = intOb.getOb();
        System.out.println("value:"+ i);
        System.out.println("==========================================");
        //定义一个泛型类的String版本
        Generic<String> strOb =new Generic<String>("hello Gen!");
        strOb.showType();
        String s = strOb.getOb();
        System.out.println("value:"+s);
        System.out.println("==========================================");

        //定义一个UnGen的Integer版本
        UnGeneric intOb1 =new UnGeneric(new Integer(88));
        intOb.showType();
        int i1 = (Integer) intOb1.getOb();
        System.out.println("value:" +i1);
        System.out.println("==========================================");
        //定义一个UnGen的String版本
        UnGeneric strOb1 = new UnGeneric("hello UnGen");
        strOb.showType();
        String s1 =(String)strOb1.getOb();
        System.out.println("value:"+s1);
    }
}

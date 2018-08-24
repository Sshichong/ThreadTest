package generic;

/**
 * Created by shichong on 2018/8/20.
 * 泛型方法
 */
public class GenericMethod {
    public <T> void f(T x){
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethod gm=new GenericMethod();
        gm.f(" ");
        gm.f(10);
        gm.f('a');
        gm.f(gm);
    }
}

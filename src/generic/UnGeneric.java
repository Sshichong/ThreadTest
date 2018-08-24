package generic;

/**
 * Created by shichong on 2018/8/20.
 * 不使用泛型
 */
public class UnGeneric {
    private Object ob;//定义一个通用类型成员

    public UnGeneric(Object ob) {
        this.ob = ob;
    }

    public Object getOb() {
        return ob;
    }

    public void setOb(Object ob) {
        this.ob = ob;
    }

    public void showType(){
        System.out.println("T的实际类型是："+ob.getClass().getName());
    }
}

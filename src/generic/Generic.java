package generic;

/**
 * Created by shichong on 2018/8/20.
 * 使用泛型
 */
public class Generic<T> {
    private T ob;//定义泛型成员变量

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }

    public Generic(T ob) {
        this.ob = ob;
    }

    public  void showType(){
        System.out.println("T的实际类型是："+ob.getClass().getName());
    }
}

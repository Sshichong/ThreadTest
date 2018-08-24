package generic;

import java.util.Collection;

/**
 * Created by shichong on 2018/8/20.
 * 限制泛型
 * 为了解决类型被限制死了不能动态根据实例来确定的缺点，引入了“通配符泛型”，针对上面的例子，使用通配泛型格式为<? extends Collection>
 * 1.只指定<?> 而没有extends，则默认是允许Object及其下的任何java类，也就是任意类
 * 2.通配符泛型不单可以向下限制，如<? extends Collection> 还可以向上限制，如<? super Double> 表示类型只能接受Double及其上层父类类型，如Number，Object类型的实例
 * 3.泛型类定义可以有多个泛型参数，中间用逗号隔开，还可以定义泛型接口，泛型方法，这些都与泛型类中的泛型的使用规则类似
 */
public class CollectionGeneric<T extends Collection> {
    private T x;

    public CollectionGeneric(T x) {
        this.x = x;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }
}

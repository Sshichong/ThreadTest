package generic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by shichong on 2018/8/20.
 *
 */
public class CollectionGenericDemo {
    public static void main(String[] args) {
        CollectionGeneric<ArrayList> listTest =null;
//        listTest =new CollectionGeneric<ArrayList>(new ArrayList());
        listTest =new CollectionGeneric<ArrayList>(new ArrayList(Arrays.asList("Buenos Aires", "Córdoba", "La Plata")));
        System.out.println(listTest.getX());
        System.out.println("实例化成功");
    }
}

package setDemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by shichong on 2018/8/7.
 * HashSet
 */
public class hashSet {
    public static void main(String[] args) {
        //Set 集合存和取的顺序不一致
        Set hs =new HashSet();
        hs.add("世界军事");
        hs.add("兵器知识");
        hs.add("舰船知识");
        hs.add("汉和防务");
        //返回此set中的元素数量
        System.out.println("first:"+hs.size());

        //如果此set尚未包含指定元素，则返回true
        boolean add = hs.add("世界军事");//false
        System.out.println(add);

        //再次返回set中数量
        System.out.println("second:"+hs.size());

        //打印set集合
        System.out.println(hs);
        //[世界军事, 汉和防务, 兵器知识, 舰船知识]

        Iterator it = hs.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("==========================================================================================");

        HashSet hs1 = new HashSet();
        hs1.add(new Person("jack",20));
        hs1.add(new Person("rose",20));
        hs1.add(new Person("hmm",20));
        hs1.add(new Person("jack",20));
        hs1.add(new Person("lilei",20));

        Iterator it1= hs1.iterator();
        while (it1.hasNext()){
            Object next = it1.next();
            System.out.println(next);
        }

    }


}

/**
 * 人的类
 */
class Person{
    private String name;
    private Integer age;

    Person(){}

    public  Person(String name,Integer age){
        this.name =name;
        this.age =age;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name =name;
    }
    public Integer getAge(){
        return age;
    }
    public void setAge(Integer age){
        this.age =age;
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode:"+this.name);
        return this.name.hashCode()+age * 37;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println(this +"---equals---" +obj);
        if (obj instanceof Person){
            Person p =(Person)obj;
            return this.name.equals(p.name)&& this.age ==p.age;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Person@name:"+this.name + "age:" +this.age;
    }
}

package setDemo;


import java.util.Comparator;

/**
 * Created by shichong on 2018/8/7.
 */
public class TreeSet {
    public static void main(String[] args) {
        java.util.TreeSet ts =new java.util.TreeSet();

        ts.add("ccc");
        ts.add("aaa");
        ts.add("ddd");
        ts.add("bbb");

        System.out.println(ts);
        System.out.println("============================================================================================");

        /**
         * 一，让元素自身具备比较性。
         * 也就是元素需要实现Comparable接口，覆盖compareTo 方法。
         * 这种方式也作为元素的自然排序，也可称为默认排序。
         * 年龄按照搜要条件，年龄相同再比姓名。
         */
        java.util.TreeSet ts1 =new java.util.TreeSet();
        ts1.add(new People("aa", 20, "男"));
        ts1.add(new People("bb", 18, "女")); //开始比较
        ts1.add(new People("cc", 17, "男"));
        ts1.add(new People("dd", 17, "女"));
        ts1.add(new People("dd", 15, "女"));
        ts1.add(new People("dd", 15, "女"));

        System.out.println(ts1);
        System.out.println("============================================================================================");
        System.out.println(ts1.size());
        System.out.println("============================================================================================");

        /**
         * 二，让容器自身具备比较性，自定义比较器。
         * 需求：当元素自身不具备比较性，或者元素自身具备的比较性不是所需的。
         * 那么这时只能让容器自身具备。
         * 定义一个类实现Comparator 接口，覆盖compare方法。
         * 并将该接口的子类对象作为参数传递给TreeSet集合的构造函数。
         * 当Comparable比较方式，及Comparator比较方式同时存在，以Comparator
         * 比较方式为主。
         */
        java.util.TreeSet ts2 =new java.util.TreeSet(new MyComparator());
        ts2.add(new Book("think in java", 100));
        ts2.add(new Book("java 核心技术", 75));
        ts2.add(new Book("现代操作系统", 50));
        ts2.add(new Book("java就业教程", 35));
        ts2.add(new Book("think in java", 100));
        ts2.add(new Book("ccc in java", 100));
        System.out.println(ts2);
    }
}

/**
 * 让元素自身具备比较性。实现Comparable接口，覆盖conpareTo方法
 */
class People implements Comparable{
    private String name;
    private Integer age;
    private String gennder;

    public People(){}

    public People(String name,Integer age,String gennder){
        this.name =name;
        this.age =age;
        this.gennder =gennder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGennder() {
        return gennder;
    }

    public void setGennder(String gennder) {
        this.gennder = gennder;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gennder='" + gennder + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return name.hashCode() +age*37;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println(this + "equals:"+obj);
        if (!(obj instanceof People)){
            return false;
        }
        People p =(People)obj;
        return this.name.equals(p.name)&&this.age ==p.age;
    }

    @Override
    public int compareTo(Object o) {
       People p =(People)o;
        System.out.println(this +"compareTo:"+p);
        if (this.age>p.age){
            return 1;
        }
        if (this.age<p.age){
            return -1;
        }
        return this.name.compareTo(p.name);
    }
}

/**
 * 自定义比较器，实现Comarator接口
 */
class MyComparator implements Comparator{
    public int compare(Object o1,Object o2){
        Book b1 = (Book)o1;
        Book b2 =(Book) o2;
        System.out.println(b1+" comparator "+ b2);
        if (b1.getPrice()>b2.getPrice()){
            return 1;
        }
        if (b1.getPrice()<b2.getPrice()){
            return -1;
        }
        return b1.getName().compareTo(b2.getName());
    }
}

class Book{
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
/*
---| Itreable      接口 实现该接口可以使用增强for循环
				---| Collection		描述所有集合共性的接口
					---| List接口	    有序，可以重复，有角标的集合
                            ---| ArrayList
                            ---|  LinkedList
					---| Set接口	    无序，不可以重复的集合
                            ---| HashSet  线程不安全，存取速度快。底层是以hash表实现的。
                            ---| TreeSet  红-黑树的数据结构，默认对元素进行自然排序（String）。如果在比较的时候两个对象返回值为0，那么元素重复。


----| Comparable
       		compareTo(Object o)     元素自身具备比较性
----| Comparator
       		compare( Object o1, Object o2 )	给容器传入比较器


 */



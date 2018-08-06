package listToMap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by shichong on 2018/8/3.
 * filter 过滤
 */
public class filterTest {
    /**
     * 准备学生列表数据
     * @return
     */
    public static List<Student> prepareData(){
        List<Student> studentList =new ArrayList<>();
        for (int i=0;i<11;i++){
            studentList.add(new Student(i+1,"小明"+(i+1),11,"男"));
        }
        return studentList;
    }

    public static List<Student> preparStudents(){
        List<Student> studentList = Arrays.asList(new Student(1,"小明",11,"男"),
                new Student(2,"小红",12,"女"),
                new Student(3,"小蓝",12,"男"),
                new Student(4,"小粉",14,"女"),
                new Student(5,"小锅",15,"男"),
                new Student(1,"小明",11,"男"));
        return studentList;

    }

    public static void main(String[] args) {

        System.out.println("/*==========================================================================================================*/");
        List<Student> studentList =prepareData();

        /**
         * 要被找出的学生的id
         */
        List<Integer> ids =new ArrayList<>();
        ids.add(3);
        ids.add(6);
        ids.add(8);
        ids.add(9);

        //存放过滤的结果列表
        List<Student> result =null;

        //使用lambda表达式过滤出结果放到result里
        result = studentList.stream()
                .filter((Student s)->ids.contains(s.getId()))
                .collect(Collectors.toList());

        //打印结果列表
        if (result!=null&&!result.isEmpty()){
            result.forEach((Student s1)-> System.out.println("学生姓名："+s1.getName()+" "));
        }else {
            System.out.println(" IS NULL");
        }


        /*==========================================================================================================*/
        System.out.println("\n");
        System.out.println("==========================================================================================================");
        System.out.println("\n");

        List<String> str = Arrays.asList("1","2","3","4");
        List<String> str1 =Arrays.asList("21","22","23","24");

        /**
         * Collection类stream()+filter()+forEach()方法的联合使用
         * filter的多重过滤和foreach联用
         */
        str.stream().filter(stra->{
            return "2".equals(stra)?true:false;
        }).forEach(stra->{
            System.out.println(stra);
        });

        str1.stream().filter(strb->{
            return strb.startsWith("2");
        }).filter(strb->{
            return strb.startsWith("22");
        }).forEach(strb->{
            System.out.println(strb);
        });


        System.out.println("==========================================================================================================");
        /**
         * 分组
         */
        List<Student> studentList1 =preparStudents();

        //list以sex分组，Map<String,List<Student>>
        Map<String,List<Student>> groupBy = studentList1.stream().collect(Collectors.groupingBy(Student::getSex));

        System.out.println("groupBy:"+groupBy);
        System.out.println("==========================================================================================================");
        /**
         *filter 过滤
         */
        List<Student> filterList = studentList1.stream().filter(a->a.getName().equals("小明")).collect(Collectors.toList());
        System.out.println("filterlist:"+filterList);
        System.out.println("==========================================================================================================");

        /**
         * limit，截取前面几个
         */
        List<Student> limitList =studentList1.stream().limit(3).collect(Collectors.toList());
        limitList.forEach((Student s2)->{
            System.out.println("limitlist:"+s2.toString());
        });

        System.out.println("==========================================================================================================");
        /**
         * skip,跳过前面几个
         */
        List<Student> skiplist = studentList1.stream().skip(2).collect(Collectors.toList());
        skiplist.forEach((Student s3)->{
            System.out.println("skiplist:"+s3.toString());
        });

        System.out.println("==========================================================================================================");
        /**
         * 转换为大写字母
         */
        List<String> toUp = Arrays.asList("a","b","hello");
        List<String> toUplist =toUp.stream().map(item->item.toUpperCase()).collect(Collectors.toList());
        toUplist.forEach((String s)->{
            System.out.println("toUplist:"+s);
        });

        Stream.of("a", "b", "hello")
                .map(item1-> item1.toUpperCase())
                .forEach(System.out::println);
        System.out.println("==========================================================================================================");
        /**
         * distinct 去重
         */
        List<Integer> distinct =Arrays.asList(1,2,3,1,2,5);
        List<Integer> distinctList = distinct.stream().distinct().collect(Collectors.toList());
        distinctList.forEach((Integer i)-> System.out.println("distinctList:"+i));
        System.out.println("==========================================================================================================");
        /**
         * reduce
         *reduce 操作可以实现从Stream中生成一个值
         */
        List<Integer> a =Arrays.asList(1,2,3,4,5,6);
        Integer b =a.stream().reduce(0,(acc,item)->{
            acc+=item;
           return acc;
        });
        System.out.println("total:"+b);

        System.out.println("==========================================================================================================");
        /**
         * sorted
         * 排序
         */
        List<Integer> sorted =Arrays.asList(3,2,1);
        List<Integer> sortedList =sorted.stream().sorted().collect(Collectors.toList());
        System.out.println("排序："+sortedList.toString());

        System.out.println("==========================================================================================================");
        /**
         * count()
         * 返回list长度
         */
        List<Integer> countList =Arrays.asList(3,2,1);
        long count =countList.stream().count();
        System.out.println("List长度:"+count);

        System.out.println("==========================================================================================================");
        /**
         * allMatch
         * 全都匹配的返回true，否则返回false
         */
        List<Integer> allMatchList =Arrays.asList(1,2,3,4,5);
        boolean am =allMatchList.stream().allMatch(integer -> integer>0);
        System.out.println("allMatch:" +am);

        boolean allMatch =Stream.of(1,2,3,4,5)
                .allMatch(integer -> integer>0);
        System.out.println("allMatch:"+allMatch);

        System.out.println("==========================================================================================================");
        /**
         * anyMatch
         * 有匹配的返回true，无则false
         */

        boolean anyMatch =Stream.of(1,2,3,4,5)
                .anyMatch(integer -> integer>3);
        System.out.println("anyMatch:"+anyMatch);

        System.out.println("==========================================================================================================");
        /**
         * findAny
         * findAny操作用于获取含有Stream中的某个元素的Optional，如果Stream为空，则返回一个空的Optional
         */

        Optional<Integer> findAny = Stream.of(1, 2, 3, 4).findAny();
        System.out.println("findAny:"+findAny);
        System.out.println("==========================================================================================================");
        /**
         * findFirst()
         * findFirst操作用于获取含有Stream中的第一个元素的Optional，如果Stream为空，则返回一个空的Optional。若Stream并未排序，可能返回含有Stream中任意元素的Optional。
         */
        Optional<Integer> findFirst = Stream.of(1, 2, 3, 4).findFirst();
        System.out.println("findFirst:"+findFirst);

        System.out.println("==========================================================================================================");
        /**
         * noneMatch
         * noneMatch方法将判断Stream中的所有元素是否满足指定的条件，如果所有元素都不满足条件，返回true；否则，返回false.
         */
        boolean noneMatch = Stream.of(1, 2, 3, 4, 5)
                .noneMatch(integer -> integer > 10);
        System.out.println("noneMatch:" + noneMatch); // 打印结果 noneMatch:true

        boolean noneMatch_ = Stream.of(1, 2, 3, 4, 5)
                .noneMatch(integer -> integer < 3);
        System.out.println("noneMatch_:" + noneMatch_); // 打印结果 noneMatch_:false
    }
}
/*
学生姓名：小明3
        学生姓名：小明6
        学生姓名：小明8
        学生姓名：小明9


        ==========================================================================================================


        2
        22
        ==========================================================================================================
        groupBy:{女=[Student{id=2, name='小红', age=12, sex='女'}, Student{id=4, name='小粉', age=14, sex='女'}], 男=[Student{id=1, name='小明', age=11, sex='男'}, Student{id=3, name='小蓝', age=12, sex='男'}, Student{id=5, name='小锅', age=15, sex='男'}, Student{id=1, name='小明', age=11, sex='男'}]}
        ==========================================================================================================
        filterlist:[Student{id=1, name='小明', age=11, sex='男'}, Student{id=1, name='小明', age=11, sex='男'}]
        ==========================================================================================================
        limitlist:Student{id=1, name='小明', age=11, sex='男'}
        limitlist:Student{id=2, name='小红', age=12, sex='女'}
        limitlist:Student{id=3, name='小蓝', age=12, sex='男'}
        ==========================================================================================================
        skiplist:Student{id=3, name='小蓝', age=12, sex='男'}
        skiplist:Student{id=4, name='小粉', age=14, sex='女'}
        skiplist:Student{id=5, name='小锅', age=15, sex='男'}
        skiplist:Student{id=1, name='小明', age=11, sex='男'}
        ==========================================================================================================
        toUplist:A
        toUplist:B
        toUplist:HELLO
        A
        B
        HELLO
        ==========================================================================================================
        distinctList:1
        distinctList:2
        distinctList:3
        distinctList:5
        ==========================================================================================================
        total:21
        ==========================================================================================================
        排序：[1, 2, 3]
        ==========================================================================================================
        List长度:3
        ==========================================================================================================
        allMatch:true
        allMatch:true
        ==========================================================================================================
        anyMatch:true
        ==========================================================================================================
        findAny:Optional[1]
        ==========================================================================================================
        findFirst:Optional[1]
        ==========================================================================================================
        noneMatch:true
        noneMatch_:false
 */
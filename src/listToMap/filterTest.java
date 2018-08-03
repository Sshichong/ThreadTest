package listToMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static void main(String[] args) {
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
        System.out.println("/*==========================================================================================================*/");
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

    }
}
/*
学生姓名：小明3
学生姓名：小明6
学生姓名：小明8
学生姓名：小明9


2
22
 */
package listToMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by shichong on 2018/7/27.
 * list转化为map
 */
public class listToMapTest {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(new Student(1,"小明",11,"男"),
                new Student(2,"小hong",11,"男"),
                new Student(3,"小lv",11,"男"),
                new Student(4,"小lan",11,"男"));

        //value 对象为student -> student jdk1.8返回当前对象
        Map<Integer,Student> map =list.stream().collect(Collectors.toMap(Student::getId,student -> student));
        //遍历打印结果
        map.forEach((key,value)->{
            System.out.println("key:"+key+",value:"+value);
        });
        System.out.println("=================================================================================");
        Map<Integer,String> map1 =list.stream().collect(Collectors.toMap(Student::getId,Student::getName));
        map1.forEach((key,value)->{
            System.out.println("key:"+key+",value:"+value);
        });

    }

}

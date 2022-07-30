package 课堂练习.Day8;

import java.util.*;
import java.util.stream.Collectors;

public class Day8 {
    public static void main(String[] args) {
        /*
        集合类   类型申明: List<String> list1 = new ArrayList<>()
                        LinkedList<String> list2 = new LinkedList<>()
                        Set<String> set1 = new HashSet<>()
                        TreeSet<String> set2 = new TreeSet<>()
                        Map<key, value> map1 = new HashMap<>()
                        LinkedHashMap<key, value> map2 = new LinkedHashMap<>()
        List
            申明: List<Integer> list = new ArrayList<>()
                 Integer[] arr = new Integer[10]
            赋值: list.add(value)  存最末尾
                 list.add(index, value)  存指定位置
                 arr[index] = value
            取值: list.get(index)
                 arr[index]
            判断是否包含: list.contains(value)
                 arr：for循环判断
        Set
            赋值: set.add()
            判断是否包含:set.contains()

        Map
            赋值: map.put(key1, value1)
                 map.put(key1, value2)  这会覆盖之前赋的值
            取值: map.get(key)
            判断是否包含: map.containsKey(key)
        */

        Map<String, Integer> map = new HashMap<>();
        map.put("zhangsan", 123);
        System.out.println(map.get("zhangsan"));



        //Stream
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Random().nextInt(10));
        }
        //遍历
        list.stream().forEach(o -> System.out.print(o+" ")); //跟for循环一样
        System.out.println();
        //排序
        list.stream().sorted().forEach(o -> System.out.print(o+" "));
        System.out.println();
        list.stream().sorted((o1,o2) -> o2-o1).filter(o -> o>1).forEach(o -> System.out.print(o+" "));
        System.out.println();
        //类型转换
        Set<Integer> set = new HashSet<>();
        set = list.stream().collect(Collectors.toSet());
        System.out.print("list转为set：");
        set.stream().forEach(o -> System.out.print(o + " "));
        System.out.println();

        List<Integer> list1 = set.stream().map(o -> o+1).collect(Collectors.toList());
        System.out.print("set转为list：");
        list1.stream().forEach(o -> System.out.print(o+" "));
        System.out.println();


        //异常处理
        double a = 10.0;
        try{
            a = 1 / 0;
        } catch (ArithmeticException e){
            System.out.print("error ");
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            System.out.println("finally");
        }
        //System.out.println(2.0/0);  输出为Infinity
        //System.out.println(2/0);    异常
    }
}


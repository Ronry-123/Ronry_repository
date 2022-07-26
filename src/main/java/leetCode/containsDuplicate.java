// 判断是否存在重复元素
package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class containsDuplicate {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        Set<Integer> set = list.stream().collect(Collectors.toSet());
        boolean bool = sameElement(list.size(), set.size());
        System.out.println(bool);
    }
    public static boolean sameElement(int a, int b){
        if(a==b){
            return true;
        }else {
            return false;
        }
    }
}

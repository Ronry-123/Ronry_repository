// 找出两数之和与所给数字相同的下标
// 时间复杂度为O(n*n)
package leetCode;

import java.util.HashSet;
import java.util.Set;

public class twoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4,5};
        Set<Integer> set = new HashSet<>();
        int target = 6;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++){
                if (nums[i] == nums[j]){
                    continue;
                }else if(nums[i] + nums[j] == target){
                    set.add(i);
                    set.add(j);
                }
            }
        }
        System.out.print("下标为：");
        set.stream().forEach(o -> System.out.print(o+"  "));
    }
}

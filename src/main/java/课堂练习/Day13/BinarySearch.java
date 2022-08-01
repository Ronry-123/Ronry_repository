package 课堂练习.Day13;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{-1,0,3,5,9,12};
        int target1 = 8;
        int target2 = 9;
        System.out.println("目标数为：" + target1 + ", 结果为：" + search(array, target1));
        System.out.println("目标数为：" + target2 + ", 结果为：" + search(array, target2));
    }

    //二分法查找
    public static int search(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = (left + right) / 2;
            int num = arr[mid];
            if (num == target){
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

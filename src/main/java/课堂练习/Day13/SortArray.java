package 课堂练习.Day13;

public class SortArray {
    public static void main(String[] args) {
        int[] array = new int[]{1,8,5,3,9,4,6,7,0};
        sort(array);
        for(int i : array){
            System.out.print(i+" ");
        }
    }
    // 冒泡排序
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int temp;
            for(int j = 0; j < arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

package dayWork;

public class Example8_12 {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55, 66};
        show(arr);
        exchange(1,5,arr);
        show(arr);
    }
    public static void show(int[] arr){
        System.out.print("[");
        for (int i=0; i<arr.length; i++){
            System.out.print(i==arr.length-1? arr[i] : arr[i]+",");
        }
        System.out.print("]\n");
    }
    public static void exchange(int a, int b, int[] arr){
        int temp = 0;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

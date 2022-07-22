public class Example8_11 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        show(arr);
    }
    public static void show(int arr []){
        System.out.print("[");
        for(int i = 0; i < arr.length;i++){
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + "," );
        }
        System.out.println("]");
    }
}

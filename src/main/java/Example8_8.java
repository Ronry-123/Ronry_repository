import java.util.Scanner;

public class Example8_8 {
    public static void main(String[] args) {
        int[] array = { 19, 28, 37, 46, 50 };
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数据：");
        int number = sc.nextInt();
        int index = getIn(number, array);
        System.out.println(index);
    }
    public static int getIn(int n, int[] arr){
        int index = -1;
        for (int i=0; i<arr.length; i++){
            if (n==arr[i]){
                index = i;
            }
        }
        return index;
    }
}

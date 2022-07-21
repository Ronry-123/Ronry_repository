public class Example5_7 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i=1;i<6;i++){
            if (i==4){
                break;
            }
            sum += i;
        }
        System.out.println("前三个数的和为："+sum);
    }
}

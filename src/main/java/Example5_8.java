public class Example5_8 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i=1; i<6; i++){
            if (i == 4){
                continue;
            }
            sum += i;
        }
        System.out.println("和为:"+sum);
    }
}

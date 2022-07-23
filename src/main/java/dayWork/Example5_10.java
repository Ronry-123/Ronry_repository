package dayWork;

public class Example5_10 {
    public static void main(String[] args) {
        short sum = 0;
        byte i =1;
        do{
            sum += i;
            i++;
        }while(i<11);
        System.out.println("1~10的和为："+sum);
    }
}

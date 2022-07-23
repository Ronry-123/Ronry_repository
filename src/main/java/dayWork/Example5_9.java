package dayWork;

public class Example5_9 {
    public static void main(String[] args) {
        short sum = 0;
        byte i = 1;
        while(i<11){
            sum += i;
            i++;
        }
        System.out.println("1~10的和为："+sum);
    }
}

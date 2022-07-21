import java.sql.SQLOutput;
import java.util.Scanner;

public class Example4_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个0到6的数字：");
        int n = sc.nextInt();
        switch (n){
            case 0:
                System.out.println("Today is Sunday!");
                break;
            case 1:
                System.out.println("Today is Monday!");
                break;
            case 2:
                System.out.println("Today is Tuesday!");
                break;
            case 3:
                System.out.println("Today is Wednesday!");
                break;
            case 4:
                System.out.println("Today is Thursday!");
                break;
            case 5:
                System.out.println("Today is Friday!");
                break;
            case 6:
                System.out.println("Today is Saturday!");
                break;
            default:
                System.out.println("You must be wrong!");
        }
    }
}

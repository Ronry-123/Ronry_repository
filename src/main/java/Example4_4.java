import java.util.Scanner;

public class Example4_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入月份：");
        int month = sc.nextInt();
        switch (month){
            case 3:
            case 4:
            case 5:
                System.out.println("Spring!");
                break;
            case 6 :
            case 7 :
            case 8 :
                System.out.println("Summer!");
                break;
            case 9 :
            case 10 :
            case 11 :
                System.out.println("Fall!");
                break;
            case 12 :
            case 1 :
            case 2 :
                System.out.println("Winter!");
                break;
            default:
                System.out.println("You must be wrong!");
        }
    }
}

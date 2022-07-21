import java.util.Scanner;

public class Example4_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入星期(0-6, 如周三为3): ");
        int day = sc.nextInt();
        switch (day){
            case 1:
                System.out.println("跑步");
                break;
            case 2:
                System.out.println("游泳");
                break;
            case 3:
                System.out.println("慢走");
                break;
            case 4:
                System.out.println("骑自行车");
                break;
            case 5:
                System.out.println("爬山");
                break;
            case 6:
                System.out.println("拳击");
                break;
            case 0:
                System.out.println("休息");
                break;
            default :
                System.out.println("请按格式输入星期数，如周一为1");
        }
    }

}

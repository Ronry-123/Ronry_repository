package dayWork;

import java.util.Scanner;

public class Example2_3 {
    public static void main(String[] args) {
        System.out.println("以下是计算圆柱体体积的实例：");
        final double pi = 3.14; //设置pi常量
        //创建一个键盘输入扫描类的对象
        Scanner sc = new Scanner(System.in);
        //输入圆柱体的半径
        System.out.println("请输入圆柱体的底面半径：");
        double r = sc.nextDouble();
        //输入圆柱体的高
        System.out.println("请输入圆柱体的高：");
        double h = sc.nextDouble();
        //计算圆柱体底面面积
        double s = pi*r*r;
        System.out.println("圆柱体的地面面积为：" + s);
        //计算圆柱体体积
        double v = s*h;
        System.out.println("圆柱体的体积为：" + v);
    }
}

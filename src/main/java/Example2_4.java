import java.util.Scanner;

public class Example2_4 {
    public static void main(String[] args){
        System.out.println("以下是预测儿子和女儿的身高实例：");
        Scanner sc = new Scanner(System.in);
        //获取父亲与母亲的身高
        System.out.println("请输入父亲身高：");
        double fatherHeight = sc.nextDouble();
        System.out.println("请输入母亲身高：");
        double motherHeight = sc.nextDouble();
        //计算儿子与女儿的身高
        double son = (fatherHeight+motherHeight)*1.08/2;
        double daughter = (fatherHeight*0.923+motherHeight)/2;
        System.out.println("儿子身高"+son+"cm");
        System.out.println("女儿身高"+daughter+"cm");
    }
}

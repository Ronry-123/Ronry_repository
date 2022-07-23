package dayWork;

public class Example8_2 {
    public static void main(String[] args) {
        double x1 = getNum(-1.56);
        System.out.println("绝对值为:"+x1);
        double x2 = getNum(2.34);
        System.out.println("绝对值为:"+x2);
    }
    public static double getNum(double num){
        double x;
        if(num < 0){
            x = -num;
        }else{
            x = num;
        }
        return x;
    }

}

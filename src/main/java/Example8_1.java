public class Example8_1 {
    public static void main(String[] args) {
        int max = getMax(2,3,5);
        System.out.println("最大值为："+max);
    }
    public static int getMax(int a, int b, int c){
        int d;
        if (a>b){
            d = a;
        }else{
            d = b;
        }
        if (d < c){
            d = c;
        }
        return d;
    }
}

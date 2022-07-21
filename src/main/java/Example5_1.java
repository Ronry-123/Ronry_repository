public class Example5_1 {
    public static void main(String[] args){
        for (short i=2019; i>=1949; i--){
            if ((2019-i)%12 == 0){
                System.out.println(i+"年是猪年");
            }
        }
    }
}

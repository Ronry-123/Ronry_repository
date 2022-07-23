package dayWork;

public class Example5_2 {
    public static void main(String[] args){
        for (int i=2000; i<=2019; i++){
            if(i%4==0 && i%100!=0 || i%400==0){
                System.out.println(i+"年是闰年!");
            }
        }
    }
}

public class Example5_4 {
    public static void main(String[] args) {
        System.out.println("水仙花数：");
        for (int i = 100; i <= 999; i++ ){
            int i1 = i / 100;
            int i2 = i / 10 % 10;
            int i3 = i % 10;
            int s = i1*i1*i1 + i2*i2*i2 + i3*i3*i3;
            if (i == s){
                System.out.print(s+"  ");
            }
        }
    }
}

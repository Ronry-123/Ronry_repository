public class Example8_5 {
    public static void main(String[] args) {
        getChicken();
    }
    public static void getChicken(){
        for (int i=0; i<21; i++){
            for (int j=0; j<34; j++){
                int k = 100-i-j;
                if(i * 5 + j * 3 + k /3 == 100){
                    System.out.println("鸡翁：" + i + "鸡母：" + j + "鸡雏" + k);
                }
            }
        }
    }
}

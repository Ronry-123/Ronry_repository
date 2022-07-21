public class Example4_1 {
    public static void main(String[] args) {
        int newPhone = 7988;
        int oldPhone = 1500;
        int price1 = newPhone - oldPhone;
        float price2 = newPhone*0.8f;
        if (price1 < price2){
            System.out.println("不使用以旧换新更省钱，费用为："+price1);
        }else {
            System.out.println("使用以旧换新更省钱，费用为："+price2);
        }
    }
}

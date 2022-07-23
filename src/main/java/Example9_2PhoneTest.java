public class Example9_2PhoneTest {
    public static void main(String[] args) {
        Example9_2Phone phone = new Example9_2Phone();
        phone.brand = "xiaoMi";
        phone.color = "pink";
        phone.price = 4299;
        phone.call();
        phone.sendMessage();
    }
}

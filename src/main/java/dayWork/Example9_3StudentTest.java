package dayWork;

public class Example9_3StudentTest {
    public static void main(String[] args) {
        Example9_3Student student1 = new Example9_3Student();
        student1.setName("张三");
        student1.setAge(18);
        student1.show();
        Example9_3Student student2 = new Example9_3Student("王五",20);
        student2.show();
    }
}

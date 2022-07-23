package dayWork;

public class Example9_3Student {
    private String name;
    private int age;
    public Example9_3Student(){
    }
    public Example9_3Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void show(){
        System.out.println("学生姓名为："+this.name+"\n学生年龄为："+this.age);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

public class Example8_13 {
    public static void main(String[] args) {
        byte a = 2;
        short b = 3;
        int c = 4;
        long d = 5L;
        type(d);
        type(c);
        type(b);
        type(a);
    }
    public static void type(byte n){
        System.out.println("This is byte!");
    }
    public static void type(short n){
        System.out.println("This is short!");
    }
    public static void type(int n){
        System.out.println("This is int!");
    }
    public static void type(long n){
        System.out.println("This is long!");
    }
}

public class Example8_3 {
    public static void main(String[] args) {
        getSeven();
    }
    public static void getSeven(){
        for (int i=1; i<20; i++){
            String j = String.valueOf(i);
            boolean bool = j.contains("7");
            if (i%7==0 || bool){
                System.out.println(i+"过！");
            }
        }
    }
}

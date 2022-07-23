package dayWork;

public class Example8_9 {
    public static void main(String[] args) {
        exchange();
    }
    public static void exchange(){
        int[] arr = {19, 28, 37, 46, 50};
        int n = arr.length;
        int[] arrNew = new int[n];
        for (int i=n-1; i>-1; i--){
            arrNew[n-1-i] = arr[i];
        }
        for (int i=0; i<n; i++){
            System.out.print(arrNew[i]+" ");
        }
    }
}

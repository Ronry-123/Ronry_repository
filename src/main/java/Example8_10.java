import java.util.Random;

public class Example8_10 {
    public static void main(String[] args) {
        int[] arr = new int[6];
        getGrades(arr);
        System.out.print("随即分数为：");
        for(int i=0; i<6; i++){
            System.out.print(arr[i]+" ");
        }
        int average = getAverage(arr);
        System.out.println("\n平均分为："+average);
    }
    public static void getGrades(int[] arr){
        Random random = new Random();
        for(int i=0; i<arr.length; i++){
            arr[i] = random.nextInt(101);
        }
    }
    public static int getAverage(int[] arr){
        int n = arr.length;
        int min = arr[0];
        int max = arr[0];
        int sum = 0;
        for (int i=0; i<n; i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        for (int j=0; j<n; j++){
            if(min>arr[j]){
                min = arr[j];
            }
        }
        for (int k=0; k<n; k++){
            sum += arr[k];
        }
        double average = (sum-max-min)/(n-2);
        return (int) average;
    }
}

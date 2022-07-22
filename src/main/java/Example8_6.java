public class Example8_6 {
    public static void main(String[] args) {
        getSum();
    }
    public static void getSum(){
        int arr [] = {68,27,95,88,171,996,51,210};
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            if(!String.valueOf(arr[i]).contains("7") && arr[i]%2==0){
                sum += arr[i];
            }
        }
        System.out.println("计算结果为："+sum);
    }
}

public class Example8_7 {
    public static void main(String[] args) {
        int[] arr1 = {10,20,30};
        int[] arr2 = {10,20,30};
        int[] arr3 = {10,20,30,40};
        Boolean bool1 = getArr(arr1, arr2);
        Boolean bool2 = getArr(arr2, arr3);
        System.out.println("arr1和arr2是否相等: "+bool1);
        System.out.println("arr2和arr3是否相等: "+bool2);
    }
    public static boolean getArr(int[] a, int[] b){
        int m = a.length;
        int n = b.length;
        boolean answer = false;
        int j=0;
        if (m==n){
            for (int i=0; i<m; i++){
                if(a[i] == b[i]){
                    j = i;
                }
            }
            if(j==m-1){
                answer = true;
            }
        }
        return answer;
    }
}

public class SumOfN_Recursion {
    public static void main(String[] args){
        System.out.println(sumOfN(10));
    }
    public static int sumOfN(int n){
        if(n==0) {
            return n;
        }
        else {
            return n + sumOfN(n-1);
        }
    }
}

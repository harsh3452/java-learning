public class NameNTimes {
    public static void main(String[] args){
        printNameRec(5);
    }
    public static void printNameRec(int n){
        if(n==0){
            return;
        } else {
            System.out.println("Harsh");
            printNameRec(n-1);
        }
    }
}

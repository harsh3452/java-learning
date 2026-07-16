public class PrintingRec {
    public static void main(String[] args){
        printRec(5);
    }
    public static void printRec(int n){
        if(n==0){
            return ;
        } else {
            //prints in descending order as itsd prints before the recusrive call
            System.out.println(n+" ");
            printRec(n-1);
            // prints in ascending order as its called after recursive call so after all recurive calls are ended its printed. so if int n == 5 until and unless all recursve function are finished we won't print 5. and its opposite for the above condition
            System.out.println(n+" ");
        }
    }
}


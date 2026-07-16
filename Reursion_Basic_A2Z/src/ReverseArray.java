public class ReverseArray {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7};
        reverseArray(array,0,array.length-1);
        for(int n : array){
            System.out.println(n+" ");
        }
    }
    public static void reverseArray(int[] array, int start,int last){
        int n = last - start;
        if(n == 0 || n == 1){
            return;
        } else {
            int temp = array[start];
            array[start] = array[last];
            array[last] = temp;
            reverseArray(array,start+1,last-1);
        }
    }
}

public class QuickSortMemory {
    public static void main(String[] args) {

        int[] arr = {8, 58, 5, 2, 5, 6};

        quickSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    public static void quickSort(int[] arr,int start, int end){
       if(start<end){
           int pi = partition(arr,start,end);
           quickSort(arr,start,pi-1);
           quickSort(arr,pi+1,end);
       }

    }
    public static int partition(int[] arr,int start,int end){
        //int i = start -1;
        int i = 0;
        int pivot = arr[end];
        for(int j = 0; j<end; j++){
            if(arr[j]<pivot){
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,i,end); // moving pivot to the right location. wrote i+1 but it should have been i because i changeed the initial condition of what i is. in this version i represent the free/valid index we can swap to. but in the standard implemetation. i represent numbers which are smaller than pivt
        return i;
    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

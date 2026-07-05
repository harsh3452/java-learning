public class QuickSort {
    private static int partition(int[] array, int start, int end){
        int left = start -1;
        int pivot = array[end];
        for( int right = start; right<end;right++){
            if(array[right]<pivot){
               left++;
                swap(array, left, right);
            }
        }
        swap(array, left+1, end);
        return left+1;
    }
    private static void quickSort(int[] array, int start, int end){

        if(start<end){
            int pi = partition(array, start, end);
            quickSort(array,start,pi-1);
            quickSort(array, pi+1,end);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {8, 58, 5, 2, 5, 6};

        quickSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

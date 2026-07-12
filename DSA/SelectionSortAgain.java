public class SelectionSortAgain {
    public static void main(String[] args){
        int[] arr = {29, 10, 14, 37, 13, 10, 25, 5};
        selectionSort(arr);
        for(int n : arr){
            System.out.print(n + " ");
        }
    }

    private static void selectionSort(int[] arr) {

        for(int i = 0; i< arr.length; i++){
            int minElementIndex = i;
            for(int j = i+1; j<arr.length; j++){
                if(arr[j]<arr[minElementIndex]){ // find the minimum in the entire array.
                    minElementIndex = j;
                }
            }
            if(minElementIndex != i){ // avoid unnecessary swaps
                swap(arr,i,minElementIndex);
            }
        }
    }
    private static void swap(int[] arr, int j, int k){
        int temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
    }
}

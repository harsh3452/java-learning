public class BubbleSort {
    public static void main(String[] args){
        int[] arr = {29, 10, 14, 37, 13, 10, 25, 5};
        bubbleSort(arr);
        for(int n : arr){
            System.out.print(n + " ");
        }
    }
        private static void bubbleSort(int[] arr){

            for(int i = 0; i<arr.length; i++){ // this is unreleated to the inner loop i tired to integreate it and failed. two pointer brain glitching
                boolean swapped = false;
                for(int j = 0; j<arr.length-i-1; j++){ // don't go to the last index as we bubble the largest to the back
                    if(arr[j]>arr[j+1]){ // perform adjancent comparsion
                        swap(arr,j+1,j);
                        swapped=true;
                    }
                }
            if(!swapped) break;
            }
        }
    private static void swap(int[] arr, int j, int k){
        int temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
    }
}

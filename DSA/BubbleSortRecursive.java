public class BubbleSortRecursive {
    public static void main(String[] args){
        int[] arr = {29, 10, 14, 37, 13, 10, 25, 5};
        int size = arr.length-1;
        bubbleSortRecursive(arr,size);
        for(int n : arr){
            System.out.print(n + " ");
        }
    }

    private static void bubbleSortRecursive(int[] arr,int n) {
        if(n<=0){
            return;
        } else {
                for(int j = 0; j<n; j++){ // don't go to the last index as we bubble the largest to the back
                    if(arr[j]>arr[j+1]){ // perform adjancent comparsion
                        swap(arr,j+1,j);
                    }
                }
            bubbleSortRecursive(arr,n-1);
        }
        }

    private static void swap(int[] arr, int j, int k){
        int temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
    }
}



public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {8,58,5,2,5,6};
        //int[] arr = {1,2,3,4,5,6};
        insertionSort(arr);
        for(int n : arr){
            System.out.println(n +" ");
        }
    }

    private static void insertionSort(int[] arr){
        for(int i = 0; i<arr.length-1;i++){
            int j = i+1;
            int key = arr[j]; 
            while( j > 0 && arr[j-1] > key){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = key;
            
        }

    }

   
}


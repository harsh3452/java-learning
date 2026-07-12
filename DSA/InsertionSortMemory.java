public class InsertionSortMemory {
    public static void main(String[] args){
        int[] arr = {29, 10, 14, 37, 13, 10, 25, 5};
        insertionSort(arr);
        for(int n : arr){
            System.out.print(n + " ");
        }
    }

    private static void insertionSort(int[] arr) {
        for(int i = 0; i<arr.length-1; i++){ // i = 1;
            int j = i+1;                    // int j = i-1;
            int key = arr[j];               // int key = arr[i]; //standard implementations
            while(j > 0 && arr[j-1]>key){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j] = key;
        }
    }
}

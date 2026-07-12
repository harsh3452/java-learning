public class InsertionSortRecursive {
    public static void main(String[] args){
        int[] arr = {29, 10, 14, 37, 13, 10, 25, 5};
        insertionSortRecursive(arr,0,arr.length-1);
        for(int n : arr){
            System.out.print(n + " ");
        }
    }

    private static void insertionSortRecursive(int[] arr, int i, int size) {
                if( i== size) {
                    return;
                }
                else {
                    int j = i+1;
                    int key = arr[j];
                    while(j > 0 && arr[j-1]>key){
                        arr[j]=arr[j-1];
                        j--;
                    }
                    arr[j] = key;
                }
                insertionSortRecursive(arr,++i,size);


        }
    }



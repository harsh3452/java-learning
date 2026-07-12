
public class MergeSortMemory {
    public static void main(String[] args){
        int[] arr = {29, 10, 14, 37, 13, 10, 25, 5};
        mergeSort(arr,0,arr.length-1);
        for(int n : arr){
            System.out.print(n + " ");
        }
    }

    private static void mergeSort(int[] arr, int l , int r) {
        if(l<r){
            int mid = (l+r)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }
    private static void merge(int[] arr, int l , int mid, int r){
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] lArray = new int[n1];
        int[] rArray = new int[n2];

        int tempL = l;
        for(int i = 0 ; i<n1; i++){
            lArray[i]=arr[tempL];
            tempL++;
        }
        int tempMid = mid+1;
        for(int j =0 ; j<n2; j++){
            rArray[j]=arr[tempMid];
           tempMid++;
        }

        //filling new array, but we need array to fill from. so we need more two arrray? larray and rarray?
        int  i = 0;
        int j = 0;
        int k = l; // this is essential because not each of the l an r array well be starting from zero it can be right side of the array, and we need to start and store them starting from the lowest l side and not the absolute zero
        while (i<n1 && j<n2){
            if(lArray[i]<=rArray[j]){
                arr[k]=lArray[i];
                i++;
            } else {
                arr[k]=rArray[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=lArray[i];
            k++;
            i++;
        }
        while(j<n2){
            arr[k]=rArray[j];
            k++;
            j++;
        }
    }

}

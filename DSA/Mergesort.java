public class Mergesort {
    public static void main(String[] args){
        int[] array = {1,4,5,6,3,66,777,543,87,54,23,65};
        mergeSort(array,0,array.length-1);
        printArray(array);
    }

    private static void mergeSort(int[] array, int l, int r) {
        if(l<r){
            int mid = (l+r)/2;
            mergeSort(array,l,mid);
            mergeSort(array,mid+1,r);
            merge(array,l,mid,r);
        }
    }

    private static void merge(int[] array, int l, int mid, int r){
        int n1 = mid-l+1;
        int n2 = r-mid;
        int[] lArray = new int[n1];
        int[] rArray = new int[n2];

        for(int x=0;x<n1;x++){
            lArray[x] = array[l+x];
        }
        for(int x = 0; x<n2;x++){
            rArray[x] = array[mid+x+1];
        }
        int i = 0; // these are zero because we created them and always start from zero
        int j = 0;
        int k = l; // k can be non zero as we are merging intermediate arrays as well

        while((i<n1) && (j<n2)){
            if(lArray[i] <= rArray[j]){
                array[k] = lArray[i];
                i++;
            } else {
                array[k]= rArray[j];
                j++;
            }
            k++;
        }
        //fill any remaining elements into the array directly. if there are. because one array will be finished
        while(i<n1){
            array[k]=lArray[i];
            i++;
            k++;
        }
        while(j<n2){
            array[k]=rArray[j];
            j++;
            k++;
        }
    }
    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
public class SelectionSort {
    public static void main(String[] args) {
        //int[] arr = {8,58,5,2,5,6};
        int[] arr = {1,2,3,4,5,6};
        selectionSort(arr);
        for(int n : arr){
            System.out.println(n +" ");
        }
    }

    private static void selectionSort(int[] array){
        //  i think this assigment is wrong
    
        for(int i = 0; i<array.length-1;i++){
            int minElement = i;
            for(int j = i+1; j<array.length;j++){
                if(array[minElement] > array[j]){
                    minElement = j;
                }
            }
            if(minElement == i){

            } else {
                int temp = array[i];
                array[i]= array[minElement];
                array[minElement]= temp;
            }
           
        }
    }
   
}


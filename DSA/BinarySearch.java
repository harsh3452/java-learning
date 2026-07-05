    public class BinarySearch {
        public static int binarySearch(int[] array, int target){
            int left = 0;
            int right = array.length-1;
            while(left<=right){
                int mid = (left+right)/2;
                if(target == array[mid]){
                    return mid;
                } else if(target > array[mid]){
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }
            return -1;
        }
        public static int binarySearchRecursive(int[] array, int target,int left, int right){
            if (left > right)
                return -1;

            int mid = left + (right - left) / 2;

            if (array[mid] == target)
                return mid;

            if (target > array[mid])
                return binarySearchRecursive(array, target, mid + 1, right);
 
            return binarySearchRecursive(array, target, left, mid - 1);
        }
        public static void main(String[] args){
            int[] arr = {1,2,3,4,5};
            int target = 3; 
            int result = binarySearch(arr, target);
            int resultRecusrive = binarySearchRecursive(arr, target, 0, arr.length-1);
        
            if(result != -1){
                System.out.println("Element found at index " + result);
            } else {
                System.out.println("Element not found");
            }
            if(resultRecusrive != -1){
                System.out.println("Element found at index " + resultRecusrive);
            } else {
                System.out.println("Element not found");
            }
        }
    }

/**
 * Problem 2: You are given two sorted arrays A and B where A has a large enough buffer at the end to hold B.
 * Write a function to merge B into A in sorted order.
 *
 * Author: Ken Kohlhof
 *
 * Time Complexity: O(n) This is because the sortMerge method iterates through both arrays once to merge them into array A.
 * Space Complexity: O(1) This is because the sortMerge method has consistent memory and does not create additional data.
 */


public class Problem2 {

    //Method sorts and merges array B into A
    public static void sortMerge(int[] a, int[] b, int lastIndex){
        int lastIndexOfA = lastIndex - 1;
        int lastIndexOfB = lastIndex - 1;
        int endOfMergeIndex = lastIndex * 2 - 1;

        //While the lastIndexOfB value is greater than 0
        while(lastIndexOfB >= 0){
            //If the lastIndexOfA is greater than 0 and is greater than B
            if(lastIndexOfA >= 0 && a[lastIndexOfA] > b[lastIndexOfB]){
                //Copy the element at the index of the value of lastIndexOfA to index of value endOfMergeIndex
                a[endOfMergeIndex] = a[lastIndexOfA];
                //Minus 1 from value of lastIndexOfA
                lastIndexOfA--;
            }
            else{
                //Copy the element at the index of the value lastIndexOfB from array b to array a at index of value endOfMergeIndex
                a[endOfMergeIndex] = b[lastIndexOfB];
                //Minus 1 from value of lastIndexOfB
                lastIndexOfB--;
            }

            //Minus 1 from value of endOfMergeIndex
            endOfMergeIndex--;

        }
    }

    //Helper function to print array
    public static void printArray(int array[], int n){
        for(int i = 0; i < n; i++) {
            //if last iteration just prints element at array index i.
            if (i == n - 1) {
                System.out.print(array[i]);
            }
            //Prints element at array index i plus a comma and space
            else {
                System.out.print(array[i] + ", ");
            }
        }
    }

    public static void main(String[] args){

        //initializes arrays
        int[] A = new int[]{2,4,6,8,10,0,0,0,0,0};
        int[] B = new int[]{1,3,5,7,9};


        //Calls both sortMerge method and printArray Method
        sortMerge(A,B,B.length);
        printArray(A, A.length);
    }

}

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem 1: An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once. Given an array of strings,
 * you need to develop a function that sorts the anagrams and display them next to each other.
 *
 * Author: Ken Kohlhof
 *
 * Time Complexity: O(n log n) This is because the sortArray() method has a time complexity of O(n log n) for sorting
 * an array of n elements where n is the number of elements in stringArray.
 *
 * Space Complexity: O(n) This is because we are storing the input stringArray of size n and the AnagramComparator object
 * in the memory.
 */

public class Problem1 {

    public static void sortArray(String[] stringArray){
        Arrays.sort(stringArray, new AnagramComparator());
    }

    //Main call method
    public static void main(String[] args){

        //Initializes the stringArray
        String[] stringArray = new String[]{"laying", "below", "study", "night", "elbow", "cat", "dusty", "act", "thing", "gainly"};

        //Calls sortArray method to sort String array
        sortArray(stringArray);

        //Boolean to see if words should be next to each other
        boolean nextToEachOther = false;

        //Iterates through array
        for(int i = 0; i <= stringArray.length-1; i++){
            //If next to each other equals false prints the string at index i then prints a comma and space.
            if(!nextToEachOther){
                System.out.print(stringArray[i] + ", ");
                //Sets nextToEachOther to true
                nextToEachOther = true;
            }
            else{
                //Prints string at index i then drops cursor to next line.
                System.out.println(stringArray[i]);
                //Sets nextToEachOther to false.
                nextToEachOther = false;
            }
        }

    }
}

//SuperClass that implements premade interface Comparator
class AnagramComparator implements Comparator<String>{

    @Override
    public int compare(String string1, String string2){
        //Checks if String1 or String2 are null
        if(string1 == null || string2 == null){
            return -1;
        }
        //Checks if String1's length is shorter then string2
        if(string1.length() < string2.length()){
            return -1;
        }
        //Checks if String1's length is greater then string2
        else if(string1.length() > string2.length()){
            return 1;
        }

        //Compares sorted String1 to Sorted String2
        return sort(string1).compareTo(sort(string2));
    }

    private String sort(String string){
        //Turns String into char Array
        char[] charArray = string.toCharArray();
        //Sorts array
        Arrays.sort(charArray);
        //returns array as a new String object
        return new String(charArray);
    }
}
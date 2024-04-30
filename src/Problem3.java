/**
 *  Problem 3: We can easily verify that none of the entries in the first seven rows of Pascal's triangle are divisible by 7:
 *
 *              1
 *            1    1
 *          1    2    1
 *        1    3    3    1
 *      1    4    6    4    1
 *    1    5   10   10    5    1
 * 1    6   15   20   15    6    1
 * However, if we check the first one hundred rows, we will find that only 2361 of the 5050 entries are not divisible by 7.
 *
 * Find the number of entries which are not divisible by 7 in the first one billion (109) rows of Pascal's triangle.
 *
 * Author: Ken Kohlhof
 *
 * Time Complexity: O(log n) This is because each time sumOfNot7 method is called recursively it has a reduced input
 * size each time since it's divided by 7.
 *
 * Space Complexity: O(log n) I believe this is because the recursive calls are stored on the call stack.
 */


public class Problem3 {
    private static long sumOfNot7(int numberOfRows){
        //checks if sumOfNot7 is less than or equal to 7
        if(numberOfRows <= 7){
            return numberOfRows * (numberOfRows+1)/2;
        }
        //Sets i as the numberOfRows subtracted from the remainder of numberOfRows divided by 7
        int i = numberOfRows-numberOfRows%7;
        //Sets answer to initial value 0
        long answer = 0;
        //for loop that sets the result of notMultipleOf7 plus the current value of answer to answer.
        for(int n = i;n < numberOfRows;n++){
            answer += notMultipleOf7(n);
        }
        //Returns answer
        return answer+28*sumOfNot7(i/7);
    }

    private static long notMultipleOf7(int number){
        //Base case
        if(number == 0){
            return 1;
        }
        //Returns how many numbers in row x (x being the value passed) that weren't multiples of 7
        else{
            return (1+number%7)*notMultipleOf7(number/7);
        }
    }

    public static void main(String[] args){

        //Variable stores the number of rows we check of Pascal's Triangle
        final int numberOfRows = 1000000000;

        //Test value to make sure it matches the example in instructions.
        //final int numberOfRows = 100;

        //Calls sumOfNot7 method passing variable last row and stores return value as answer
        long answer = sumOfNot7(numberOfRows);

        //Print message that informs user of the answer
        System.out.println("There are " + answer + " entries that are not divisible by 7 in the first " +
                " one billion rows of Pascal's triangle.");
    }
}

/**
 * Sorted Squared Array
 * 
 * Write a function that takes in a non-empty array of integers that are sorted in ascending order and returns
 * a new array of the same length with the squares of the original integers also sroted in ascending order.
 * 
 * Source: https://www.algoexpert.io/questions/Sorted%20Squared%20Array
 */

import java.util.*;

public class SortedSquaredArray {
    
    public static int[] sortedSquaredArray(int[] array) {

        int highIndex = array.length - 1;
        int lowIndex = 0;
        int resultIndex = array.length - 1;
        int[] resultArray = new int[array.length];

        for (int i = array.length; i > 0; i--) {
            if (Math.abs(array[lowIndex]) > Math.abs(array[highIndex])) {
                resultArray[resultIndex] = (int)Math.pow(array[lowIndex], 2);
                lowIndex++;
                resultIndex--;
            }
            else {
                resultArray[resultIndex] = (int)Math.pow(array[highIndex], 2);
                highIndex--;
                resultIndex--;
            }
        }

        return resultArray;
    }

    public static void main(String[] args) {

        int arraySize;
        Scanner scanner = new Scanner(System.in);        

        System.out.println("How many numbers would you like to be squared?");
        arraySize = scanner.nextInt();
        int[] inputArray = new int[arraySize];
        System.out.println("Please enter numbers in ascending order: \n");

        for (int i = 0; i < arraySize; i++) {
            System.out.println("Number " + (i + 1) + ": ");
            inputArray[i] = scanner.nextInt();
        }

        int[] resultArray = new int[arraySize];
        resultArray = sortedSquaredArray(inputArray);

        System.out.println("Your sorted array: ");
        System.out.print("[");
        for (int i = 0; i < arraySize; i++) {
            System.out.print(resultArray[i]);
            if (i < arraySize - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]\n");

        scanner.close();
    }
}

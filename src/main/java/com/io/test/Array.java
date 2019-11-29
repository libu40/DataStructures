package com.io.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Array {

  public static void main(String[] args) {
    /* Rotating the array */
    int[] array = {1, 2, 3, 4, 5, 6, 7, 1};
    int[] output = rotateByOne(array, 2, 7);

    /* Reversing the array*/
    int[] reversedArray = reverseArray(array, array.length);
    for (int i = 0; i < output.length; i++) {
      System.out.println(output[i]);
    }
    System.out.println("-------------------------------");
    for (int i = 0; i < reversedArray.length; i++) {
      System.out.println(reversedArray[i]);
    }
    System.out.println("-------------------------------");
    int returnValue = searchKey(output, 4);
    if (returnValue == 4) {
      System.out.println(" key found ");
    } else {
      System.out.println("bad luck");
    }

    System.out.println("-------------------------------");
    int[] rotatedArray = circularRotate(array);
    for (int i = 0; i < rotatedArray.length; i++) {
      System.out.println(rotatedArray[i]);
    }

    System.out.println("-------------------------------");
    int largestElementInTheArray = largestElement(output);
    System.out.println(" largest element " + largestElementInTheArray);

    System.out.println("-------------------------------");
    boolean isDuplicateExist = checkForDuplicates(array);
    System.out.println(" Is duplicate exist" + isDuplicateExist);

    System.out.println("-------------------------------");
    int[] fibonacciSeries = printFibonacci(20);
    for (int element : fibonacciSeries) {
      System.out.println(element);
    }

    System.out.println("-------------------------------");
    boolean isPallindrome = checkForPallindrome("madam");

    System.out.println("---------------------------------");
    int[] maxArray= {5, 6, 4, 3, 2};
    int maxElement = maximumElement(maxArray, maxArray.length);
    System.out.println(" the maximum element in the arrays is" +maxElement);
  }

  private static boolean checkForPallindrome(String compareData) {
    char[] characterArray = compareData.toCharArray();
    StringBuilder builder = new StringBuilder();
    for (int i = characterArray.length - 1; i >= 0; i--) {
      builder.append(characterArray[i]);
    }
    if (compareData.equalsIgnoreCase(builder.toString())) {
      return true;
    }
    return false;

  }

  private static int searchKey(int[] output, int key) {
    /* Searching an element in the sorted and rotated array */
    /*1) Find out pivot point and divide the array in two
    sub-arrays. (pivot = 2) *//*Index of 5*//*
    2) Now call binary search for one of the two sub-arrays.
    (a) If element is greater than 0th element then
    search in left array
    (b) Else Search in right array
    (1 will go in else as 1 < 0th element(3))
    3) If element is found in selected sub-array then return index
    Else return -1.*/

    int pivotElement = findPivot(output, 0, output.length - 1, 0, output.length - 1);
    boolean isFound = false;
    /**+
     *  If the array is not rotated then the pivot element is not found
     */
    if (pivotElement == -1) {
      return binarySearchTree(output, 0, output.length - 1, key);
    }
    if (output[pivotElement] == key) {
      return pivotElement;
    }
    if (output[0] < key) {
      return binarySearchTree(output, 0, pivotElement - 1, key);
    }
    return binarySearchTree(output, pivotElement + 1, output.length - 1, key);
  }

  private static int binarySearchTree(int[] output, int low, int high, int key) {
    int mid = low + (high - low) / 2;
    if (output[mid] == key) {
      return key;
    }
    if (key > output[mid]) {
      return binarySearchTree(output, (mid + 1), high, key);

    }
    return binarySearchTree(output, low, (mid - 1), key);
  }

  /**
   * + This is the method to find the pivot(largest element) in the array
   */
  private static int findPivot(int[] arr, int low, int high, int lowerBound, int upperBound) {
    int mid = low + (high - low) / 2;

    if (mid == lowerBound) {
      if (mid == upperBound) {
        // Only 1 element
        return mid;
      } else if (arr[mid] >= arr[mid + 1]) {
        // Pivot is the greater element
        return mid;
      }
    } else if (mid == upperBound) {
      if (arr[mid] >= arr[mid - 1]) {
        // Pivot is the greater element
        return mid;
      }
    } else {
      if (arr[mid] >= arr[mid + 1] && arr[mid] >= arr[mid - 1]) {
        // Mid value is the pivot
        return mid;
      } else if (arr[mid] > arr[high]) {
        // The Pivot is in the second half
        return findPivot(arr, mid + 1, high, lowerBound, upperBound);
      } else if (arr[mid] < arr[high]) {
        // The Pivot is in the first half
        return findPivot(arr, low, mid - 1, lowerBound, upperBound);
      }
    }

    return -1;
  }

  //Array reversal
  private static int[] reverseArray(int[] normalArray, int length) {
    int[] reversedArray = new int[length];
    int j = length;
    for (int i = 0; i < length; i++) {
      reversedArray[j - 1] = normalArray[i];
      j = j - 1;
    }
    return reversedArray;
  }

  private static int[] rotateByOne(int[] array, int noOfTimesToRotate, int lastNumber) {
    int[] output = new int[0];
    for (int i = 0; i < noOfTimesToRotate; i++) {
      output = shiftLeftByOne(array, lastNumber);
    }
    return output;
  }

  /**
   * + The below method creates a new array for every iteration
   */
  private static int[] shiftLeftByOne(int[] array, int lastNumber) {
    int i, temp;
    temp = array[0];
    for (i = 0; i < array.length - 1; i++) {
      array[i] = array[i + 1];
    }
    array[i] = temp;

    return array;
  }

  /**
   * + rotating the array without creating new array
   */

  private static int[] circularRotate(int[] array) {
    int temp = array[array.length - 1];
    for (int i = array.length - 1; i > 0; --i) {
      array[i] = array[i - 1];

    }
    array[0] = temp;
    return array;

  }

  /**
   * + Finding the largest element in the array
   */

  private static int largestElement(int[] array) {
    IntStream sortedStreamArray = Arrays.stream(array)
        .sorted();
    int[] sortedArray = sortedStreamArray.map(element -> element).toArray();
    int i;
    for (i = 0; i < sortedArray.length - 1; i++) {
      if (sortedArray[i + 1] > sortedArray[i]) {
        i = i + 1;
      }
    }
    return sortedArray[i];
  }

  private static boolean checkForDuplicates(int[] array) {

    Map<Integer, Integer> count = new HashMap<>();
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = i + 1; j <= array.length - 1; j++) {
        if (array[i] == array[j]) {
          if (count.size() > 0) {
            count.put(array[i], count.get(array[i]) + 1);
          } else {
            count.put(array[i], 1);
          }

        }
      }

    }
    if (count.size() > 0) {
      return true;
    }
    return false;
  }

  private static int[] printFibonacci(int number) {
    int[] sum = new int[number];
    for (int i = 0; i < number; i++) {
      sum[i] = performFibonacciRecursion(i);
    }
    return sum;

  }

  private static int performFibonacciRecursion(int i) {
    if (i == 0) {
      return 0;
    } else if (i == 1 || i == 2) {
      return i;
    } else {
      return performFibonacciRecursion(i - 1) + performFibonacciRecursion(i - 2);
    }
  }

  private static int maximumElement(int[] array, int n) {
    if(n<=3) {
      return -1;
    }

    int maximumElement = array[0];
    int maximumProduct = array[n-1] * array[1];

    for(int i=1; i<n; i++) {
      int currentProduct = array[i-1] *array[(i+1) % n];
      if (currentProduct > maximumProduct) {
        maximumProduct = currentProduct;
        maximumElement = array[i];
      } else if(currentProduct == maximumProduct) {
        maximumElement = Math.max(maximumElement, array[i]);
      }
    }
    return maximumElement;

  }



}

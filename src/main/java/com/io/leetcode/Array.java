package com.io.leetcode;

import com.io.leetcode.model.Employee;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Array {

  public static void main(String[] args) throws Exception {
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
    int[] maxArray = {5, 6, 4, 3, 2};
    int maxElement = maximumElement(maxArray, maxArray.length);
    System.out.println(" the maximum element in the arrays is" + maxElement);

    System.out.println("---------------------------------");
    int countOfDuplicates = checkDuplicateCharacters("geeksforgeeks");
    System.out.println(" the duplicate characters size is" + countOfDuplicates);

    System.out.println("---------------------------------");
    swapArrayElements(new int[]{1, 1, 0, 0, 1});
    NthSalaryOfEmployee();
    uniqueElements("geeksforgeeks");
    findElementStartsWith2();
    System.out.println("---------------------------------");
    int[] arr = {1, 2, 3, 4, 5};
    int[] resultantPrefixSum = prefixSum(arr);
    int result = rangeSum(resultantPrefixSum, 1, 3);
    System.out.println("The sum of the range is " + result);
    System.out.println("---------------------------------");
    System.out.println("The two pointer sum exiist for the pair" + twoPointerProblem(
        new int[]{1, 2, 3, 4, 5, 6, 7}, 9));
    System.out.println("---------------------------------");
    System.out.println(
        "The maximum sub array for kth element is " + maxSubArray(new int[]{1, 2, 3, 4, 5, 6, 7},
            3));

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
    IntStream sortedStreamArray = Arrays.stream(array).sorted();
    int[] sortedArray = sortedStreamArray.toArray();
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
          if (!count.isEmpty()) {
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
    if (n <= 3) {
      return -1;
    }

    int maximumElement = array[0];
    int maximumProduct = array[n - 1] * array[1];

    for (int i = 1; i < n; i++) {
      int currentProduct = array[i - 1] * array[(i + 1) % n];
      if (currentProduct > maximumProduct) {
        maximumProduct = currentProduct;
        maximumElement = array[i];
      } else if (currentProduct == maximumProduct) {
        maximumElement = Math.max(maximumElement, array[i]);
      }
    }
    return maximumElement;

  }

  private static int checkDuplicateCharacters(String duplicateCharacterText) {
    List<String> duplicateCharacters = Arrays.stream(duplicateCharacterText.split(""))
        .collect(Collectors.groupingBy(character -> character, Collectors.counting())).entrySet()
        .stream().filter(entry -> entry.getValue() > 1).map(Entry::getKey)
        .collect(Collectors.toList());
    return duplicateCharacters.size();
  }

  // [1,1,0,0,1]
  private static void swapArrayElements(int[] binaryArray) {
    int left = 0;
    int right = binaryArray.length - 1;

    while (left < right) {
      while (left < binaryArray.length && binaryArray[left] == 0) {
        left++;
      }
      while (right >= 0 && binaryArray[right] == 1) {
        right--;
      }
      if (left < right) {
        int temp = binaryArray[left];
        binaryArray[left] = binaryArray[right];
        binaryArray[right] = temp;
        left++;
        right--;
      }
    }
    System.out.println("The array after swapping is " + Arrays.toString(binaryArray));
  }

  private static void NthSalaryOfEmployee() {
    Map<String, Employee> employeeMap = new HashMap<>();
    employeeMap.put("Libu", new Employee("Libu", 24, "24/01/1990", 100001));
    employeeMap.put("Linu", new Employee("Linu", 24, "24/01/1990", 100002));
    employeeMap.put("Libj", new Employee("Libj", 24, "24/01/1990", 100003));
    employeeMap.put("Liku", new Employee("Liku", 24, "24/01/1990", 100004));

    Optional<Integer> highestSalary = employeeMap.values().stream().map(Employee::getSalary)
        .distinct().sorted(Comparator.reverseOrder()).skip(2).findFirst();
  }

  private static String uniqueElements(String text) {
    return Arrays.stream(text.split(""))
        .collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting()))
        .entrySet().stream().filter(entry -> entry.getValue() == 1).map(Entry::getKey)
        .collect(Collectors.joining());
  }

  private static Optional<String> findElementStartsWith2() {
    int[] inputArray = {1, 25, 34, 45, 26, 26, 37};
    return Arrays.stream(inputArray).boxed().map(Object::toString)
        .filter(number -> number.startsWith("2")).findFirst();
  }

  private static int[] prefixSum(int[] sumArray) {

    int length = sumArray.length;
    int[] prefixSum = new int[length];
    prefixSum[0] = sumArray[0];
    for (int i = 1; i < length; i++) {
      prefixSum[i] = prefixSum[i - 1] + sumArray[i];
    }
    return prefixSum;
  }

  private static int rangeSum(int[] prefixSum, int start, int end) {

    if (start == 0) {
      return 0;
    }
    return prefixSum[end] - prefixSum[start - 1];
  }

  private static boolean twoPointerProblem(int[] inputArray, int target) {
    // {1, 2, 3, 4, 5, 6, 7};
    int left = 0;
    int right = inputArray.length - 1;
    while (left < right) {
      int currentSum = inputArray[left] + inputArray[right];
      if (currentSum == target) {
        return true;
      } else if (currentSum < target) {
        left++;
      } else {
        right--;
      }
    }
    return false;
  }

  private static int maxSubArray(int[] input, int k) throws Exception {

    if (input.length < k) {
      throw new Exception("Error");
    }
    int maximumSum = 0, currentSum = 0;
    for (int i = 0; i < k; i++) {
      maximumSum += input[i];
    }
    maximumSum = currentSum;
    for (int i = k; i < input.length; i++) {
      currentSum = currentSum - input[i - k] + input[i];
      maximumSum = Math.max(currentSum, maximumSum);
    }
    return maximumSum;
  }


}

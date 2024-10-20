package com.io.leetcode;

public class ArrayLists {

  public static void main(String[] args) {

    int[] array1 = {1, 2, 3, 4, 5, 6, 7, 1};
    int[] array2 = {1, 2, 3};
    int[] output = mregeTwoArray(array1, array2);

    System.out.println("---------------------------------");
    for (int i = 0; i < output.length; i++) {
      System.out.println(output[i]);
    }

  }

  public static int[] mregeTwoArray(int[] array1, int[] array2) {
    int array1Length = array1.length;
    int array2Length = array2.length;
    int[] result = new int[array1Length + array2Length];

    int i = 0, j = 0, k = 0;

    while (i < array1Length && j < array2Length) {
      if (array1[i] < array2[j]) {
        result[k++] = array1[i++];

      } else {
        result[k++] = array2[j++];

      }
      while (i < array1Length) {
        result[k++] = array1[i++];
      }

      while (j < array2Length) {
        result[k++] = array2[j++];
      }

    }

    return result;
  }

}

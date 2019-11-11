package com.io.test;

import com.io.test.model.Employee;
import com.io.test.util.MyBiFunction;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

public class Hashmap {

  public static void main(String[] args) {

    Map<Integer, Employee> employeeMap = new java.util.HashMap<>();
    Map<String, Integer> countMap = new HashMap<>();
    Employee employee1 = new Employee("Libu", 1, "1");
    Employee employee2 = new Employee("Mathew", 2, "2");
    employeeMap.put(1, employee1);
    employeeMap.put(2, employee2);
    countMap.put("OHRA", 1);
    countMap.put("ONVZ", 2);
    countMap.put("OHRA1", 3);
    System.out.println(employee1 == employee2);

    //Iterating through entry set.
    Set<Map.Entry<String, Integer>> countSet = countMap.entrySet();
    System.out.println("The size of set and map is" + countSet.size() + "" + countMap.size());
    for (Map.Entry<String, Integer> entry : countSet) {
      System.out.println(
          "The key value from count set are" + entry.getKey() + "value" + entry.getValue());
    }
    BiFunction<String, Integer, Integer> biFunction = new MyBiFunction();
    countMap.replaceAll(biFunction);
    countMap.replaceAll(
        (k, v) -> {
          if (k != null) {
            return Integer.valueOf(k + v);
          } else {
            return v;
          }
        }
    );



  }
}

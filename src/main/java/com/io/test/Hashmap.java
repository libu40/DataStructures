package com.io.test;

import com.io.test.model.Employee;
import java.util.Map;

public class Hashmap {

  public static void main(String[] args) {

    Map<Integer, Employee> employeeMap = new java.util.HashMap<>();
    Employee employee1 = new Employee("Libu", 1, "1");
    Employee employee2 = new Employee("Mathew", 2, "2");
    employeeMap.put(1, employee1);
    employeeMap.put(2, employee2);
    System.out.println(employee1 == employee2);
    System.out.println(employeeMap.get(1).getName());
  }

}

package com.io.leetcode.model;

import java.io.Serializable;


public class Employee implements Serializable {

  private String name;
  private int age;
  private String dateOfBirth;
  private int salary;

  public Employee() {
  }

  public Employee(String name, int age, String DOB, int salary) {
    this.name = name;
    this.age = age;
    this.dateOfBirth = DOB;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }


  public int getSalary() {
    return salary;
  }


  public void setSalary(int salary) {
    this.salary = salary;
  }
}

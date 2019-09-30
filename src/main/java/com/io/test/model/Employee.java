package com.io.test.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class Employee implements Serializable {

  private String name;
  private int age;
  private String dateOfBirth;

  public Employee() {
  }

  public Employee(String name, int age, String DOB) {
    this.name = name;
    this.age = age;
    this.dateOfBirth = DOB;
  }


}

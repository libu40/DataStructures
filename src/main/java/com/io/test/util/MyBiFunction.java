package com.io.test.util;

import java.util.function.BiFunction;

public class MyBiFunction implements BiFunction<String, Integer, Integer> {

  @Override
  public Integer apply(String t, Integer u) {
    if (t != null) {
      return Integer.valueOf(t + u);
    } else {
      return u;
    }
  }


}

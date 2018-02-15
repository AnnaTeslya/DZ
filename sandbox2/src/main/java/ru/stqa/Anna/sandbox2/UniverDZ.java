package ru.stqa.Anna.sandbox2;

import java.util.ArrayList;
import java.util.List;

public class UniverDZ {
  public static void main(String[] args) {
    double[] massiv = new double[100];
    for (int i = 0; i < massiv.length; i++) {
      massiv[i] =  Math.random();
      System.out.println(massiv[i]);
    }

  }
}
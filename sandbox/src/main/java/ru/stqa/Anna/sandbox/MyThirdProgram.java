package ru.stqa.Anna.sandbox;

  public class MyThirdProgram {
    public static void main(String[] args) {
      Points p1 = new Points(10, 80);
      Points p2 = new Points(10, 10);
      System.out.println("Расстояние между двумя точками равно " + p1.distance(p2));
    }
  }

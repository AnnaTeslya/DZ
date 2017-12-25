package ru.stqa.Anna.sandbox;

  public class MyThirdProgram {
    public static void main(String[] args) {
      Points p1 = new Points(4, 0);
      Points p2 = new Points(3, 6);
      System.out.println("Расстояние между двумя точками равно " + p1.distance(p2));
    }
  }

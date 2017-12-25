package ru.stqa.Anna.sandbox;

public class MySecondProgram {
  public static void main(String[] args){
    Point p1=new Point(4,0);
    Point p2=new Point(3,6);
    System.out.println("Рассояние между двумя точками равно " + distance(p1,p2));
  }
  public static double distance(Point p1,Point p2){
    return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
  }

}

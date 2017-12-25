package ru.stqa.Anna.sandbox;

public class Points {
  public double x;
  public double y;

  public  Points(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Points p2){

    return Math.sqrt((this.x-p2.x)*(this.x-p2.x)+(this.y-p2.y)*(this.y-p2.y));
  }

}

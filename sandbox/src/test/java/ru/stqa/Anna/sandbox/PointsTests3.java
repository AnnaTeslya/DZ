package ru.stqa.Anna.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointsTests3 {
  @Test
  public  void testdistance(){
    Points p1=new Points(10,10);
    Points p2=new Points(10,10);
    Assert.assertEquals(p1.distance(p2),0.0 );
  }
}

package ru.stqa.Anna.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointsTest2 {
  @Test
  public void testdistanceError(){
    Points p1 = new Points(10,10);
    Points p2 = new Points(10,10);
    Assert.assertEquals(p1.distance(p2), 999999);
  }
}

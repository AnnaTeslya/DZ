package ru.stqa.Anna.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.GroupDate;

public class GroupModificationTest extends TestBase {
 @Test
  public void testGroupModification(){
   app.getNavigationHelper().gotoGroupPage();
  int before = app.getGroupHelper().getGroupCount();
  if(! app.getGroupHelper().isThereAGroup()){
   app.getGroupHelper().createGroup(new GroupDate("test101", null,null));
  }
   app.getGroupHelper().selectGroup();
   app.getGroupHelper().initGroupModification();
   app.getGroupHelper().fillGroupForm(new GroupDate("Grouppaaa", null, "mOBILE"));
   app.getGroupHelper().submitGroupModification();
   app.getGroupHelper().returnGroupPage();
  int after = app.getGroupHelper().getGroupCount();
  Assert.assertEquals(before,after);
 }


}

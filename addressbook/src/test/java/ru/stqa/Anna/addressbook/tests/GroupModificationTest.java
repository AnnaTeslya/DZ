package ru.stqa.Anna.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.GroupDate;

import java.util.List;

public class GroupModificationTest extends TestBase {
 @Test
  public void testGroupModification(){
   app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
   app.getGroupHelper().createGroup(new GroupDate("test101", null,null));
  }
  List<GroupDate> before = app.getGroupHelper().getGroupList();
   app.getGroupHelper().selectGroup(before.size()-1);
   app.getGroupHelper().initGroupModification();
   app.getGroupHelper().fillGroupForm(new GroupDate("Grouppaaa", null, "mOBILE"));
   app.getGroupHelper().submitGroupModification();
   app.getGroupHelper().returnGroupPage();
  List<GroupDate> after = app.getGroupHelper().getGroupList();
  Assert.assertEquals(before.size(),after.size());
 }


}

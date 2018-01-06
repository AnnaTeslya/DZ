package ru.stqa.Anna.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.GroupDate;

public class GroupModificationTest extends TestBase {
 @Test
  public void testGroupModification(){
   app.getNavigationHelper().gotoGroupPage();
   app.getGroupHelper().selectGroup();
   app.getGroupHelper().initGroupModification();
   app.getGroupHelper().fillGroupForm(new GroupDate("test100", "test", "test"));
   app.getGroupHelper().submitGroupModification();
   app.getGroupHelper().returnGroupPage();
 }


}

package ru.stqa.Anna.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.GroupDate;

import java.util.*;

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
   GroupDate group = new GroupDate(before.get(before.size()-1).getId(),"Grouppaaa", null, "mOBILE");
   app.getGroupHelper().fillGroupForm(group);
   app.getGroupHelper().submitGroupModification();
   app.getGroupHelper().returnGroupPage();
  List<GroupDate> after = app.getGroupHelper().getGroupList();
  Assert.assertEquals(before.size(),after.size());

  before.remove(before.size() -1);
  before.add(group);
  Comparator<? super GroupDate> byId=(g1,g2) ->Integer.compare(g1.getId(),g2.getId());
  before.sort(byId);
  after.sort(byId);
  Assert.assertEquals(before,after);
 }


}

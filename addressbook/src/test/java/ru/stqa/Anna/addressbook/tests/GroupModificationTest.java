package ru.stqa.Anna.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.GroupDate;

import java.util.*;

public class GroupModificationTest extends TestBase {


@BeforeTest
public void ensurePreconditions(){
 app.getNavigationHelper().gotoGroupPage();
 if(! app.getGroupHelper().isThereAGroup()){
  app.getGroupHelper().createGroup(new GroupDate("test101", null,null));
 }
 }

 @Test
  public void testGroupModification(){
  List<GroupDate> before = app.getGroupHelper().getGroupList();
  int index = before.size()-1;
  GroupDate group = new GroupDate(before.get(index).getId(),"Grouppaaa", null, "mOBILE");
  app.getGroupHelper().modifyGroup(index, group);
  List<GroupDate> after = app.getGroupHelper().getGroupList();
  Assert.assertEquals(before.size(),after.size());

  before.remove(index);
  before.add(group);
  Comparator<? super GroupDate> byId=(g1,g2) ->Integer.compare(g1.getId(),g2.getId());
  before.sort(byId);
  after.sort(byId);
  Assert.assertEquals(before,after);
 }




}

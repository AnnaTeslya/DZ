package ru.stqa.Anna.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.GroupDate;

import java.util.*;

public class GroupModificationTest extends TestBase {


 @BeforeTest
 public void ensurePreconditions(){
 app.goTo().GroupPage();
 if(app.group().list().size()==0){
  app.group().create(new GroupDate().withName("101"));
 }
 }

 @Test
  public void testGroupModification(){
  List<GroupDate> before = app.group().list();
  int index = before.size()-1;
  GroupDate group = new GroupDate()
          .withId(before.get(index).getId()).withName("testik").withHeader("test1").withFooter("test2");
  app.group().modify(index, group);
  List<GroupDate> after = app.group().list();
  Assert.assertEquals(before.size(),after.size());

  before.remove(index);
  before.add(group);
  Comparator<? super GroupDate> byId=(g1,g2) ->Integer.compare(g1.getId(),g2.getId());
  before.sort(byId);
  after.sort(byId);
  Assert.assertEquals(before,after);
 }




}

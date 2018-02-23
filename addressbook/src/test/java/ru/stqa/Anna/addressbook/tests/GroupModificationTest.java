package ru.stqa.Anna.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.GroupDate;
import ru.stqa.Anna.addressbook.model.Groups;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTest extends TestBase {


 @BeforeTest
 public void ensurePreconditions(){
 app.goTo().GroupPage();
 if(app.group().all().size()==0){
  app.group().create(new GroupDate().withName("101"));
 }
 }

 @Test
  public void testGroupModification(){
  Groups before = app.group().all();
  GroupDate modifiedGroup = before.iterator().next();
    GroupDate group = new GroupDate()
          .withId(modifiedGroup.getId()).withName("testik").withHeader("test1").withFooter("test2");
  app.group().modify(group);
  assertEquals(before.size(),app.group().count());
  Groups after = app.group().all();
  assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
 }




}

package ru.stqa.Anna.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;

import java.util.List;

public class ContactDeletionTest extends TestBase{
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();

    if (app.contact().list().size()==0){
      app.contact().create(new ContactDate("Anna", "Ivanova", "Spain", "80002221113344", "Ivanova@ail.ru"));
    }
  }
  @Test(enabled = false)
  public void testContactDeletion(){
    List<ContactDate> before = app.contact().list();
    app.contact().delete(before);
    app.goTo().homePage();
    List<ContactDate> after = app.contact().list();

    Assert.assertEquals(after.size(),before.size()-1);

    before.remove(before.size()-1);
      Assert.assertEquals(before,after);
    }



}

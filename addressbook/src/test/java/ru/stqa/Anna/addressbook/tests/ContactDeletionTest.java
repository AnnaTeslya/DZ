package ru.stqa.Anna.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;

import java.util.List;
import java.util.Set;

public class ContactDeletionTest extends TestBase{
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();

    if (app.contact().all().size()==0){
      app.contact().create(new ContactDate().withFirstname("Anna").withLastname("Ivanova").withAddress("Spain").withMobile("80002221113344").withEmail("Ivanova@ail.ru"));
    }
  }
  @Test
  public void testContactDeletion(){
    Set<ContactDate> before = app.contact().all();
    ContactDate deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    Set<ContactDate> after = app.contact().all();

    Assert.assertEquals(after.size(),before.size()-1);

    before.remove(deletedContact);
      Assert.assertEquals(before,after);
    }



}

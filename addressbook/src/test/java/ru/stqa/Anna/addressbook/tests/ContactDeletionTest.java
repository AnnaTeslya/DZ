package ru.stqa.Anna.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;

public class ContactDeletionTest extends TestBase{
  @Test
  public void testContactDeletion(){
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactDate("Anna", "Ivanova", "Spain", "80002221113344", "Ivanova@ail.ru"));
    }
    app.getContactHelper().selectContact(0);
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().closeAlert();
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();

    Assert.assertEquals(after,before-1);





  }
}

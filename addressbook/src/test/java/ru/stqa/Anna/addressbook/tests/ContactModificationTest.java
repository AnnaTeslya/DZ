package ru.stqa.Anna.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;

public class ContactModificationTest extends TestBase{
  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactDate("Anna", "Ivanova", "Spain", "80002221113344","Ivanova@ail.ru"));
    }
    app.getContactHelper().selectContact(0);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactDate("masha", "Ivanova", "Spain", "80002221113344", "Ivanova@ail.ru"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnContactPage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(before,after);
  }
}
